package gg.solar.flow.renderer.nanovg

import org.lwjgl.nanovg.NVGColor
import org.lwjgl.nanovg.NVGPaint
import org.lwjgl.nanovg.NanoVG
import java.awt.Color

class RenderContext(var context: Long) {

    fun drawRect(x: Float, y: Float, w: Float, h: Float, color: Color) = path {
        NanoVG.nvgRect(context, x, y, w, h)
        fillColor(color)
    }

    fun drawRoundedRect(x: Float, y: Float, w: Float, h: Float, radius: Float, color: Color) = path {
        NanoVG.nvgRoundedRect(context, x, y, w, h, radius)
        fillColor(color)
    }

    fun drawOutline(x: Float, y: Float, w: Float, h: Float, outlineW: Float, color: Color) = path {
        NanoVG.nvgRect(context, x, y, w, h)
        NanoVG.nvgStroke(context)
        NanoVG.nvgStrokeWidth(context, outlineW)
        NanoVG.nvgStrokeColor(context, colorToNvgColor(color))
    }

    fun drawRoundedOutline(x: Float, y: Float, w: Float, h: Float, outlineW: Float, radius: Float, color: Color) = path {
        NanoVG.nvgRoundedRect(context, x, y, w, h, radius)
        NanoVG.nvgStroke(context)
        NanoVG.nvgStrokeWidth(context, outlineW)
        NanoVG.nvgStrokeColor(context, colorToNvgColor(color))
    }

    fun path(r: () -> Unit) {
        NanoVG.nvgBeginPath(context)
        r.invoke()
        NanoVG.nvgClosePath(context)
    }

    fun fillColor(color: Color) {
        NanoVG.nvgFill(context)
        NanoVG.nvgFillColor(context, colorToNvgColor(color))
    }

    fun fillPaint(paint: NVGPaint) {
        NanoVG.nvgFill(context)
        NanoVG.nvgFillPaint(context, paint)
    }

    fun colorToNvgColor(color: Color): NVGColor {
        return NVGColor.calloc().r(color.red / 255f).g(color.green / 255f).b(color.blue / 255f).a(color.alpha / 255f)
    }
}