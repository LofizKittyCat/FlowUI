package gg.solar.flow.ui.math

class Measurement(var x: Float, var y: Float) {

    fun set(x: Float, y: Float) = apply {
        this.x = x
        this.y = y
    }
}