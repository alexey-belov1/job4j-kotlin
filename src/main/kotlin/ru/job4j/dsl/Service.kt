package ru.job4j.dsl

import ru.job4j.tracker.Item

class Service(private val storage : Storage) {

    fun add(item : Item) : Item = storage.add(item)

    fun replace(id : String, item : Item) : Boolean = storage.replace(id, item)

    fun delete(id : String) : Boolean = storage.delete(id)

    fun findAll() : List<Item> = storage.findAll()

    fun findById(id : String) : Item? = storage.findById(id)

    fun findByName(name : String) : List<Item> = storage.findByName(name)
}