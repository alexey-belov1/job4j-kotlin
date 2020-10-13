package ru.job4j.lambda

fun main() {
    val inc = { x : Int -> x + 1}
    val dec = { x : Int -> x - 1}
    val square = { x : Int -> x * x}

    println(inc(1))
    println(dec(1))
    println(square(2))
}
