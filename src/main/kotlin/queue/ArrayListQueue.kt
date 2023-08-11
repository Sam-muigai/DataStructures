package queue

import utils.example

class ArrayListQueue <T:Any>:Queue<T>{

    private val list = ArrayList<T>()
    override fun enqueue(item: T): Boolean {
        list.add(item)
        return true
    }

    override fun dequeue(): T? = if (isEmpty) null else list.removeAt(0)

    override fun peek(): T? = list.getOrNull(0)

    override val count: Int
        get() = list.size

    override fun toString(): String {
        return list.toString()
    }
}

fun main() {
    "Queues using arraylist" example{
        val queue = ArrayListQueue<String>().apply {
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