package linked_lists

import utils.example

class LinkedList<T : Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    private fun isEmpty() = size == 0

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
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

    "remove after a particular node" example {
        val lists = LinkedList<Int>()
        lists.append(1)
        lists.append(2)
        lists.append(3)
        println("Before removing node:$lists")
        val nodeToRemote = lists.nodeAt(index = 0)!!
        lists.removeAfter(nodeToRemote)
        println("After removing node:$lists")
    }

    "removeLast" example {
        val lists = LinkedList<Int>()
        lists.append(1)
        lists.append(2)
        lists.append(3)
        println("Before removing Last:$lists")
        val removedValue = lists.removeLast()
        println("Removed value: $removedValue")
        println("After removing:$lists")
    }

    "pop" example {
        val lists = LinkedList<Int>()
        lists.append(1)
        lists.append(2)
        lists.append(3)
        println("Before popping:$lists")
        val poppedValue = lists.pop()
        println("Popped value: $poppedValue")
        println("After popping:$lists")

    }

    "Inserting at a particular index" example {
        val lists = LinkedList<Int>()
        lists.append(1)
        lists.append(2)
        lists.append(3)

        println("Before inserting :$lists")
        var middleNode = lists.nodeAt(1)!!
        for (i in 1..3) {
            middleNode = lists.insert(-1 * i, middleNode)
        }
        println("After inserting :$lists")
    }


    "fluent interface append" example {
        val list = LinkedList<Int>()
        list.append(1).append(2).append(3)
        println(list)
    }



    "append" example {
        val list = LinkedList<Int>()

        list.append(1)
        list.append(2)
        list.append(3)

        println(list)
    }



    "fluent interface push" example {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        println(list)
    }



    "push" example {
        val list = LinkedList<Int>()
        list.push(1)
        list.push(2)
        list.push(3)
        println(list)
    }




    "creating and linking nodes" example {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        node1.next = node2
        node2.next = node3
        println(node1)
    }
}