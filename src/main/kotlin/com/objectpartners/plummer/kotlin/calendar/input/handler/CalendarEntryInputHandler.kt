package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


abstract class CalendarEntryInputHandler<T: CalendarEntry>: InputHandler<CalendarEntry> {
    final val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    override fun handle(): T {
        val input = Scanner(System.`in`)
        println(type() + " entry")
        println("Start time (YYYY MM DD HH:mm:ss): ")
        val dttmTokens = input.nextLine().split(" ")
        val timeTokens = dttmTokens[3].split(":")
        val start = LocalDateTime.of(dttmTokens[0].toInt(), dttmTokens[1].toInt(), dttmTokens[2].toInt(), timeTokens[0].toInt(), timeTokens[1].toInt(), timeTokens[2].toInt(), 0)
        println("Duration (HH:mm:ss): ")
        val durationTokens: List<String> = input.nextLine().split(":")
        val duration = Duration.ofHours(durationTokens[0].toLong()).plusMinutes(durationTokens[1].toLong()).plusSeconds(durationTokens[2].toLong())

        val entry: T = buildInstance()
        entry.start = start
        entry.duration = duration
        return entry
    }

    abstract fun type(): String

    abstract fun buildInstance() : T
}