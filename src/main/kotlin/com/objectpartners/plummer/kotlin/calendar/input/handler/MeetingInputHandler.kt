package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.Meeting
import java.io.BufferedReader


class MeetingInputHandler(): CalendarEntryInputHandler<Meeting>() {
    override final val type: String = "Meeting"

    override fun buildInstance(): Meeting {
        return Meeting()
    }

    override fun handle(source: BufferedReader): Meeting {
        val meeting: Meeting = super.handle(source)
        attendeeLoop@ do {
            print("\tAdd attendee ('Done' when finished): ")
            val attendeeName = source.readLine()
            when (attendeeName) {
                "DONE", "Done", "done" -> break@attendeeLoop;
                in meeting.attendees -> println("\t\t$attendeeName is already attending this meeting!")
                else -> {
                    meeting.attendees += attendeeName
                    println("\t\tAdded $attendeeName to meeting")
                }
            }
        } while (true)
        return meeting
    }
}