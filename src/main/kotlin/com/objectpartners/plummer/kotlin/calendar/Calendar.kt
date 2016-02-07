package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import java.util.*


class Calendar {
    val entries: MutableCollection<CalendarEntry> = HashSet();
}