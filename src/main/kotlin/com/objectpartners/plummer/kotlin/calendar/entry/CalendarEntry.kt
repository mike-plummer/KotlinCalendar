package com.objectpartners.plummer.kotlin.calendar.entry

import java.time.Duration
import java.time.LocalDateTime
import java.util.*


interface CalendarEntry {
    var start: LocalDateTime?
    var duration: Duration?

    fun getId(): String {
        return UUID.randomUUID().toString()
    }
}