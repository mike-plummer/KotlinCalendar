package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.Meeting
import java.util.*


class MeetingInputHandler: CalendarEntryInputHandler<Meeting>() {
    override final val type: String = "Meeting"

    override fun buildInstance(): Meeting {
        return Meeting()
    }

    override fun handle(): Meeting {
        val meeting: Meeting = super.handle()
        val input: Scanner = Scanner(System.`in`)
        while (true) {
            println("Add attendee ('Done' when finished): ")
            val attendeeName = input.nextLine()
            if ("Done".equals(attendeeName, true)) {
                break;
            }
            meeting.attendees += attendeeName
            println("Added $attendeeName to meeting")
        }
        return meeting
    }
}