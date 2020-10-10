package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import ru.job4j.tracker.Item
import ru.job4j.tracker.Tracker

class TrackerTest : StringSpec({
    "When add in tracker" {
        val tracker = Tracker()
        val item = Item(name = "Item")
        tracker.add(item)
        tracker.findById(item.id)?.name shouldBe "Item"
    }

    "When findAll in tracker" {
        val tracker = Tracker()
        val item1 = Item(name = "Item1")
        val item2 = Item(name = "Item2")
        tracker.add(item1)
        tracker.add(item2)
        tracker.findAll() shouldBe arrayListOf(item1, item2)
    }

    "When findByName in Tracker" {
        val tracker = Tracker()
        val item11 = Item(name = "Item1")
        val item12 = Item(name = "Item1")
        val item2 = Item(name = "Item2")
        tracker.add(item11)
        tracker.add(item12)
        tracker.add(item2)
        tracker.findByName("Item1") shouldBe arrayListOf(item11, item12)
    }

    "When replace in Tracker and true" {
        val tracker = Tracker()
        val item = Item(name = "item")
        tracker.add(item)
        val itemWithDesc = Item(name = "Item with description")
        tracker.replace(item.id, itemWithDesc) shouldBe true
        tracker.findById(item.id)?.name shouldBe "Item with description"
    }

    "When replace in Tracker and false" {
        val tracker = Tracker()
        val item = Item(name = "Item")
        tracker.add(item)
        val itemWithDesc = Item("Item with description")
        tracker.replace("0", itemWithDesc) shouldBe false
        tracker.findById(item.id)?.name shouldBe "Item"
    }

    "When delete in Tracker and true" {
        val tracker = Tracker()
        val item = Item(name = "Item")
        tracker.add(item)
        tracker.delete(item.id) shouldBe true
        tracker.findById(item.id) shouldBe null
    }

    "When delete in Tracker and false" {
        val tracker = Tracker()
        val item = Item(name = "Item")
        tracker.add(item)
        tracker.delete("") shouldBe false
        tracker.findById(item.id)?.name shouldBe "Item"
    }
})