package ru.job4j.tracker

internal interface Action {
    fun name() : String

    fun execute(input : Input, tracker : ITracker) : Boolean
}
