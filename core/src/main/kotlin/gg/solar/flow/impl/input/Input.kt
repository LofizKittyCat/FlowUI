package gg.solar.flow.impl.input

import gg.solar.flow.input.keyboard.KeyboardInput
import gg.solar.flow.input.mouse.MouseInput

interface Input {

    fun getMouseInput(): MouseInput

    fun getKeyboardInput(): KeyboardInput
}