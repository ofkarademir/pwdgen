package com.ofk.pwdgen.utils

import java.util.Random

class PasswordGenerator {

    private val passwordCharacters = "AaBbCcDdEeFfGgHhIi12i3J4j5KkL678lMm9N0nOoPpR!rSs'TtUu^+VvY%yZz&Ww/X(x)Q=q?_-"
    private val random = Random()

    fun generatePassword(length: Int, withSymbols: Boolean = true): String {
        val passwordBuilder = StringBuilder()
        for (i in 0 until length) {
            passwordBuilder.append(randomChar(passwordCharacters))
        }
        return passwordBuilder.toString()
    }


    private fun randomChar(charList: String): Char {
        val index = random.nextInt(charList.length)
        return charList[index]
    }
}