package ru.job4j.dsl

import io.kotlintest.TestCase
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.apache.commons.dbcp2.BasicDataSource
import ru.job4j.tracker.Item

class StorageTest : StringSpec() {

    private val storage : Storage by lazy { init() }

    private fun init() : Storage {
        val pool = BasicDataSource().apply {
            url = "jdbc:postgresql://127.0.0.1:5432/kt"
            username = "postgres"
            password = "password"
        }

        return Storage(pool)
    }

    override fun beforeTest(testCase : TestCase) {
        storage.findAll().forEach { storage.delete(it.id) }
    }

    init {
        "When add in storage" {
            val item = Item(name = "Item")
            storage.apply {
                add(item)
                findById(item.id)?.name shouldBe "Item"
            }
        }

        "When findAll in storage" {
            val item1 = Item(name = "Item1")
            val item2 = Item(name = "Item2")
            storage.apply {
                add(item1)
                add(item2)
                findAll() shouldBe arrayListOf(item1, item2)
            }
        }

        "When findByName in storage" {
            val item11 = Item(name = "Item1")
            val item12 = Item(name = "Item1")
            val item2 = Item(name = "Item2")
            storage.apply {
                add(item11)
                add(item12)
                add(item2)
                findByName("Item1") shouldBe arrayListOf(item11, item12)
            }
        }

        "When replace in storage and true" {
            val item = Item(name = "item")
            val itemWithDesc = Item(name = "Item with description")
            storage.apply {
                add(item)
                replace(item.id, itemWithDesc) shouldBe true
                findById(item.id)?.name shouldBe "Item with description"
            }
        }

        "When replace in storage and false" {
            val item = Item(name = "Item")
            val itemWithDesc = Item("Item with description")
            storage.apply {
                add(item)
                replace("-1", itemWithDesc) shouldBe false
                findById(item.id)?.name shouldBe "Item"
            }
        }

        "When delete in storage and true" {
            val item = Item(name = "Item")
            storage.apply {
                add(item)
                delete(item.id) shouldBe true
                findById(item.id) shouldBe null
            }
        }

        "When delete in storage and false" {
            val item = Item(name = "Item")
            storage.apply {
                add(item)
                delete("-1") shouldBe false
                findById(item.id)?.name shouldBe "Item"
            }
        }
    }
}