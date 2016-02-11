package com.objectpartners.plummer.kotlin.calendar.entry

import java.time.Duration
import java.time.LocalDateTime

/**
 * Represents an event that may be recorded on a *Calendar*. The event has a start
 * date & time, a duration, and an unique identifier.
 */
interface CalendarEntry {
    var start: LocalDateTime?
    var duration: Duration?
    val id : String
}