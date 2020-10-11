package ru.job4j.tracker

import java.util.*
import kotlin.collections.ArrayList

internal class Tracker : ITracker {

    private val items = ArrayList<Item>()

    override fun add(item : Item) : Item {
        item.id = generateId()
        items.add(item)
        return item
    }

    override fun replace(id : String, item : Item) : Boolean {
        items.singleOrNull { it.id == id }?.apply {
            name = item.name
            return true
        }
        return false
    }

    override fun delete(id : String) : Boolean {
        return items.removeIf { it.id == id }
    }

    override fun findAll() : List<Item> {
        return items
    }

    override fun findByName(key : String) : List<Item> {
        return items.filter { it.name == key }
    }

    override fun findById(id : String) : Item? {
        return items.singleOrNull { it.id == id }
    }

    private fun generateId() : String = (System.currentTimeMillis() + Random().nextLong()).toString()
}