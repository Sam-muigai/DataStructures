package linked_lists

import utils.example

class LinkedList<T : Any>:Iterable<T>,MutableIterable<T>,Collection<T>,MutableCollection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements){
            append(element)
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

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

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = iterator()
        while(iterator.hasNext()){
            val item = iterator.next()
            if (!elements.contains(item)){
                iterator.remove()
                result = true
            }
        }
        return result
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements){
            result = remove(item) || false
        }
        return result
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()){
            val node = iterator.next()
            if (node == element) {
                iterator.remove()
                return true
            }
        }
        return false
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


//Function for printInReverse
fun <T:Any> LinkedList<T>.printInReverse(){
    this.nodeAt(0)?.printInReverse()
}

private fun <T:Any> Node<T>.printInReverse(){
    this.next?.printInReverse()
    if (next != null){
        print("<-")
    }
    print(this.value.toString())
}

private fun <T:Any> LinkedList<T>.getMiddle():Node<T>?{
    var fast = this.nodeAt(0)
    var slow = this.nodeAt(0)

    while (fast != null){
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next

        }
    }
    return slow
}






fun main() {
    "get middle element" example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        println("Center element is ${list.getMiddle()?.value}")
    }

    "printing in reverse" example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        println("Printing before reversing:$list")
        print("Print after reversing: ")
        list.printInReverse()
    }

    "removing elements" example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        println("Before removing $list")
        list.remove(3)
        println("After removing $list")
    }

    "retaining elements" example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        println("Before retaining:$list")
        list.retainAll(listOf(1,3))
        println("After retaining:$list")
    }

    "remove All elements" example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        println("Before removing:$list")
        list.removeAll(listOf(1,3))
        println("After removing:$list")
    }

}

class LinkedListIterator<T: Any>(
    private val list: LinkedList<T>
) : MutableIterator<T> {

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

    override fun remove() {
        if (index == 0){
            list.pop()
        }else{
            val prevNode = list.nodeAt(index - 2) ?: return
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
    }
}