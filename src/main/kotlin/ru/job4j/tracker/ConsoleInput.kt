package ru.job4j.tracker

import java.util.*

internal class ConsoleInput : Input {

    private val scanner = Scanner(System.`in`)

    override fun askStr(question : String) : String {
        print(question)
        return scanner.nextLine()
    }

    override fun askInt(question : String) : Int {
        return askStr(question).toInt()
    }
}