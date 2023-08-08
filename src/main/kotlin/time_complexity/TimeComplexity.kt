package time_complexity

//Constant time complexity
/*
* The running time is not affected by the size of the input data
* O(1)
* */
fun checkFirst(name:List<String>){
    if (name.firstOrNull() != null){
        println(name[0])
    }
}

//Linear time complexity
/*
* As the input size increases the running time also increases
* O(n)
* */
fun printNames(names: List<String>){
    for (name in names){
        println(name)
    }
}

//Quadratic time complexity
/*
* Takes time proportional to the square of the input size#
* Not optimal at all
*O(n^2)
* */
fun multiplicationTable(size:Int){
    for (number in 1..size){
        print("|")
        for (otherNumber in 1..size){
            println("$otherNumber x $number = ${otherNumber*number} |")
        }
    }
    println()
}

//Logarithmic  time complexity
/*
* O(log n)
* */
fun pseudoBinaryContains(value:Int,numbers:List<Int>):Boolean{
    if (numbers.isEmpty()) return false
    val middleIndex = numbers.size/2

    if (value <= numbers[middleIndex]){
        for (index in 0..middleIndex){
            if (value == numbers[index]){
                return true
            }
        }
    }else{
        for (index in middleIndex..<numbers.size){
            if (value == numbers[index]){
                return true
            }
        }
    }
    return false
}




























