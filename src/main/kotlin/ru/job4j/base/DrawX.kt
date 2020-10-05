package ru.job4j.base

fun draw(size: Int): Boolean {
    if (size <= 0 || size % 2 == 0) {
        print("Wrong input")
        return false
    }
    for (row in 0 until size) {
        for (column in 0 until size) {
            print(
                if (row == column || row == size - 1 - column) "x" else " "
            )
        }
        println();
    }
    return true
}

fun main() {
    draw(5)
}