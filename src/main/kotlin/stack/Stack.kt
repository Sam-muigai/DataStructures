package stack

import linked_lists.LinkedList
import linked_lists.printInReverse
import stack.StackImpl.Companion.toStack
import utils.example

interface Stack<T:Any>{
    fun push(element:T)
    fun pop():T?

    fun peek():T?

    val count:Int
        get

    val isEmpty:Boolean
        get() = count ==0
}


class StackImpl<T:Any>:Stack<T>{

    private val storage = arrayListOf<T>()
    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    companion object{
        fun <T:Any> Iterable<T>.toStack():Stack<T>{
            val stack = StackImpl<T>()
            for (item in this){
                stack.push(item)
            }
            return stack
        }

    }

    override fun toString(): String {
        return buildString {
            appendLine("------TOP-------")
            storage.asReversed().forEach{
                appendLine("$it")
            }
            appendLine("----------------")
        }
    }
}


fun main() {
    "stack implementation" example {
        val stack = StackImpl<String>().apply {
            push("Samuel")
            push("Maina")
            push("Simon")
        }
        print(stack)
        val poppedElement = stack.pop()
        poppedElement?.let { popped ->
            println("Popped element $popped")
        }
        print(stack)
    }

    "converting a list to stack" example {
        val names = listOf("Samuel","Maina","Kamau")
        val nameStack = names.toStack()
        nameStack.pop()
        println(nameStack)
    }

    "initialising a stack as a list" example {
        val names = stackOf("Samuel","Maina","John")
        println(names)
        names.push("Kinuthia")
        println(names)
    }

    "Reversing a linked list using stack " example {
        val list = LinkedList<Int>().apply {
            append(1)
            append(2)
            append(3)
        }
        println(list)
        println("In reverse....")
        println(list.printInReverseUsingStacks())
    }

    "Finding balanced parenthesis" example {
        val example = "h((e))llo(world)()"
        println(example.findBalancedParenthesis())
    }
}


//Challenge (Reversing a linked list)
fun <T:Any> LinkedList<T>.printInReverseUsingStacks(){
    val stack = StackImpl<T>()

    for (item in this){
        stack.push(item)
    }

    var node = stack.pop()
    while (node != null){
        println(node)
        node = stack.pop()
    }
}

//Challenge (Finding balanced parenthesis)
fun String.findBalancedParenthesis():Boolean{
    val stacks = StackImpl<Char>()
    for (character in this){
        when(character){
            '('->stacks.push(character)
            ')'->if (stacks.isEmpty) {
                return false
            }else{
                stacks.pop()
            }
        }
    }
    return stacks.isEmpty
}




fun <T:Any> stackOf(vararg element: T):Stack<T>{
    return element.asList().toStack()
}















