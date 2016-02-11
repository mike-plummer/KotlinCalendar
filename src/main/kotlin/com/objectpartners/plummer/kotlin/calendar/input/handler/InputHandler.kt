package com.objectpartners.plummer.kotlin.calendar.input.handler

import java.io.BufferedReader


interface InputHandler<O> {
    /**
     * Read input from the supplied [BufferedReader] to generate a populated instance
     * of [O].
     */
    fun handle(source: BufferedReader): O
}