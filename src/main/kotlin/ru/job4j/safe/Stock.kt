package ru.job4j.safe

import java.time.LocalDate

class Stock(val name : String, val currency : String, val created : LocalDate) {

    override fun equals(other : Any?) : Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Stock

        return name == other.name
                && currency == other.currency
                && created == other.created
    }

    override fun hashCode() : Int {
        val prime = 31
        var result = 17
        result = prime * result + name.hashCode()
        result = prime * result + currency.hashCode()
        result = prime * result + created.hashCode()
        return result
    }
}