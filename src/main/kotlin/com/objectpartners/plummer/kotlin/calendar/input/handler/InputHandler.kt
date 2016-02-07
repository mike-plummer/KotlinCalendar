package com.objectpartners.plummer.kotlin.calendar.input.handler


interface InputHandler<O> {
    fun handle(): O
}