package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


abstract class CalendarEntryInputHandler<out T: CalendarEntry>: InputHandler<CalendarEntry> {

    abstract val type: String

    override fun handle(): T {
        val input = Scanner(System.`in`)
        println("$type entry")
        val pattern = "yyyy-MM-d HH:mm:ss"
        val formatter = DateTimeFormatter.ofPattern(pattern);

        println("Start time ($pattern): ")
        val start = LocalDateTime.from(formatter.parse(input.nextLine()))
        println("Duration (HH:mm:ss): ")
        val durationTokens: List<String> = input.nextLine().split(":")
        val duration = Duration.ofHours(durationTokens[0].toLong()).plusMinutes(durationTokens[1].toLong()).plusSeconds(durationTokens[2].toLong())

        val entry: T = buildInstance()
        entry.start = start
        entry.duration = duration
        return entry
    }

    abstract fun buildInstance() : T
}