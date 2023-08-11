package queue

import utils.example

class RingBufferQueue <T:Any>(private val size:Int):Queue<T>{
    private val ringBuffer:RingBuffer<T> = RingBuffer(size)
    override fun enqueue(item: T): Boolean = ringBuffer.write(item)

    override fun dequeue(): T? = if (isEmpty)null else ringBuffer.read()
    override fun peek(): T? = ringBuffer.first

    override val count: Int
        get() = ringBuffer.count

    override fun toString(): String {
        return ringBuffer.toString()
    }

}

fun main() {
    "Queues using ring buffer" example{
        val queue = RingBufferQueue<String>(5).apply {
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