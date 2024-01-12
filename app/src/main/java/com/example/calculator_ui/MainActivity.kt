package com.example.calculator_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.btnAc
import kotlinx.android.synthetic.main.activity_main.btnAddition
import kotlinx.android.synthetic.main.activity_main.btnDivide
import kotlinx.android.synthetic.main.activity_main.btnEight
import kotlinx.android.synthetic.main.activity_main.btnEqualto
import kotlinx.android.synthetic.main.activity_main.btnFive
import kotlinx.android.synthetic.main.activity_main.btnFour
import kotlinx.android.synthetic.main.activity_main.btnMultiply
import kotlinx.android.synthetic.main.activity_main.btnNine
import kotlinx.android.synthetic.main.activity_main.btnOne
import kotlinx.android.synthetic.main.activity_main.btnSeven
import kotlinx.android.synthetic.main.activity_main.btnSix
import kotlinx.android.synthetic.main.activity_main.btnSubstract
import kotlinx.android.synthetic.main.activity_main.btnThree
import kotlinx.android.synthetic.main.activity_main.btnTwo
import kotlinx.android.synthetic.main.activity_main.btnZero
import kotlinx.android.synthetic.main.activity_main.tvDisplay
import kotlinx.android.synthetic.main.activity_main.tvResult
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAc.setOnClickListener(){

            resultClear()
        }

        btnOne.setOnClickListener(){

            appendToDisplay("1")
        }
        btnTwo.setOnClickListener(){
            appendToDisplay("2")
        }
        btnThree.setOnClickListener(){
            appendToDisplay("3")
        }
        btnFour.setOnClickListener(){
            appendToDisplay("4")
        }
        btnFive.setOnClickListener(){
            appendToDisplay("5")
        }
        btnSix.setOnClickListener(){
            appendToDisplay("6")
        }
        btnSeven.setOnClickListener(){
            appendToDisplay("7")
        }
        btnEight.setOnClickListener(){
            appendToDisplay("8")
        }
        btnNine.setOnClickListener(){
            appendToDisplay("9")
        }
        btnAddition.setOnClickListener(){
            appendToDisplay("+")
        }
        btnSubstract.setOnClickListener(){
            appendToDisplay("-")
        }
        btnMultiply.setOnClickListener(){
            appendToDisplay("*")
        }
        btnDivide.setOnClickListener(){
            appendToDisplay("/")
        }
        btnEqualto.setOnClickListener(){
            calculateResult()

        }
        btnZero.setOnClickListener(){
            appendToDisplay("0")
        }

    }
    private fun appendToDisplay(value: String) {
        val currentText = tvDisplay.text.toString()
        tvDisplay.text = currentText + value
    }
    fun resultClear(){
        tvDisplay.text = ""
        tvResult.text = ""
    }
    private fun calculateResult() {
        try {
            val expression = tvDisplay.text.toString()
            val result = ExpressionBuilder(expression).build().evaluate()
            tvResult.text = result.toString()
        } catch (e: Exception) {
            tvResult.text = "Error"
        }
    }

}

