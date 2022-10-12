package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener{
            /*val resultTextView: TextView = findViewById(R.id.textView2)
            resultTextView.text = "6"
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()*/
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        /*when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }*/

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        //val resultTextView: TextView = findViewById(R.id.textView2)
        //resultTextView.text = diceRoll.toString()
        /*val luckyNumber=4
        if(diceRoll == luckyNumber)
        {
            println("You are lucky!!!")
        }
        else if (diceRoll == 1)
        {
            println("So sorry! You rolled a 1. Try again!")
        }
        else if (diceRoll == 2)
        {
            println("Sadly, you rolled a 2. Try again!")
        }
        else if (diceRoll == 3)
        {
            println("Unfortunately, you rolled a 3. Try again!")
        }
        else if (diceRoll == 5)
        {
            println("Don't cry! You rolled a 5. Try again!")
        }
        else
        {
            println("Apologies! You rolled a 6. Try again!")
        }*/
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}