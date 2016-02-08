package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import com.objectpartners.plummer.kotlin.calendar.input.Command
import com.objectpartners.plummer.kotlin.calendar.input.handler.AppointmentInputHandler
import com.objectpartners.plummer.kotlin.calendar.input.handler.CalendarEntryInputHandler
import com.objectpartners.plummer.kotlin.calendar.input.handler.MeetingInputHandler
import java.util.*

fun main(args: Array<String>) {

    val calendar = Calendar()
    val commands = Command.values().map { it.name }.joinToString() { it }
    val input = Scanner(System.`in`)
    executionLoop@ while (true) {
        try {
            print("Command ($commands): ")
            when (Command.valueOf(input.nextLine().toUpperCase())) {
                Command.CREATE -> {
                    print("(A)ppointment or (M)eeting? ")
                    val handler: CalendarEntryInputHandler<CalendarEntry>
                    when (input.nextLine().toLowerCase()) {
                        "a", "appointment" -> handler = AppointmentInputHandler()
                        "m", "meeting" -> handler = MeetingInputHandler()
                        else -> throw IllegalArgumentException("Invalid choice")
                    }
                    calendar.entries += handler.handle()
                    println("${handler.type} added.")
                }
                Command.DELETE -> {
                    print("ID to delete: ")
                    val idToDelete = input.nextLine()
                    calendar.entries.removeAll { it.id == idToDelete }
                }
                Command.LIST -> {
                    println("""
----------------------
-- Calendar entries --
----------------------
""")
                    calendar.entries.forEach { println(it) }
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
