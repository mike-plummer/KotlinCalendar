package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import com.objectpartners.plummer.kotlin.calendar.input.Command
import com.objectpartners.plummer.kotlin.calendar.input.handler.AppointmentInputHandler
import com.objectpartners.plummer.kotlin.calendar.input.handler.CalendarEntryInputHandler
import com.objectpartners.plummer.kotlin.calendar.input.handler.MeetingInputHandler
import java.util.*

fun main(args: Array<String>) {
    println("Hello world")

    val calendar = Calendar()
    val commands = Command.values().map { it.name }.joinToString() { it }
    val input = Scanner(System.`in`)
    executionLoop@ while (true) {
        try {
            println("Command ($commands): ")
            val command = Command.valueOf(input.nextLine())
            when (command) {
                Command.CREATE -> {
                    println("(A)ppointment or (M)eeting? ")
                    val handler: CalendarEntryInputHandler<CalendarEntry>
                    when (input.nextLine()) {
                        "a", "A", "Appointment" -> handler = AppointmentInputHandler()
                        "m", "M", "Meeting" -> handler = MeetingInputHandler()

                        else -> throw IllegalArgumentException("Invalid choice")
                    }
                    calendar.entries += handler.handle()
                    println("${handler.type} added.")
                }
                Command.DELETE -> {
                    val idToDelete = input.nextLine()
                    calendar.entries.removeAll { it.id == idToDelete }
                }
                Command.LIST -> {
                    println("Calendar entries\n----------------")
                    println()
                    calendar.entries.forEach { println(it) }
                }
                Command.EXIT -> {
                    break@executionLoop
                }
            }
        } catch (e : Exception) {
            println("Parse error: ${e.message}")
        }
    }
}
