package kotlin_basics

fun getPlaces(){
    val places = listOf("Washington","Paris","Nairobi")
    val mutablePlaces = mutableListOf("Washington","Paris","Nairobi")

    //Takes constant time
    mutablePlaces.add("Cape town")
    //Time varies as the items need to be pushed back
    mutablePlaces.add(0,"Dodoma")
}

fun maps(){
    val scores = mutableMapOf("Mark" to 90,"Samuel" to 93,"James" to 34)
    scores["John"] = 74
}