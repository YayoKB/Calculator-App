package com.varsitycollege.st10195711

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val addNoBtn = findViewById<Button>(R.id.btnAddNumber)
        val clearBtn = findViewById<Button>(R.id.btnClear)
        val calcAvgBtn = findViewById<Button>(R.id.btnCalcAvg)
        val minMaxBtn = findViewById<Button>(R.id.btnMinMax)
        val edtNumbers = findViewById<EditText>(R.id.edtNumbers)
        val tvNumbersArray = findViewById<TextView>(R.id.tvArray)
        val statResult = findViewById<TextView>(R.id.tvStatResult)

        var counter = 0
        val arrNumbers = arrayOf<Int>().toMutableList()
        var arrNumbersString = ""

        addNoBtn.setOnClickListener {

            if (edtNumbers.text.toString() == "") {
                Toast.makeText(applicationContext, "Please enter a number", Toast.LENGTH_LONG).show()
            } else {
                val newNo = edtNumbers.text.toString().toInt()
                arrNumbers.add(newNo)
                arrNumbersString += "${arrNumbers[counter]}, "
                counter += 1
                edtNumbers.text.clear()
                val stringLength : Int = arrNumbersString.length
                val displayString = arrNumbersString.subSequence(0, stringLength-2).toString()
                tvNumbersArray.text = displayString

                if (counter >= 10) {
                    addNoBtn.isEnabled = false
                }
            }
        }

        clearBtn.setOnClickListener {
            arrNumbers.clear()
            arrNumbersString = ""
            tvNumbersArray.text = "None"
            addNoBtn.isEnabled = true
            counter = 0
        }

        calcAvgBtn.setOnClickListener {
            if (arrNumbers.size == 0) {
                Toast.makeText(applicationContext, "Please enter a number", Toast.LENGTH_LONG).show()
            } else {
                val average: Double
                var total = 0.0

                for (number in 0 until arrNumbers.size) {
                    total += arrNumbers[number]
                }

                average = total / arrNumbers.size
                statResult.text = "The average is $average"
            }
        }

        minMaxBtn.setOnClickListener {
            if (arrNumbers.size == 0) {
                Toast.makeText(applicationContext, "Please enter a number", Toast.LENGTH_LONG).show()
            } else {
                var min = arrNumbers[0]
                var max = arrNumbers[0]

                for (number in 0 until arrNumbers.size) {
                    if (min > arrNumbers[number]) {
                        min = arrNumbers[number]
                    }
                    if (max < arrNumbers[number]) {
                        max = arrNumbers[number]
                    }
                    var displayString = "The minimum is: $min\n"
                    displayString += "The maximum is: $max"
                    statResult.text = displayString
                }
            }
        }
    }
}