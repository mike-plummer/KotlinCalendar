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
    val commands = Command.values().map { it.name }.joinToString() { it }
    val source = BufferedReader(InputStreamReader(System.`in`))
    executionLoop@ while (true) {
        try {
            print("Command ($commands): ")
            when (Command.valueOf(source.readLine().toUpperCase())) {
                Command.CREATE -> {
                    print("(A)ppointment or (M)eeting? ")
                    val handler: CalendarEntryInputHandler<CalendarEntry>
                    when (source.readLine().toLowerCase()) {
                        "a", "appointment" -> handler = AppointmentInputHandler()
                        "m", "meeting" -> handler = MeetingInputHandler()
                        else -> throw IllegalArgumentException("Invalid choice")
                    }
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
