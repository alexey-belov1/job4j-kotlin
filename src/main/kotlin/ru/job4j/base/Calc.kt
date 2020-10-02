package ru.job4j.base

fun add(first : Double, second : Double) : Double {
    return first + second
}

fun subtract(first : Double, second : Double) : Double {
    return first - second
}

fun multiply(first : Double, second : Double) : Double {
    return first * second;
}

fun div(first : Double, second : Double) : Double {
    return first / second;
}

fun max(first: Double, second: Double) = if (first > second) first else second

fun max(first: Double, second: Double, third: Double) = max(max(first, second), third)

fun main() {
    val plus = add(1.0, 1.0)
    println("1 + 1 = $plus")

    val minus = subtract(3.0, 1.0)
    println("3 - 1 = $minus")

    val multiplication = multiply(2.0, 3.0)
    println("2 * 3 = $multiplication")

    val division  = div(6.0, 2.0)
    println("6 / 2 = $division")

    val rsl = max(1.0, 2.0)
    println("max from 1 and 2 is $rsl")
}