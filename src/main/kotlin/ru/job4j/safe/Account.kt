package ru.job4j.safe

data class Account(val requisite : String) {
    var balance = 0.0

    constructor(requisite : String, balance : Double) : this(requisite) {
        this.balance = balance
    }
}