package com.objectpartners.plummer.kotlin.calendar.entry

import java.time.LocalDateTime
import java.util.*


data class Appointment( override val id :String = UUID.randomUUID().toString(),
                        override var start: LocalDateTime? = LocalDateTime.now(),
                        override var duration: java.time.Duration?  = java.time.Duration.ZERO,
                        var privateAppointment: Boolean = false): CalendarEntry {

}