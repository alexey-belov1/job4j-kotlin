package ru.job4j.tracker

internal class ExitAction : Action {
    override fun name() : String = "Exit Program"

    override fun execute(input : Input, tracker : ITracker) : Boolean {
        return false
    }
}
