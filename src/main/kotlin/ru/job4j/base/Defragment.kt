package ru.job4j.base

fun defragment(array: Array<String?>) {
    var index = 0
    for ((i, el) in array.withIndex()) {
        if (el != null) {
            if (index != i) {
                array[i] = null
            }
            array[index++] = el
        }
    }
}