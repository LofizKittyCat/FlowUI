package gg.solar.flow.scene.canvas

import gg.solar.flow.renderer.nanovg.RenderContext
import java.awt.Color

interface Canvas {

    fun drawRect(x: Float, y: Float, w: Float, h: Float, color: Color) = getContext().drawRect(x, y, w, h, color)

    fun drawRoundedRect(x: Float, y: Float, w: Float, h: Float, radius: Float, color: Color) = getContext().drawRoundedRect(x, y, w, h, radius, color)

    fun drawOutline(x: Float, y: Float, w: Float, h: Float, outlineW: Float, color: Color) = getContext().drawOutline(x, y, w, h, outlineW, color)

    fun drawRoundedOutline(x: Float, y: Float, w: Float, h: Float, outlineW: Float, radius: Float, color: Color) = getContext().drawRoundedOutline(x, y, w, h, outlineW, radius, color)

    fun getContext(): RenderContext

    fun getCanvasWidth(): Float

    fun getCanvasHeight(): Float
}