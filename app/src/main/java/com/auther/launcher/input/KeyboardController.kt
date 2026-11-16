package com.auther.launcher.input

class KeyboardController {

    private val pressedKeys = mutableSetOf<Int>()

    fun pressKey(keyCode: Int) {
        pressedKeys.add(keyCode)
    }

    fun releaseKey(keyCode: Int) {
        pressedKeys.remove(keyCode)
    }

    fun isPressed(keyCode: Int): Boolean {
        return keyCode in pressedKeys
    }

    fun releaseAll() {
        pressedKeys.clear()
    }

    fun getPressedKeys(): Set<Int> {
        return pressedKeys.toSet()
    }
}
