package ru.job4j.tracker

internal class StartUI {

    private val input = ConsoleInput()
    private val tracker = Tracker()

    fun init() {
        var run = true
        while (run) {
            println(
                "Menu." + "\n"
                        + "0. Add new Item" + "\n"
                        + "1. Show all items" + "\n"
                        + "2. Exit Program"
            )
            when (input.askInt("Select: ")) {
                0 -> run = createAction(input, tracker)
                1 -> run = showAction(tracker)
                2 -> run = exitAction()
            }
        }
    }

    companion object {
        fun createAction(input : Input, tracker : ITracker) : Boolean {
            val name = input.askStr("Enter name: ")
            val item = Item(name = name)
            tracker.add(item)
            return true
        }

        fun showAction(tracker : ITracker) : Boolean {
            val items = tracker.findAll()
            for ((id, name) in items) {
                println("$name $id")
            }
            return true
        }

        fun exitAction() : Boolean = false
    }
}

fun main() {
    StartUI().init()
}