package gg.solar.flow.ui.component.renderer

import gg.solar.flow.event.input.keyboard.KeyboardEvent
import gg.solar.flow.event.input.mouse.MouseEvent
import gg.solar.flow.input.mouse.MousePosition
import gg.solar.flow.scene.canvas.Canvas

interface IGlobalComponent : IGlobalRender {

    fun onMouseEvent(mouseEvent: MouseEvent)

    fun onKeyboardEvent(keyboardEvent: KeyboardEvent)

    fun onUpdateEvent(mousePosition: MousePosition, canvas: Canvas)
}