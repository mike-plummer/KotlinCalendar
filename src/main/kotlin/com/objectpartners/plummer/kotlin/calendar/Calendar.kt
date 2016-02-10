package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import java.util.*


class Calendar {

    companion object Info {
        @JvmStatic
        fun info(): String {
            return """
Simple implementation of a Calendar that allows creating, displaying, and deleting Meetings and Appointments.
- Meetings have a start date & time, duration, and optional list of attendees.
- Appointments have a start date & time, duration, and an indicator if the appointment is private.
"""
        }
    }
    val entries: MutableCollection<CalendarEntry> = HashSet();
}