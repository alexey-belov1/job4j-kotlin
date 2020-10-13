package ru.job4j.oop

class Doctor(name : String, val specialty : String) : Profession(name) {

    override fun getName() : String {
        return "Doctor " + super.getName()
    }

    override fun action() {
        super.action()
        println("Action from doctor")
    }
}