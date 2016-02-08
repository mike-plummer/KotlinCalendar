package com.objectpartners.plummer.kotlin.calendar.entry

import java.util.*
import kotlin.reflect.KProperty

class IdDelegate {
    val id: String = UUID.randomUUID().toString().replace("-", "")

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return id
    }
}