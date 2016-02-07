package com.objectpartners.plummer.kotlin.calendar.input.handler

import com.objectpartners.plummer.kotlin.calendar.entry.Appointment
import java.util.*


class AppointmentInputHandler: CalendarEntryInputHandler<Appointment>() {
    override fun type(): String {
        return "Appointment"
    }

    override fun buildInstance(): Appointment {
        return Appointment()
    }

    override fun handle(): Appointment {
        val appointment: Appointment = super.handle()
        println("Private? ")
        val input: Scanner = Scanner(System.`in`)
        appointment.privateAppointment = input.nextLine().toBoolean()
        return appointment
    }
}