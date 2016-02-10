package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.Meeting
import org.jetbrains.spek.api.Spek
import java.time.Duration
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DurationExtensionSpecs: Spek() {
    init {
        given("Populated Duration") {
            val duration = Duration.ZERO.plusHours(2).plusMinutes(5).plusSeconds(12)
            on("calling prettyPrint") {
                it("should generate correct value") {
                    assertEquals(duration.prettyPrint(), "2:5:12")
                }
            }
        }
    }
}
