package com.objectpartners.plummer.kotlin.calendar.input.handler

import java.io.BufferedReader


interface InputHandler<O> {
    fun handle(source: BufferedReader): O
}