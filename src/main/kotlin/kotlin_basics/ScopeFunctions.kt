package kotlin_basics

class Car{
    var door:Int = 0
}


//Let
fun printCar(car: Car?){
    val isCoupe = car?.let {
        it.door <= 2
    }

    if (isCoupe == true){
        println("Coupe are nice")
    }
}

//Run
/*
*Run is more focused on the target object
*Provides the target object as this inside the block and isolates it from the outer block
*Run and let are known as transformational as they do not necessarily return the object they are called on
* */
fun printCar2(car: Car?){
    //Called on Car but returned a Boolean?
    val isCoupe = car?.run {
        //this.door <= 2
        door <= 2
    }

    if(isCoupe == true){
        println("Coupe are nice")
    }
}

//Apply
fun printCar3(car: Car?){
    car?.apply {
        door = 4
    }.let {
        if (it?.door != null && it.door <= 3){
            println("Coupe are awesome")
        }
    }
}

































