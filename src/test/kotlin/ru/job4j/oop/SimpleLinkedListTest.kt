package ru.job4j.oop

import io.kotlintest.*
import io.kotlintest.specs.StringSpec

class SimpleLinkedListTest : StringSpec() {

    private var list = SimpleLinkedList<Int>()

    override fun beforeTest(testCase : TestCase) {
        list = SimpleLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
    }

    init {
        "When add and get elements" {
            list.get(0) shouldBe 1
            list.get(1) shouldBe 2
            list.get(2) shouldBe 3
        }

        "When remove element" {
            list.remove(1)
            list.get(0) shouldBe 1
            list.get(1) shouldBe 3
        }

        "When check iterator" {
            val iterator = list.iterator()
            iterator.hasNext() shouldBe true
            iterator.next() shouldBe 1
            iterator.hasNext() shouldBe true
            iterator.next() shouldBe 2
            iterator.hasNext() shouldBe true
            iterator.next() shouldBe 3
            iterator.hasNext() shouldBe false
        }

        "When IndexOutOfBoundsException in add" {
            shouldThrow<IndexOutOfBoundsException> {
                list.get(4)
            }
        }

        "When IndexOutOfBoundsException in remove" {
            shouldThrow<IndexOutOfBoundsException> {
                list.remove(4)
            }
        }

        "When ConcurrentModificationException" {
            val iterator = list.iterator()
            list.add(4)
            shouldThrow<ConcurrentModificationException> {
                iterator.next()
            }
        }
    }
}