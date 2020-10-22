package ru.job4j.dsl

import ru.job4j.tracker.ITracker
import ru.job4j.tracker.Item
import ru.job4j.tracker.Tracker

internal fun Item.add(tracker : ITracker) : Item = tracker.add(this)

fun main() {
    val tracker = Tracker()
    val item = Item(name = "item")
    println(item.add(tracker))
}