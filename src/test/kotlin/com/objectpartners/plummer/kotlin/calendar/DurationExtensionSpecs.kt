package com.objectpartners.plummer.kotlin.calendar

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual
import java.time.Duration
import java.time.temporal.ChronoUnit

class DurationExtensionSpecs: Spek() {
    init {
        given("Populated Duration") {
            val duration = Duration.ZERO.plusHours(2).plusMinutes(5).plusSeconds(12)
            on("calling prettyPrint") {
                it("should generate correct value") {
                    shouldEqual(duration.prettyPrint(), "2:5:12")
                }
            }
        }
        given("Zero Duration") {
            val duration = Duration.ZERO
            on("parsing HMS string") {
                val modifiedDuration = duration.parseHMS("01:02:03")
                it("should remain unchanged") {
                    duration == Duration.ZERO
                }
                it("should yield a new Duration with correct values") {
                    shouldEqual(modifiedDuration.toHours(), 1)
                    shouldEqual(modifiedDuration.toMinutes() % 60, 2)
                    shouldEqual(modifiedDuration.get(ChronoUnit.SECONDS) % 60, 3)
                }
            }
        }
    }
}
