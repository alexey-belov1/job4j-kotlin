package ru.job4j.dsl

import io.kotlintest.specs.FunSpec
import io.mockk.*
import ru.job4j.tracker.Item

class ServiceTest : FunSpec({

    val storage = mockk<Storage>()
    val service = Service(storage)
    mockkStatic("ru.job4j.dsl.StorageKt")

    test("When add") {
        val item = Item()
        every { storage.add(any()) } returns item
        service.add(item)
        verify(exactly = 1) { storage.add(item) }
    }

    test("When replace") {
        val item = Item()
        every { storage.replace(any(), any()) } returns true
        service.replace("1", item)
        verify(exactly = 1) { storage.replace("1", item) }
    }

    test("When delete") {
        every { storage.delete(any()) } returns true
        service.delete("1")
        verify(exactly = 1) { storage.delete("1") }
    }

    test("When findAll") {
        every { storage.findAll() } returns ArrayList()
        service.findAll()
        verify(exactly = 1) { storage.findAll() }
    }

    test("When findById") {
        every { storage.findById(any()) } returns Item()
        service.findById("1")
        verify(exactly = 1) { storage.findById("1") }
    }

    test("When findByName") {
        every { storage.findByName(any()) } returns ArrayList()
        service.findByName("item")
        verify(exactly = 1) { storage.findByName("item") }
    }
})