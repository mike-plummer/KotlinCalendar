package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import java.util.*

/**
 * Manages a collection of [CalendarEntry].
 */
class Calendar {

    // Use a companion object to give Calendar a 'static' method of 'Info'
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

    // Define a collection that cannot be replaced but allows its contents to be modified
    val entries: MutableCollection<CalendarEntry> = HashSet();
}