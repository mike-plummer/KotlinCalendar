package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.Appointment
import java.util.*


class AppointmentInputHandler: CalendarEntryInputHandler<Appointment>() {
    override final val type: String = "Appointment"

    override fun buildInstance(): Appointment {
        return Appointment()
    }

    override fun handle(): Appointment {
        val appointment: Appointment = super.handle()
        print("\tPrivate? ")
        val input: Scanner = Scanner(System.`in`)
        appointment.privateAppointment = input.nextBoolean()
        return appointment
    }
}