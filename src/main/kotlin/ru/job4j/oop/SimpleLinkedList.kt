package ru.job4j.oop

import java.lang.Integer.min
import java.util.*

class SimpleLinkedList<T> : Iterable<T> {

    private var head : Node<T>? = null
    private var size = 0
    private var modCount = 0

    fun add(value : T) {
        if (size == 0) {
            head = Node<T>(value)
        } else {
            getNode(size - 1).next = Node<T>(value)
        }
        size++
        modCount++
    }

    fun get(index : Int) : T {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }
        return getNode(index).value
    }

    fun remove(index : Int) {
        if (size == 0) {
            throw NoSuchElementException()
        }

        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        } else if (index == 0) {
            head = null
        } else {
            val nodeTemp = getNode(index - 1)
            nodeTemp.next = nodeTemp.next?.next
        }
        size--
        modCount++
    }

    private fun getNode(index : Int) : Node<T> {
        var nodeTemp = head
        for (i in 0 until index) {
            nodeTemp = nodeTemp?.next
        }
        return nodeTemp!!
    }

    override fun iterator() : Iterator<T> {
        return LinkedIt()
    }

    inner class LinkedIt : Iterator<T> {

        private var indexIt = 0
        private val modCountIt = modCount

        override fun hasNext() : Boolean{
            return indexIt != size
        }

        override fun next() : T {
            if (modCountIt != modCount) {
                throw ConcurrentModificationException()
            }

            if (!hasNext()) {
                throw NoSuchElementException()
            }
            return get(indexIt++)
        }

    }

    fun listIterator() : ListIterator<T> {
        return BiLinkedIt()
    }

    inner class BiLinkedIt : ListIterator<T> {
        private var indexIt = 0
        private val modCountIt = modCount

        override fun hasNext() = indexIt != size

        override fun next() : T {
            checkModification()

            if (!hasNext()) {
                throw NoSuchElementException()
            }
            return get(indexIt++)
        }

        override fun nextIndex() = indexIt

        override fun hasPrevious() = indexIt > 0

        override fun previous() : T {
            checkModification()

            if (!hasPrevious()) {
                throw NoSuchElementException()
            }
            return get(min(indexIt--, size - 1))
        }

        override fun previousIndex() = indexIt - 1

        private fun checkModification() {
            if (modCountIt != modCount) {
                throw ConcurrentModificationException()
            }
        }

    }

    class Node<K>(val value : K, var next : Node<K>? = null)
}