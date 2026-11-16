package com.auther.launcher.input

data class TouchPosition(
    val x: Float = 0f,
    val y: Float = 0f
)

class TouchController {

    var position = TouchPosition()
        private set

    var isTouching = false
        private set

    fun onTouch(x: Float, y: Float) {
        position = TouchPosition(x, y)
        isTouching = true
    }

    fun onRelease() {
        isTouching = false
    }

    fun reset() {
        position = TouchPosition()
        isTouching = false
    }
}
