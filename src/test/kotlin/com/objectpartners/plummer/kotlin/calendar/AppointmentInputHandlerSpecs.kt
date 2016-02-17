package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.Appointment
import com.objectpartners.plummer.kotlin.calendar.input.handler.AppointmentInputHandler
import org.jetbrains.spek.api.shouldBeTrue
import org.jetbrains.spek.api.shouldNotBeNull
import java.io.BufferedReader
import java.io.StringReader
import java.time.Duration
import java.time.temporal.ChronoUnit


class AppointmentInputHandlerSpecs : CalendarEntryHandlerSpecs<Appointment, AppointmentInputHandler>() {

    override fun buildHandler(): AppointmentInputHandler {
        return AppointmentInputHandler()
    }

    init {
        given("New AppointmentInputHandler") {
            val handler = buildHandler()
            on("new line, valid duration string, 'Done'") {
                val source = BufferedReader(StringReader("\r\n01:00:00\r\ntrue\r\n"))
                it("should succeed") {
                    val appointment = handler.handle(source)
                    shouldNotBeNull(appointment)
                    shouldBeTrue(appointment.duration == Duration.of(1, ChronoUnit.HOURS))
                    shouldBeTrue(appointment.privateAppointment)
                }
            }
        }
    }
}