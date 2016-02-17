package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.Meeting
import com.objectpartners.plummer.kotlin.calendar.input.handler.MeetingInputHandler
import org.jetbrains.spek.api.shouldBeTrue
import org.jetbrains.spek.api.shouldEqual
import org.jetbrains.spek.api.shouldNotBeNull
import java.io.BufferedReader
import java.io.StringReader
import java.time.Duration
import java.time.temporal.ChronoUnit


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
                    shouldNotBeNull(meeting)
                    shouldBeTrue(meeting.duration == Duration.of(1, ChronoUnit.HOURS))
                    shouldEqual(meeting.attendees.size, 1)
                }
            }
        }
    }
}