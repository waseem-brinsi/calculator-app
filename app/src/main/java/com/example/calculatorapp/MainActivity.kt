package com.example.calculatorapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var dotFlag = false
    var numericFlag = false
    var equalFlag = false

    fun onCLRclick(myView:View ){
        val displayScreen = findViewById<TextView>(R.id.displayScreen)
        displayScreen.text=""
        dotFlag = false
        numericFlag = false
        equalFlag = false
    }

    fun ondotclick(myView:View ){
        if (!dotFlag && numericFlag) {
            val displayScreen = findViewById<TextView>(R.id.displayScreen)
            displayScreen.append(".")
            dotFlag = true
        }
    }

    fun onDigitClick(myView:View ){
        val displayScreen = findViewById<TextView>(R.id.displayScreen)
        displayScreen.append((myView as Button).text)
        numericFlag = true
    }


    fun onClickEqual(myView: View) {
        val displayScreen = findViewById<TextView>(R.id.displayScreen)
        var operation = displayScreen.text.toString()

        //Equal Operation
        if (!equalFlag) {
            try {
                if (operation.contains("+")){
                    var splited = operation.split("+")
                    var num1 = splited[0].toDouble()
                    var num2 = splited[1].toDouble()
                    var resualt: Double = num1 + num2

                    displayScreen.append("=$resualt")
                    Toast.makeText(this, resualt.toString(), Toast.LENGTH_SHORT).show()
                    equalFlag = true
                }
                if (operation.contains("-")){
                    var splited = operation.split("-")
                    var num1 = splited[0].toDouble()
                    var num2 = splited[1].toDouble()
                    var resualt: Double = num1 - num2

                    displayScreen.append("=$resualt")
                    Toast.makeText(this, resualt.toString(), Toast.LENGTH_SHORT).show()
                    equalFlag = true
                }
                if (operation.contains("/")){
                    var splited = operation.split("/")
                    var num1 = splited[0].toDouble()
                    var num2 = splited[1].toDouble()
                    var resualt: Double = num1 / num2

                    displayScreen.append("=$resualt")
                    Toast.makeText(this, resualt.toString(), Toast.LENGTH_SHORT).show()
                    equalFlag = true
                }
                if (operation.contains("*")){
                    var splited = operation.split("*")
                    var num1 = splited[0].toDouble()
                    var num2 = splited[1].toDouble()
                    var resualt: Double = num1 * num2

                    displayScreen.append("=$resualt")
                    Toast.makeText(this, resualt.toString(), Toast.LENGTH_SHORT).show()
                    equalFlag = true
                }
            }
            catch (e:ArithmeticException){
                e.printStackTrace()
            }


        }
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
    }
    fun isOperatorExist(valStr:String):Boolean{
        return (if (valStr.startsWith("-")) {
            return false
        }
        else{
            valStr.contains("*") || valStr.contains("/") ||
                     valStr.contains("+") ||  valStr.contains("-")
        })
    }

    fun onOperate(myView: View){
        val displayScreen = findViewById<TextView>(R.id.displayScreen)
        if (numericFlag && !isOperatorExist(displayScreen.text.toString()) ){
            displayScreen.append((myView as Button).text)
            dotFlag = false
            numericFlag = false
        }

    }


    }

