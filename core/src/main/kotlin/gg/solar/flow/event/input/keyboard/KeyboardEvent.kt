package gg.solar.flow.event.input.keyboard

class KeyboardEvent(eventKey: Int, type: KeyboardEventType)

enum class KeyboardEventType {
    PRESS,
    RELEASE,
    HOLD
}