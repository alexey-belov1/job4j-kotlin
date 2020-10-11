package ru.job4j.oop

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

    class Node<K>(val value : K, var next : Node<K>? = null)
}