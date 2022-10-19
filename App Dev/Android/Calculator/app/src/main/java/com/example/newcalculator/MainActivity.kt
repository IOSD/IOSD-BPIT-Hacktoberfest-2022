package com.example.newcalculator

import android.nfc.tech.MifareUltralight
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.sql.BatchUpdateException

class MainActivity : AppCompatActivity() {

    lateinit var Enter_Display: TextView
    lateinit var Add: Button
    lateinit var Subtract: Button
    lateinit var Multiply: Button
    lateinit var Divide: Button
    lateinit var Decimal: Button
    lateinit var Per: Button
    lateinit var AC: Button
    lateinit var EqualsTo: Button
    lateinit var Zero: Button
    lateinit var DoubleZero: Button
    lateinit var One: Button
    lateinit var Two: Button
    lateinit var Three: Button
    lateinit var Four: Button
    lateinit var Five: Button
    lateinit var Six: Button
    lateinit var Seven: Button
    lateinit var Eight: Button
    lateinit var Nine: Button
    var str: String= ""
    var input1 :String="0"
    var input2 :String="0"
    var op_press:Boolean=false      //operator is pressed or not
    var operator:String=""          //which operator is pressed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        One=findViewById(R.id.One)
        Two=findViewById(R.id.Two)
        Three=findViewById(R.id.Three)
        Four=findViewById(R.id.Four)
        Five=findViewById(R.id.Five)
        Six=findViewById(R.id.Six)
        Seven=findViewById(R.id.Seven)
        Eight=findViewById(R.id.Eight)
        Nine=findViewById(R.id.Nine)
        Zero=findViewById(R.id.Zero)
        DoubleZero=findViewById(R.id.DoubleZero)

        Add=findViewById(R.id.Add)
        Subtract=findViewById(R.id.Subtract)
        Multiply=findViewById(R.id.Multiply)
        Divide=findViewById(R.id.Divide)
        Per=findViewById(R.id.Per)
        AC=findViewById(R.id.AC)
        EqualsTo=findViewById(R.id.EqualsTo)

        Enter_Display=findViewById(R.id.Enter_Display)

        //Displaying text in the Display Window
        One.setOnClickListener {
            Enter_Display.text=Enter_Display.text.toString()+"1"
            if(op_press)
            {
                input2=input2.toString()+"1"
            }
            else{
                input1=input1.toString()+"1"
            }
        }
        Two.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}2"
            if(op_press)
            {
                input2=input2.toString()+"2"
            }
            else{
                input1=input1.toString()+"2"
            }
        }
        Three.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}3"
            if(op_press)
            {
                input2=input2.toString()+"3"
            }
            else{
                input1=input1.toString()+"3"
            }
        }
        Four.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}4"
            if(op_press)
            {
                input2=input2.toString()+"4"
            }
            else{
                input1=input1.toString()+"4"
            }
        }
        Five.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}5"
            if(op_press)
            {
                input2=input2.toString()+"5"
            }
            else{
                input1=input1.toString()+"5"
            }
        }
        Six.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}6"
            if(op_press)
            {
                input2=input2.toString()+"6"
            }
            else{
                input1=input1.toString()+"6"
            }
        }
        Seven.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}7"
            if(op_press)
            {
                input2=input2.toString()+"7"
            }
            else{
                input1=input1.toString()+"7"
            }
        }
        Eight.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}8"
            if(op_press)
            {
                input2=input2.toString()+"8"
            }
            else{
                input1=input1.toString()+"8"
            }
        }
        Nine.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}9"
            if(op_press)
            {
                input2=input2.toString()+"9"
            }
            else{
                input1=input1.toString()+"9"
            }
        }
        Zero.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}0"
            if(op_press)
            {
                input2=input2.toString()+"0"
            }
            else{
                input1=input1.toString()+"0"
            }
        }
        DoubleZero.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}00"
            if(op_press)
            {
                input2=input2.toString()+"00"
            }
            else{
                input1=input1.toString()+"00"
            }
        }
        Add.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}+"
            operator="+"
            op_press=true
        }
        Subtract.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}-"
            operator="-"
            op_press=true
        }
        Multiply.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}X"
            operator="X"
            op_press=true
        }
        Divide.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}÷"
            operator="÷"
            op_press=true
        }
        Per.setOnClickListener {
            Enter_Display.text="${Enter_Display.text}%"
            operator="%"
            op_press=true
        }
        AC.setOnClickListener {
            Enter_Display.setText("")
            op_press=false
            input1="0"
            input2="0"
        }
        EqualsTo.setOnClickListener {
            op_press=false                                       //No further operation to be carried
            when(operator){                                      //Performing specific operations
                "+"-> Enter_Display.text=(input1.toFloat()+input2.toFloat()).toString()
                "-"-> Enter_Display.text=(input1.toFloat()-input2.toFloat()).toString()
                "X"-> Enter_Display.text=(input1.toFloat()*input2.toInt()).toString()
                "÷"-> if(input2.toInt()!=0){Enter_Display.text=(input1.toFloat()/input2.toFloat()).toString()}else{Enter_Display.text="Cannot be divided by 0"}
                "%"-> if(input2.toInt()==0){Enter_Display.text=(input1.toInt()/100.toFloat()).toString()}else{Enter_Display.text=((input1.toFloat()*input2.toFloat())/100).toString()}
            }
        }
    }}
