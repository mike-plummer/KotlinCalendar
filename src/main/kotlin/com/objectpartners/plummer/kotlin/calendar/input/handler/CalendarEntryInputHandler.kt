package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.CalendarEntry
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


abstract class CalendarEntryInputHandler<out T: CalendarEntry>: InputHandler<CalendarEntry> {

    abstract val type: String

    private final val pattern: String = "yyyy-MM-dd HH:mm:ss";
    private final val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(pattern)

    /**
     * Extension function - this adds a new function to Duration objects without having to subclass Duration
     */
    fun Duration.parseHMS(value: String): Duration {
        val durationTokens: List<String> = value.split(":")
        return this.plusHours(durationTokens[0].toLong())
                   .plusMinutes(durationTokens[1].toLong())
                   .plusSeconds(durationTokens[2].toLong())
    }

    override fun handle(): T {
        val input = Scanner(System.`in`)
        println("-- $type entry --")

        print("\tStart time ($pattern): ")
        val startString = input.nextLine()
        val start = if (startString.isBlank()) LocalDateTime.now() else LocalDateTime.from(formatter.parse(startString))

        print("\tDuration (HH:mm:ss): ")
        val duration = Duration.ZERO.parseHMS(input.nextLine())

        val entry: T = buildInstance()
        return entry.apply { this.start = start
                             this.duration = duration }
    }

    abstract fun buildInstance() : T
}