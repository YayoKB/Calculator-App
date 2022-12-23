//Kate Blake ST10195711

package com.varsitycollege.st10195711

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.abs
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtFirst = findViewById<EditText>(R.id.etNoOne)
        val edtSecond = findViewById<EditText>(R.id.etNoTwo)
        val answerText = findViewById<TextView>(R.id.tvAnswer)
        val addBtn = findViewById<Button>(R.id.btnAdd)
        val subtractBtn = findViewById<Button>(R.id.btnSubtract)
        val multiplyBtn = findViewById<Button>(R.id.btnMultiply)
        val divideBtn = findViewById<Button>(R.id.btnDivide)
        val squareRootBtn = findViewById<Button>(R.id.btnSquareRoot)
        val powerBtn = findViewById<Button>(R.id.btnPower)
        val gotoStatBtn = findViewById<Button>(R.id.btnStats)

        addBtn?.setOnClickListener {
            if ((edtFirst.text.toString() == "") or (edtSecond.text.toString() == "")) {
                Toast.makeText(applicationContext, "Please enter both numbers", Toast.LENGTH_LONG).show()
            } else {
                val iFirst = edtFirst.text.toString().toInt()
                val iSecond = edtSecond.text.toString().toInt()
                val answer = iFirst + iSecond
                answerText.text = "$iFirst + $iSecond = $answer"
            }
        }

        subtractBtn?.setOnClickListener {
            if ((edtFirst.text.toString() == "") or (edtSecond.text.toString() == "")) {
                Toast.makeText(applicationContext, "Please enter both numbers", Toast.LENGTH_LONG).show()
            } else {
                val iFirst = edtFirst.text.toString().toInt()
                val iSecond = edtSecond.text.toString().toInt()
                val answer = iFirst - iSecond
                answerText.text = "$iFirst - $iSecond = $answer"
            }
        }

        multiplyBtn?.setOnClickListener {
            if ((edtFirst.text.toString() == "") or (edtSecond.text.toString() == "")) {
                Toast.makeText(applicationContext, "Please enter both numbers", Toast.LENGTH_LONG).show()
            } else {
                val iFirst = edtFirst.text.toString().toInt()
                val iSecond = edtSecond.text.toString().toInt()
                val answer = iFirst * iSecond
                answerText.text = "$iFirst \u00D7 $iSecond = $answer"
            }
        }

        divideBtn?.setOnClickListener {
            if ((edtFirst.text.toString() == "") or (edtSecond.text.toString() == "")) {
                Toast.makeText(applicationContext, "Please enter both numbers", Toast.LENGTH_LONG).show()
            } else {
                val iFirst = edtFirst.text.toString().toInt()
                val iSecond = edtSecond.text.toString().toInt()

                if (iSecond == 0) {
                    Toast.makeText(applicationContext, "Please do not divide by 0", Toast.LENGTH_LONG).show()
                } else {
                    val answer = iFirst.toDouble() / iSecond.toDouble()
                    answerText.text = "$iFirst \u00F7 $iSecond = $answer"
                }
            }

        }

        squareRootBtn?.setOnClickListener {
            if (edtFirst.text.toString() == "") {
                Toast.makeText(applicationContext, "Please enter the first number", Toast.LENGTH_LONG).show()
            } else {
                var iFirst = edtFirst.text.toString().toInt()
                val answer : Double

                if (iFirst < 0) {
                    iFirst = abs(iFirst)
                    answer = sqrt(iFirst.toDouble())
                    answerText.text = "Sqrt(-$iFirst) = $answer i"
                } else {
                    answer = sqrt(iFirst.toDouble())
                    answerText.text = "Sqrt($iFirst) = $answer"
                }
            }
        }

        powerBtn?.setOnClickListener {
            if ((edtFirst.text.toString() == "") or (edtSecond.text.toString() == "")) {
                Toast.makeText(applicationContext, "Please enter both numbers", Toast.LENGTH_LONG).show()
            } else {
                val iFirst = edtFirst.text.toString().toInt()
                val iSecond = edtSecond.text.toString().toInt()
                var answer: Int = iFirst

                for (i in 1 until abs(iSecond)) {
                    answer *= iFirst
                }

                answerText.text = "$iFirst^$iSecond = $answer"
            }
        }

        gotoStatBtn.setOnClickListener {
            Intent(this, StatisticsActivity::class.java).also {
                startActivity(it)
            }
        }
        }
    }
