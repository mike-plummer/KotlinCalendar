package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.Meeting
import java.util.*


class MeetingInputHandler: CalendarEntryInputHandler<Meeting>() {
    override fun type(): String {
        return "Appointment"
    }

    override fun buildInstance(): Meeting {
        return Meeting()
    }

    override fun handle(): Meeting {
        val meeting: Meeting = super.handle()
        while (true) {
            println("Add attendee ('Done' when finished):  ")
            val input: Scanner = Scanner(System.`in`)
            val attendeeName = input.nextLine()
            if ("Done".equals(attendeeName, true)) {
                break;
            }
            meeting.attendees += input.nextLine()
            println("Added $attendeeName to meeting")
        }
        return meeting
    }
}