package gg.solar.flow.event.input.mouse

import gg.solar.flow.input.mouse.MousePosition

class MouseEvent(val button: Int, val type: MouseEventType, val mousePosition: MousePosition)

enum class MouseEventType {
    PRESS,
    RELEASE,
    SCROLL
}