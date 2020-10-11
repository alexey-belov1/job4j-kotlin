package ru.job4j.tracker

object StartUI {

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
                0 -> run = createAction()
                1 -> run = showAction()
                2 -> run = exitAction()
            }
        }
    }

    private fun createAction() : Boolean {
        val name = input.askStr("Enter name: ")
        val item = Item(name = name)
        tracker.add(item)
        return true
    }

    private fun showAction() : Boolean {
        val items = tracker.findAll()
        for ((id, name) in items) {
            println("$name $id")
        }
        return true
    }

    private fun exitAction() : Boolean = false
}

fun main() {
    StartUI.init()
}