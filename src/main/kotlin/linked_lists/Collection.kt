package linked_lists

import utils.example
import java.lang.IndexOutOfBoundsException

/*
class LinkedList<T : Any>:Collection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements){
            if (!contains(searched)) return false
        }
        return true
    }

    override fun contains(element: T): Boolean {
        for (item in this){
            if (item == element) return true
        }
        return false
    }

    override fun isEmpty() :Boolean {  return  size == 0 }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

    fun push(value: T): LinkedList<T> = apply {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun append(value: T): LinkedList<T> = apply {
        if (head == null) {
            push(value)
            return@apply
        }

        val newNode = Node(value)

        tail!!.next = newNode

        tail = newNode
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        //If currentNode is equal to null then the list is Empty
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (afterNode == tail) {
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (isEmpty()) return null
        val result = head?.value
        head = head?.next
        size--
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null

        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head

        var next = current.next
        /*
        * Loop will terminate after current is at tail position
        * */
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

}


fun main() {
    "iterable linked list" example {
        val list = LinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)
        println(list)

        for (i in list){
            println("Double: ${i*2}")
        }
    }
}


class LinkedListIterator<T: Any>(
    private val list: LinkedList<T>
) : Iterator<T> {

    private var index = 0
    private var lastNode:Node<T>? = null
    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
        if (index >= list.size) throw IndexOutOfBoundsException()

        lastNode = if (index == 0){
            list.nodeAt(0)
        }else{
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }
}

 */
