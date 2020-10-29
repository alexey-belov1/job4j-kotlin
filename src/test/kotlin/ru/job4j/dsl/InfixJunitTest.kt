package ru.job4j.dsl

import org.junit.jupiter.api.Test
import ru.job4j.dsl.InfixJunit.eq
import ru.job4j.dsl.InfixJunit.notEq
import ru.job4j.dsl.InfixJunit.contains

class InfixJunitTest {

    @Test
    fun whenEq() = 1 eq 1

    @Test
    fun whenNotEq() = 1 notEq 2

    @Test
    fun whenContainsOneElement() = listOf(1, 2) contains 1

    @Test
    fun whenContainsManyElements() = listOf(1, 2, 3) contains listOf(3, 2)
}