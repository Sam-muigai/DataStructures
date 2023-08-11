package queue

import stack.StackImpl
import utils.example

class StackQueue<T:Any>:Queue<T>{

    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()

    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty


    private fun transferElements(){
        var nextElement = rightStack.pop()
        while (nextElement != null){
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }


    override fun enqueue(item: T): Boolean {
        rightStack.push(item)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty){
            transferElements()
        }
        return leftStack.pop()
    }

    override fun peek(): T? {
        if (leftStack.isEmpty){
            transferElements()
        }
        return leftStack.peek()
    }

    override val count: Int
        get() = leftStack.count + rightStack.count
    override fun toString(): String {
        return "Left stack: \n$leftStack \n Right stack:\n$rightStack"
    }
}

fun main() {
    "Queues using stack queue" example{
        val queue = StackQueue<String>().apply {
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
