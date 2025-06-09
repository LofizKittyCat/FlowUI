package gg.solar.flow.impl.scene

import gg.solar.flow.event.input.keyboard.KeyboardEvent
import gg.solar.flow.event.input.mouse.MouseEvent
import gg.solar.flow.input.mouse.MousePosition
import gg.solar.flow.scene.FlowScene
import gg.solar.flow.scene.canvas.Canvas
import gg.solar.flow.ui.component.Component

class FlowSceneImpl(private var scene: (FlowSceneImpl) -> Component) : FlowScene {

    private var components = mutableListOf<Component>()

    override fun init() {
        components.add(scene.invoke(this))
    }

    override fun render(mousePosition: MousePosition, canvas: Canvas) {

    }

    override fun onMouseEvent(mouseEvent: MouseEvent) {

    }

    override fun onKeyboardEvent(keyboardEvent: KeyboardEvent) {

    }

    fun Create(r: () -> Component): Component {
        components.add(r.invoke())
        return r.invoke()
    }
}