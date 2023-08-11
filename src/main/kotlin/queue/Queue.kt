package queue

interface Queue <T:Any>{

    fun enqueue(item:T):Boolean

    fun dequeue():T?

    fun peek():T?

    val count:Int
        get

    val isEmpty: Boolean
        get() = count == 0
}