package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import java.io.BufferedReader
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


abstract class CalendarEntryInputHandler<out T: CalendarEntry>(): InputHandler<CalendarEntry> {

    abstract val type: String

    private final val pattern: String = "yyyy-MM-dd HH:mm:ss";
    private final val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(pattern)

    /**
     * Parses a string in `HH:mm:ss` format and appends those values to this [Duration].
     *
     * This is an example of an Extension function - it adds a new function to *Durations* without having to subclass
     */
    fun Duration.parseHMS(value: String): Duration {
        val durationTokens: List<String> = value.split(":")
        return this.plusHours(durationTokens[0].toLong())
                   .plusMinutes(durationTokens[1].toLong())
                   .plusSeconds(durationTokens[2].toLong())
    }

    override fun handle(source: BufferedReader): T {
        println("-- $type entry --")

        print("\tStart time ($pattern): ")
        val startString = source.readLine()
        val start = if (startString.isBlank()) LocalDateTime.now() else LocalDateTime.from(formatter.parse(startString))

        print("\tDuration (HH:mm:ss): ")
        val duration = Duration.ZERO.parseHMS(source.readLine())

        val entry: T = buildInstance()
        return entry.apply { this.start = start
                             this.duration = duration }
    }

    abstract fun buildInstance() : T
}