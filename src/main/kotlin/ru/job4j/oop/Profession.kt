package ru.job4j.oop

open class Profession(private val name : String) {

    open fun getName() : String = name

    open fun action() {
        println("Action from profession")
    }
}

