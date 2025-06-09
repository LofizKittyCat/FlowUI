package gg.solar.flow.input.mouse

interface MouseInput {

    companion object {

        val LEFT = 0

        val RIGHT = 1

        val SCROLL_BUTTON = 2
    }

    fun isButtonDown(button: Int): Boolean
}