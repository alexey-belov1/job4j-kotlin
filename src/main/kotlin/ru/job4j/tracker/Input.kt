package ru.job4j.tracker

internal interface Input {
    fun askStr(question : String) : String

    fun askInt(question : String) : Int
}