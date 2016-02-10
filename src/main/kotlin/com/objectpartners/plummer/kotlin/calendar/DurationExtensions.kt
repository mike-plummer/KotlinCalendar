package com.objectpartners.plummer.kotlin.calendar

import java.time.Duration
import java.time.temporal.ChronoUnit

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

/**
 * Outputs a [Duration] in a friendlier format than [Duration.toString]
 */
fun Duration.prettyPrint(): String {
    return "${toHours()}:${toMinutes() % 60}:${get(ChronoUnit.SECONDS) % 60}"
}
