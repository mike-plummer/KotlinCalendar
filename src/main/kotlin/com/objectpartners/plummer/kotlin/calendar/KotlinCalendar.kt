package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import com.objectpartners.plummer.kotlin.calendar.input.Command
import com.objectpartners.plummer.kotlin.calendar.input.handler.AppointmentInputHandler
import com.objectpartners.plummer.kotlin.calendar.input.handler.CalendarEntryInputHandler
import com.objectpartners.plummer.kotlin.calendar.input.handler.MeetingInputHandler
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {

    val calendar = Calendar()
    // Build a comma-separated list of supported commands the user can input
    // Lambdas use the implicit arg name 'it' like in Groovy but this can be overridden with 'x ->' syntax
    val commands = Command.values().map { it.name }.joinToString() { it }
    // Build an input source based on System.in
    val source = BufferedReader(InputStreamReader(System.`in`))
    // So long as the user doesn't input the EXIT command...
    executionLoop@ while (true) {
        try {
            print("Command ($commands): ")
            // Analogue to the C/Java 'switch' statement, but less terrible
            when (Command.valueOf(source.readLine().toUpperCase())) {
                Command.CREATE -> {
                    print("(A)ppointment or (M)eeting? ")
                    val handler: CalendarEntryInputHandler<CalendarEntry>
                    when (source.readLine().toLowerCase()) {
                        "a", "appointment" -> handler = AppointmentInputHandler()
                        "m", "meeting" -> handler = MeetingInputHandler()
                        else -> throw IllegalArgumentException("Invalid choice")
                    }
                    // Build new calendar entry using the appropriate handler instance
                    // Add to a collection using one of operators Collection overrides
                    calendar.entries += handler.handle(source)
                    println("${handler.type} added.")
                }
                Command.DELETE -> {
                    print("ID to delete: ")
                    val idToDelete = source.readLine()
                    calendar.entries.removeAll { it.id == idToDelete }
                }
                Command.INFO -> {
                    println(Calendar.info())
                }
                Command.LIST -> {
                    // Print a multi-line string - note that formatting is included EXACTLY as it is here so any identing
                    // will result in extra spaces in your string
                    println("""
----------------------
-- Calendar entries --
----------------------
""")
                    calendar.entries.forEach { println(it) }
                    println("----------------------")
                }
                Command.EXIT -> {
                    println("Goodbye!")
                    break@executionLoop
                }
            }
        } catch (e : Exception) {
            println("Parse error: ${e.message}")
        }
    }
}
