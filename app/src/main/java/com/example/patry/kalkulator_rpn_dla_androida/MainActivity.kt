package com.example.patry.kalkulator_rpn_dla_androida

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.lang.Math.pow
import java.lang.Math.sqrt
import java.util.*
import kotlin.math.round


class MainActivity : AppCompatActivity() {

    var lastValue : String = "0"
    var stack : LinkedList<String> = LinkedList<String>()
    var precision : Int = 2
    var red : Int = 255
    var green : Int = 255
    var blue : Int = 255

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null) {
            editTextViev.text = savedInstanceState.getString("editTextView")
            firtsLevelStack.text = savedInstanceState.getString("firstLevelStack")
            secondLevelStack.text = savedInstanceState.getString("secondLevelStack")
            thirdLevelStack.text = savedInstanceState.getString("thirdLevelStack")
            fourthLevelStack.text = savedInstanceState.getString("fourthLevelStack")
            lastValue = intent.getStringExtra("lastValue")
            stack = intent.extras.get("stack") as LinkedList<String>
            precision = intent.getIntExtra("precision", 2)
            red = intent.getIntExtra("red", 255)
            green = intent.getIntExtra("green", 255)
            blue = intent.getIntExtra("blue", 255)
            relativeLayout.setBackgroundColor(Color.rgb(red, green, blue))
        }
        else {
            firtsLevelStack.text = "0"
            secondLevelStack.text = "0"
            thirdLevelStack.text = "0"
            fourthLevelStack.text = "0"
        }

        oneButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "1"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "1"
            }
        }

        twoButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "2"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "2"
            }
        }

        threeButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "3"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "3"
            }
        }

        fourButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "4"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "4"
            }
        }

        fiveButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "5"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "5"
            }
        }

        sixButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "6"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "6"
            }
        }

        sevenButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "7"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "7"
            }
        }

        eightButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "8"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "8"
            }
        }

        nineButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "9"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "9"
            }
        }

        zeroButton.setOnClickListener {
            if (editTextViev.text == "0"){
                editTextViev.text = "0"
            }
            else {
                editTextViev.text = editTextViev.text.toString() + "0"
            }
        }

        comaButton.setOnClickListener {
            if (!editTextViev.text.contains(".")){
                editTextViev.text = editTextViev.text.toString() + "."
            }
        }

        enterButton.setOnClickListener {
            stack.push(fourthLevelStack.text.toString())
            fourthLevelStack.text = thirdLevelStack.text
            thirdLevelStack.text = secondLevelStack.text
            secondLevelStack.text = firtsLevelStack.text
            if (editTextViev.text != "") {
                firtsLevelStack.text = editTextViev.text
                lastValue = editTextViev.text.toString()
            }
            else {
                firtsLevelStack.text = lastValue
            }
            editTextViev.text = ""
        }

        addButton.setOnClickListener {
            val firstValue : Double = firtsLevelStack.text.toString().toDouble()
            val secondValue : Double = secondLevelStack.text.toString().toDouble()
            firtsLevelStack.text = (round((firstValue + secondValue) * pow(10.toDouble(), precision.toDouble())) / pow(10.toDouble(), precision.toDouble())).toString()
            secondLevelStack.text = thirdLevelStack.text
            thirdLevelStack.text = fourthLevelStack.text
            if (stack.isEmpty()) {
                fourthLevelStack.text = "0"
            }
            else {
                fourthLevelStack.text = stack.pop()
            }
        }

        diffButton.setOnClickListener {
            val firstValue : Double = firtsLevelStack.text.toString().toDouble()
            val secondValue : Double = secondLevelStack.text.toString().toDouble()
            firtsLevelStack.text = (round((secondValue - firstValue) * pow(10.toDouble(), precision.toDouble())) / pow(10.toDouble(), precision.toDouble())).toString()
            secondLevelStack.text = thirdLevelStack.text
            thirdLevelStack.text = fourthLevelStack.text
            if (stack.isEmpty()) {
                fourthLevelStack.text = "0"
            }
            else {
                fourthLevelStack.text = stack.pop()
            }
        }

        mulButton.setOnClickListener {
            val firstValue : Double = firtsLevelStack.text.toString().toDouble()
            val secondValue : Double = secondLevelStack.text.toString().toDouble()
            firtsLevelStack.text = (round(firstValue * secondValue * pow(10.toDouble(), precision.toDouble())) / pow(10.toDouble(), precision.toDouble())).toString()
            secondLevelStack.text = thirdLevelStack.text
            thirdLevelStack.text = fourthLevelStack.text
            if (stack.isEmpty()) {
                fourthLevelStack.text = "0"
            }
            else {
                fourthLevelStack.text = stack.pop()
            }
        }

        divButton.setOnClickListener {
            val firstValue : Double = firtsLevelStack.text.toString().toDouble()
            val secondValue : Double = secondLevelStack.text.toString().toDouble()
            if (firstValue.toInt() != 0) {
                firtsLevelStack.text = (round(secondValue / firstValue * pow(10.toDouble(), precision.toDouble())) / pow(10.toDouble(), precision.toDouble())).toString()
            }
            else {
                firtsLevelStack.text = "0"
            }
            secondLevelStack.text = thirdLevelStack.text
            thirdLevelStack.text = fourthLevelStack.text
            if (stack.isEmpty()) {
                fourthLevelStack.text = "0"
            }
            else {
                fourthLevelStack.text = stack.pop()
            }
        }

        changeSignButton.setOnClickListener {
            if (editTextViev.text.contains("-")) {
                editTextViev.text = editTextViev.text.toString().substring(1)
            }
            else {
                editTextViev.text = "-" + editTextViev.text.toString()
            }
        }

        powerButton.setOnClickListener {
            val firstValue : Double = firtsLevelStack.text.toString().toDouble()
            val secondValue : Double = secondLevelStack.text.toString().toDouble()
            firtsLevelStack.text = (round(pow(secondValue, firstValue) * pow(10.toDouble(), precision.toDouble())) / pow(10.toDouble(), precision.toDouble())).toString()
            secondLevelStack.text = thirdLevelStack.text
            thirdLevelStack.text = fourthLevelStack.text
            if (stack.isEmpty()) {
                fourthLevelStack.text = "0"
            }
            else {
                fourthLevelStack.text = stack.pop()
            }
        }

        sqrtButton.setOnClickListener {
            val firstValue : Double = firtsLevelStack.text.toString().toDouble()
            firtsLevelStack.text = (round(sqrt(firstValue) * pow(10.toDouble(), precision.toDouble())) / pow(10.toDouble(), precision.toDouble())).toString()
        }

        swapButton.setOnClickListener {
            val firstValue : String = firtsLevelStack.text.toString()
            firtsLevelStack.text = secondLevelStack.text
            secondLevelStack.text = firstValue
        }

        dropButton.setOnClickListener {
            firtsLevelStack.text = secondLevelStack.text
            secondLevelStack.text = thirdLevelStack.text
            thirdLevelStack.text = fourthLevelStack.text
            if (stack.isEmpty()) {
                fourthLevelStack.text = "0"
            }
            else {
                fourthLevelStack.text = stack.pop()
            }
        }

        allClearButton.setOnClickListener {
            editTextViev.text = "0"
            firtsLevelStack.text = "0"
            secondLevelStack.text = "0"
            thirdLevelStack.text = "0"
            fourthLevelStack.text = "0"
            stack = LinkedList<String>()
        }

        clearButton.setOnClickListener {
            editTextViev.text = "0"
        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            intent.putExtra("editTextView", editTextViev.text.toString())
            intent.putExtra("firstStackLevel", firtsLevelStack.text.toString())
            intent.putExtra("secondStackLevel", secondLevelStack.text.toString())
            intent.putExtra("thirdStackLevel", thirdLevelStack.text.toString())
            intent.putExtra("fourthStackLevel", fourthLevelStack.text.toString())
            intent.putExtra("lastValue", lastValue)
            intent.putExtra("stack", stack as Serializable)
            intent.putExtra("precision", precision)
            intent.putExtra("red", red)
            intent.putExtra("green", green)
            intent.putExtra("blue", blue)
            startActivityForResult(intent, 1)
        }
    }

    override fun onSaveInstanceState(outBundle: Bundle) {
        super.onSaveInstanceState(outBundle)
        outBundle.putString("editTextView", editTextViev.text.toString())
        outBundle.putString("firstLevelStack", firtsLevelStack.text.toString())
        outBundle.putString("secondLevelStack", secondLevelStack.text.toString())
        outBundle.putString("thirdLevelStack", thirdLevelStack.text.toString())
        outBundle.putString("fourthLevelStack", fourthLevelStack.text.toString())
        intent.putExtra("lastValue", lastValue)
        intent.putExtra("stack", stack as Serializable)
        intent.putExtra("precision", precision)
        intent.putExtra("red", red)
        intent.putExtra("green", green)
        intent.putExtra("blue", blue)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    precision = data.getIntExtra("precision", 2)
                    red = data.getIntExtra("red", 255)
                    green = data.getIntExtra("green", 255)
                    blue = data.getIntExtra("blue", 255)
                    relativeLayout.setBackgroundColor(Color.rgb(red, green, blue))
                }
            }
        }
    }
}
