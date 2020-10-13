package ru.job4j.tracker

internal class ShowAction : Action {
    override fun name() : String = "Show all items"

    override fun execute(input : Input, tracker : ITracker) : Boolean {
        val items = tracker.findAll()
        for ((id, name) in items) {
            println("$name $id")
        }
        return true
    }
}
