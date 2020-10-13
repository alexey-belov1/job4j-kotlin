package ru.job4j.tracker

internal class CreateAction : Action {
    override fun name() : String = "Add new Item"

    override fun execute(input : Input, tracker : ITracker) : Boolean {
        val name = input.askStr("Enter name: ")
        val item = Item(name = name)
        tracker.add(item)
        return true
    }
}