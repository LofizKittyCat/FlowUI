package gg.solar.flow.ui.component.renderer

import gg.solar.flow.input.mouse.MousePosition
import gg.solar.flow.scene.canvas.Canvas

interface IGlobalRender {

    fun render(mousePosition: MousePosition, canvas: Canvas)
}