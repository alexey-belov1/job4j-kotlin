package ru.job4j.dsl

import ru.job4j.tracker.Item
import java.util.*
import kotlin.collections.ArrayList

internal object ItemStore : Store<Item> {

    private val items = ArrayList<Item>()

    override fun save(item : Item) : Item {
        item.id = generateId()
        items.add(item)
        return item
    }

    private fun generateId() : String = (System.currentTimeMillis() + Random().nextLong()).toString()
}