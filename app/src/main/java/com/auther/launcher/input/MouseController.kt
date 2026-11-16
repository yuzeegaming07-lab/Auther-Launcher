package com.auther.launcher.input

data class MousePosition(
    val x: Float = 0f,
    val y: Float = 0f
)

class MouseController {

    var position = MousePosition()
        private set

    var isCaptured = false
        private set

    fun move(deltaX: Float, deltaY: Float) {
        position = MousePosition(
            x = position.x + deltaX,
            y = position.y + deltaY
        )
    }

    fun capture() {
        isCaptured = true
    }

    fun release() {
        isCaptured = false
    }

    fun reset() {
        position = MousePosition()
    }
}
