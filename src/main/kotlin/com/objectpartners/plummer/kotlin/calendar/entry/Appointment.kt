package com.objectpartners.plummer.kotlin.calendar.entry

import java.time.LocalDateTime
import com.objectpartners.plummer.kotlin.calendar.*

/**
 * Represents a single-person [CalendarEntry] with an optional 'private' indicator
 */
data class Appointment( override var start: LocalDateTime? = LocalDateTime.now(),
                        override var duration: java.time.Duration?  = java.time.Duration.ZERO,
                        var privateAppointment: Boolean = false): CalendarEntry {

    override val id: String by IdDelegate()

    override fun toString(): String {
        return """[
  Appointment: $id
    Start: $start
    Duration: ${duration?.prettyPrint()}
    Private: $privateAppointment
]"""
    }
}