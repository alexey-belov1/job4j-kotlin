package ru.job4j.lambda

fun sumWithFilter(list : ArrayList<Int>, predicate : (Int) -> Boolean) : Int {
    return list
        .stream()
        .filter { predicate.invoke(it) }
        .map { it + 1 }
        .reduce { sum, it -> it + sum }
        .get()
}

fun main() {
    val list = arrayListOf(1, 3, 5)
    print(sumWithFilter(list) { x -> x > 2 })
}