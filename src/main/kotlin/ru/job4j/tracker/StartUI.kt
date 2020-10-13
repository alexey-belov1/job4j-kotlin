package ru.job4j.tracker

import java.util.*

internal class StartUI {

    private val input = ConsoleInput()
    private val tracker = Tracker()

    fun init() {
        val actions = ArrayList<Action>()
        actions.add(CreateAction())
        actions.add(ShowAction())
        actions.add(ExitAction())

        var run = true
        while (run) {
            showMenu(actions)
            val select = input.askInt("Select: ")
            val action = actions[select]
            run = action.execute(input, tracker)
        }
    }

    private fun showMenu(actions : ArrayList<Action>) {
        println("Menu.")
        for (index in actions.indices) {
            println(index.toString() + ". " + actions[index].name())
        }
    }
}

fun main() {
    StartUI().init()
}