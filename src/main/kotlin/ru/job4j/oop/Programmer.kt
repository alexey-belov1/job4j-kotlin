package ru.job4j.oop

class Programmer(name : String, val language : String) : Profession(name) {

    override fun getName() : String {
        return "Programmer " + super.getName()
    }

    override fun action() {
        super.action()
        println("Action from programmer")
    }
}