package com.objectpartners.plummer.kotlin.calendar

import com.objectpartners.plummer.kotlin.calendar.entry.Appointment
import com.objectpartners.plummer.kotlin.calendar.input.handler.AppointmentInputHandler
import java.io.BufferedReader
import java.io.StringReader
import java.time.Duration
import java.time.temporal.ChronoUnit
import kotlin.test.assertNotNull
import kotlin.test.assertTrue


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
                    assertNotNull(appointment)
                    assertTrue(appointment.duration == Duration.of(1, ChronoUnit.HOURS))
                    assertTrue(appointment.privateAppointment)
                }
            }
        }
    }
}