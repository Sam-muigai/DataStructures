package queue

import queue.list.DoublyLinkedList
import utils.example

class DoubleLinkedListQueue<T:Any>:Queue<T> {

    private val list = DoublyLinkedList<T>()

    private var size = 0

    override fun enqueue(item: T): Boolean {
        list.append(item)
        size++
        return true
    }

    override fun dequeue(): T? {
        val firstNode = list.first ?: return null
        size--
        return list.remove(firstNode)
    }

    override fun peek(): T? = list.first?.value

    override val count: Int
        get() = size

    override fun toString(): String {
        return list.toString()
    }

}

fun main() {
    "Queues using double linked list" example{
        val queue = DoubleLinkedListQueue<String>().apply {
            enqueue("Sam")
            enqueue("Maina")
            enqueue("Mwangi")
            enqueue("Ian")
        }
        println("-------Before dequeue--------")
        println(queue)
        println("-------After dequeue--------")
        queue.dequeue()
        println(queue)
    }
}