package gg.solar.flow.impl

import gg.solar.flow.impl.input.Input

object Manager {

    lateinit var input: Input

    fun setup(input: Input) {
        this.input = input
    }
}