package ru.job4j.dsl

import org.junit.jupiter.api.Assertions.*

object InfixJunit {

    infix fun Any.eq(el : Any) = assertEquals(this, el)

    infix fun Any.notEq(el : Any) = assertNotEquals(this, el)

    infix fun List<Any>.contains(el : Any) = assertTrue(this.contains(el))

    infix fun List<Any>.contains(els : List<Any>) = assertTrue(this.containsAll(els))
}


