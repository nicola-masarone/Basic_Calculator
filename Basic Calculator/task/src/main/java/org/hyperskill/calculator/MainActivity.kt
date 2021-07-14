package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        findViewById<Button>(R.id.clearButton).setOnClickListener {
            editText.text.clear()
            editText.hint = "0"
        }
        findViewById<Button>(R.id.dotButton).setOnClickListener {
            if (!("." in editText.text)) {
                if (editText.text.isEmpty()) { editText.append("0.") }
                else { editText.text.append(".") }
            }
        }
        findViewById<Button>(R.id.button0).setOnClickListener {
            if (editText.text.toString() != "0") {
                editText.text.append("0")
            }
        }
        findViewById<Button>(R.id.button1).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("1") }
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("2") }
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("3") }
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("4") }
        }
        findViewById<Button>(R.id.button5).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("5") }
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("6") }
        }
        findViewById<Button>(R.id.button7).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("7") }
        }
        findViewById<Button>(R.id.button8).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("8") }
        }
        findViewById<Button>(R.id.button9).setOnClickListener {
            if (editText.text.toString() != "0") { editText.text.append("9") }
        }
        var firstVal = ""
        var secondVal = ""
        var op = ' '
        findViewById<Button>(R.id.addButton).setOnClickListener {
            if (editText.text.isNotEmpty()) {
                firstVal = editText.text.toString()
                editText.text.clear()
                editText.hint = firstVal
                op = '+'
            }
        }
        findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            if (editText.text.isNotEmpty()) {
                firstVal = editText.text.toString()
                editText.text.clear()
                editText.hint = firstVal
                op = 'x'
            }
        }
        findViewById<Button>(R.id.divideButton).setOnClickListener {
            if (editText.text.isNotEmpty()) {
                firstVal = editText.text.toString()
                editText.text.clear()
                editText.hint = firstVal
                op = '/'
            }
        }
        findViewById<Button>(R.id.subtractButton).setOnClickListener {
            if (editText.text.isNotEmpty()) {
                firstVal = editText.text.toString()
                editText.text.clear()
                editText.hint = firstVal
                op = '-'
            }
            else { editText.text.append('-') }
        }
        findViewById<Button>(R.id.equalButton).setOnClickListener {
            if (editText.text.isNotEmpty()) {
                secondVal = editText.text.toString()
                editText.text.clear()
                var resNum = 0.0
                var error = false
                var resString = ""
                when(op) {
                    '+' -> { resNum = firstVal.toDouble() + secondVal.toDouble() }
                    'x' -> { resNum = firstVal.toDouble() * secondVal.toDouble() }
                    '-' -> { resNum = firstVal.toDouble() - secondVal.toDouble() }
                    '/' -> { if (secondVal.toDouble() != 0.0) { resNum = firstVal.toDouble() / secondVal.toDouble() }
                             else { error = true }
                    }
                }
                resString = if(!error) { resNum.toString() } else { "Error!" }
                if (resString.substringAfter(".") == "0") { resString = resString.substringBefore(".") }
                editText.text.append(resString)
            }
        }
    }
}