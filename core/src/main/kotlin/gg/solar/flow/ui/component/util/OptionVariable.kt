package gg.solar.flow.ui.component.util

import java.awt.Color

class OptionVariable(var enableOption: Boolean, var variable: Any?) {

    fun set(variable: Any) = apply {
        this.enableOption = true
        this.variable = variable
    }

    fun toInt(): Int = variable!! as Int

    fun toFloat(): Float = variable!! as Float

    fun toColor(): Color = variable!! as Color
}