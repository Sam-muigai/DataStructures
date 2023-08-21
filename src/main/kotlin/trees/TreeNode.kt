package trees

import queue.ArrayListQueue


typealias Visitor<T> =(TreeNode<T>)->Unit
class TreeNode<T>(val value:T){
    private val children:MutableList<TreeNode<T>> = mutableListOf()

    fun add(child:TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit:Visitor<T>) {
        visit(this)
        children.forEach{
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach{ queue.enqueue(it) }
        var node = queue.dequeue()
        while (node != null){
            visit(node)
            node.children.forEach{ queue.enqueue(it)}
            node = queue.dequeue()
        }
    }

    fun search(value:T):TreeNode<T>?{
        var treeNode:TreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value){
                treeNode = it
            }
        }

        return treeNode
    }

    fun printEachLevel() {
// 1
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0
        queue.enqueue(this)
// 2
        while (queue.isEmpty.not()) {
// 3
            nodesLeftInCurrentLevel = queue.count
// 4
            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }
        }
    }
}
fun makeBeverageTree():TreeNode<String>{
    val tree = TreeNode("tree")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")

    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.run {
        add(hot)
        add(cold)
    }
    hot.run {
        add(tea)
        add(coffee)
        add(chocolate)
    }
    cold.run {
        add(soda)
        add(milk)
    }
    tea.run {
        add(blackTea)
        add(greenTea)
        add(chaiTea)
    }
    soda.run {
        add(gingerAle)
        add(bitterLemon)
    }

    return tree
}



fun main() {
//    val hot = TreeNode("hot")
//    val cold = TreeNode("cold")
//
//    val beverage = TreeNode("beverage").run {
//        add(hot)
//        add(cold)
//    }

//    val beverage = makeBeverageTree()
//    beverage.forEachDepthFirst {
//        println(it.value)
//    }

    val tree = makeBeverageTree()
//    tree.forEachLevelOrder{
//        println(it.value)
//    }
    tree.printEachLevel()

//    tree.search("tea")?.let {
//        println("Found ${it.value}")
//    }
//    println()
//    tree.search("beer")?.let {
//        println("Found ${it.value}")
//    } ?: println("Could not found it")
}
















