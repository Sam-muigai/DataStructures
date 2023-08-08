package kotlin_basics

fun main(){
    val boxNumber = Box<Int>()

    boxNumber.put(23)
    println(boxNumber.retrieve())
}


class Box<T>{
    private var item:T? = null


    fun put(item: T){
        this.item = item
    }

    fun retrieve():T?{
        return item
    }

    fun isEmpty():Boolean{
        return item == null
    }

}