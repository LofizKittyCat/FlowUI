package gg.solar.flow.scene

import gg.solar.flow.event.input.keyboard.KeyboardEvent
import gg.solar.flow.event.input.mouse.MouseEvent
import gg.solar.flow.input.mouse.MousePosition
import gg.solar.flow.scene.canvas.Canvas

interface FlowScene {

    fun init()

    fun render(mousePosition: MousePosition, canvas: Canvas)

    fun onMouseEvent(mouseEvent: MouseEvent)

    fun onKeyboardEvent(keyboardEvent: KeyboardEvent)
}