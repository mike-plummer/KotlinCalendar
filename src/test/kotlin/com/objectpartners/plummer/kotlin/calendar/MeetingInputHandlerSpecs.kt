package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.Meeting
import com.objectpartners.plummer.kotlin.calendar.input.handler.MeetingInputHandler
import java.io.BufferedReader
import java.io.StringReader
import java.time.Duration
import java.time.temporal.ChronoUnit
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue


class MeetingInputHandlerSpecs : CalendarEntryHandlerSpecs<Meeting, MeetingInputHandler>() {

    override fun buildHandler(): MeetingInputHandler {
        return MeetingInputHandler()
    }

    init {
        given("New MeetingInputHandler") {
            val handler = buildHandler()
            on("new line, valid duration string, 'Done'") {
                val source = BufferedReader(StringReader("\r\n01:00:00\r\nJoe\r\nDone\r\n"))
                it("should succeed") {
                    val meeting = handler.handle(source)
                    assertNotNull(meeting)
                    assertTrue(meeting.duration == Duration.of(1, ChronoUnit.HOURS))
                    assertEquals(meeting.attendees.size, 1)
                }
            }
        }
    }
}