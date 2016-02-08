package com.objectpartners.plummer.kotlin.calendar.entry

import java.time.LocalDateTime
import java.util.*


data class Meeting( override var start: LocalDateTime? = LocalDateTime.now(),
                    override var duration: java.time.Duration? = java.time.Duration.ZERO,
                    val attendees: MutableSet<String> = HashSet()): CalendarEntry {
    override val id: String by IdDelegate()
}