package gg.solar.flow.ui.component.impl

import gg.solar.flow.event.input.mouse.MouseEvent
import gg.solar.flow.event.input.mouse.MouseEventType
import gg.solar.flow.ui.component.Component

class Button(val text: String, val onClick: () -> Unit) : Component() {

    override fun onMouseEvent(mouseEvent: MouseEvent) {
        if(mouseEvent.type == MouseEventType.RELEASE) {
            onClick.invoke()
        }
    }
}