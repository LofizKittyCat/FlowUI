package gg.solar.app

import gg.solar.flow.impl.scene.FlowSceneImpl
import gg.solar.flow.ui.component.Component
import gg.solar.flow.ui.component.impl.Button
import gg.solar.flow.ui.component.impl.Div
import java.awt.Color

fun App(): FlowSceneImpl = FlowSceneImpl { scene ->

    scene.Create {
        Div().
            size<Component>(1920f, 1080f).
            background<Component>(Color(10, 10, 10)).Create { background ->
                Button(
                    text = "Click Me!",
                    onClick = {
                        println("Flow Button Clicked!")
                    }
                ).size<Component> { 10f }.
                radius<Component> { 5f }.center(background)
        }
    }.Render { mousePosition, canvas ->

    }
}
