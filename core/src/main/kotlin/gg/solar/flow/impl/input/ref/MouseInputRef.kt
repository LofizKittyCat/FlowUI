package gg.solar.flow.impl.input.ref

import gg.solar.flow.impl.Manager
import gg.solar.flow.input.mouse.MouseInput

object MouseInputRef {

    fun getInstance(): MouseInput {
        return Manager.input.getMouseInput()
    }
}