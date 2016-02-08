package com.objectpartners.plummer.kotlin.calendar.entry

import java.time.LocalDateTime
import java.util.*


data class Appointment( override var start: LocalDateTime? = LocalDateTime.now(),
                        override var duration: java.time.Duration?  = java.time.Duration.ZERO,
                        var privateAppointment: Boolean = false): CalendarEntry {
    override val id: String by IdDelegate()
}