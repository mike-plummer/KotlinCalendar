package com.objectpartners.plummer.kotlin.calendar.entry

import java.time.Duration
import java.time.LocalDateTime


interface CalendarEntry {
    var start: LocalDateTime?
    var duration: Duration?
    val id : String
}