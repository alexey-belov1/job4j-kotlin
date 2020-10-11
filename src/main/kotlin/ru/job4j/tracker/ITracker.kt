package ru.job4j.tracker

internal interface ITracker {
    fun add(item : Item) : Item

    fun replace(id : String, item : Item) : Boolean

    fun delete(id : String) : Boolean

    fun findAll() : List<Item>

    fun findByName(key : String) : List<Item>

    fun findById(id : String) : Item?
}