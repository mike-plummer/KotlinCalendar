package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.Appointment
import java.io.BufferedReader


class AppointmentInputHandler(): CalendarEntryInputHandler<Appointment>() {
    override final val type: String = "Appointment"

    override fun buildInstance(): Appointment {
        return Appointment()
    }

    override fun handle(source: BufferedReader): Appointment {
        val appointment: Appointment = super.handle(source)
        // Read boolean from the source for private indicator
        print("\tPrivate? (True/False) ")
        appointment.privateAppointment = source.readLine().toBoolean()
        return appointment
    }
}