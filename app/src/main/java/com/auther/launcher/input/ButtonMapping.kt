package com.auther.launcher.input

class ButtonMapping {

    private val mappings = mutableMapOf<String, Int>()

    fun setMapping(button: String, keyCode: Int) {
        mappings[button] = keyCode
    }

    fun getMapping(button: String): Int? {
        return mappings[button]
    }

    fun removeMapping(button: String) {
        mappings.remove(button)
    }

    fun getAllMappings(): Map<String, Int> {
        return mappings.toMap()
    }

    fun reset() {
        mappings.clear()
    }
}
