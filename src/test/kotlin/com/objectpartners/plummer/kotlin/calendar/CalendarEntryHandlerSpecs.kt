package com.objectpartners.plummer.kotlin.calendar


import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import com.objectpartners.plummer.kotlin.calendar.input.handler.CalendarEntryInputHandler
import org.jetbrains.spek.api.Spek
import java.io.BufferedReader
import java.io.StringReader
import kotlin.test.assertFails


abstract class CalendarEntryHandlerSpecs<E: CalendarEntry, H: CalendarEntryInputHandler<E>> : Spek() {

    abstract fun buildHandler(): H

    init {
        given("New CalenderEntryHandler") {
            val handler = buildHandler()
            on("empty line") {
                val source = BufferedReader(StringReader("\n"))
                it("should fail") {
                    assertFails { handler.handle(source) }
                }
            }
            on("invalid date string") {
                val source = BufferedReader(StringReader("BAD DATE\r\n"))
                it("should fail") {
                    assertFails { handler.handle(source) }
                }
            }
        }
    }
}