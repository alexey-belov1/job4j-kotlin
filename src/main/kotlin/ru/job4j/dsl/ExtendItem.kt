package ru.job4j.dsl

import ru.job4j.tracker.Item

internal fun Item.save() : Item = ItemStore.save(this)

fun main() {
    val item = Item(name = "item")
    println(item.save())
}