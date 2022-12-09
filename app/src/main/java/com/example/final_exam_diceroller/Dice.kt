package com.example.final_exam_diceroller

class Dice (private val numSides: Int, private var sideUp:Int = 0) {

    init {
        roll()
    }

    fun getSide_up(): Int {
        return sideUp
    }

    fun roll() //Roll method to generate a random value
    {
        sideUp = ((Math.random() * numSides) + 1).toInt()
    }
}
