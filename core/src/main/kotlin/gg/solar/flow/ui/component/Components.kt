package gg.solar.flow.ui.component

import gg.solar.flow.event.input.keyboard.KeyboardEvent
import gg.solar.flow.event.input.mouse.MouseEvent
import gg.solar.flow.event.input.mouse.MouseEventType
import gg.solar.flow.impl.Manager
import gg.solar.flow.impl.input.ref.MouseInputRef
import gg.solar.flow.input.mouse.MousePosition
import gg.solar.flow.scene.canvas.Canvas
import gg.solar.flow.ui.component.renderer.IFocusable
import gg.solar.flow.ui.component.renderer.IGlobalComponent
import gg.solar.flow.ui.component.util.OptionVariable
import gg.solar.flow.ui.component.util.Outline
import gg.solar.flow.ui.math.Measurement
import java.awt.Color

open class Component : IGlobalComponent, IFocusable {

    override var focused: Boolean = false

    override var hovered: Boolean = false

    override var pressed: Boolean = false

    var position: Measurement = Measurement(0f, 0f)
    var scale: Measurement = Measurement(0f, 0f)

    var backgroundOption: OptionVariable = OptionVariable(false, null)

    var cornerRadiusOption: OptionVariable = OptionVariable(false, 0f)

    var fontColorOption: OptionVariable = OptionVariable(false, null)

    var outlineOption: OptionVariable = OptionVariable(false, null)

    lateinit var subComponents: (Component) -> Component

    lateinit var sMousePos: MousePosition
    lateinit var sCanvas: Canvas

    override fun onUpdateEvent(mousePosition: MousePosition, canvas: Canvas) {

        sMousePos = mousePosition
        sCanvas = canvas

        hovered = isMouseOver(mousePosition).also {
            if(::subComponents.isInitialized) {
                !subComponents.invoke(this).isMouseOver(mousePosition)
            }
        }
        pressed = hovered && MouseInputRef.getInstance().isButtonDown(0)
    }

    override fun onMouseEvent(mouseEvent: MouseEvent) {
        if(::subComponents.isInitialized) {
            subComponents.invoke(this).onMouseEvent(mouseEvent)
        }

        if(mouseEvent.type == MouseEventType.PRESS) {
            focused = true
        } else {
            if(mouseEvent.type == MouseEventType.RELEASE) {
                focused = false
            }
        }
    }

    override fun onKeyboardEvent(keyboardEvent: KeyboardEvent) {

    }

    override fun render(mousePosition: MousePosition, canvas: Canvas) {

        if(backgroundOption.enableOption) {
            canvas.drawRoundedRect(position.x, position.y, scale.x, scale.y, cornerRadiusOption.toFloat(), backgroundOption.toColor())
        }

        if(::subComponents.isInitialized) {
            subComponents.invoke(this).render(mousePosition, canvas)
        }

        if(outlineOption.enableOption) {
            var outline = outlineOption.variable as Outline
            canvas.drawRoundedOutline(position.x, position.y, scale.x, scale.y, outline.width, cornerRadiusOption.toFloat(), outline.color)
        }
    }

    fun <T : Component> outline(color: Color, width: Float = 1f): T {
        outlineOption.set(Outline(width, color))
        return this as T
    }

    fun <T : Component> size(width: Float, height: Float): T {
        scale.set(width, height)
        return this as T
    }

    fun <T : Component> size(size: Float): T {
        scale.set(size, size)
        return this as T
    }

    fun <T : Component> size(size: () -> Float): T {
        scale.set(size.invoke(), size.invoke())
        return this as T
    }

    fun <T : Component> position(x: Float, y: Float): T {
        position.set(x, y)
        return this as T
    }

    fun <T : Component> background(color: Color, radius: Float = 0f): T {
        backgroundOption.set(color)
        if(radius > 0) cornerRadiusOption.set(radius)
        return this as T
    }

    fun <T : Component> radius(radius: Float): T {
        cornerRadiusOption.set(radius)
        return this as T
    }

    fun <T : Component> radius(radius: () -> Float): T {
        cornerRadiusOption.set(radius.invoke())
        return this as T
    }

    fun <T : Component> fontColor(color: Color): T {
        fontColorOption.set(color)
        return this as T
    }

    fun <T : Component> fontColor(color: () -> Color): T {
        fontColorOption.set(color.invoke())
        return this as T
    }

    fun <T : Component> Create(r: (Component) -> Component): T {
        subComponents = r
        return this as T
    }

    fun <T : Component> center(parent: Component): T {
        position<T>(
            parent.position.x + parent.scale.x / 2f - scale.x / 2f,
            parent.position.y + parent.scale.y / 2f - scale.y / 2f
        )
        return this as T
    }

    fun <T : Component> Render(r: (MousePosition, Canvas) -> Unit): T {
        r.invoke(sMousePos, sCanvas)
        return this as T
    }

    fun isMouseOver(mousePosition: MousePosition): Boolean {
        return mousePosition.x >= position.x && mousePosition.y >= position.y && mousePosition.x < (position.x + scale.x) && mousePosition.y < (position.y + scale.y)
    }
}