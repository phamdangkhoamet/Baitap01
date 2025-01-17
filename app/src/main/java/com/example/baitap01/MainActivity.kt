package com.example.baitap01

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.view.KeyEvent
import androidx.compose.ui.tooling.preview.Preview
import com.example.baitap01.ui.theme.Baitap01Theme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomNumber: Button = findViewById(R.id.RandomNumber)
        val enterClass: EditText = findViewById(R.id.EnterClass)
        val tvClass: TextView = findViewById(R.id.tvClass)

        randomNumber.setOnClickListener {
            generateAndLogRandomNumbers()
        }

        enterClass.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || event?.keyCode == KeyEvent.KEYCODE_ENTER) {
                val enteredClass = enterClass.text.toString()
                val reversedClass = enteredClass.reversed().uppercase()

                if (enteredClass.isNotEmpty()) {
                    tvClass.text = enteredClass

                    Toast.makeText(this, "Lớp: $reversedClass", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Vui lòng nhập lớp!", Toast.LENGTH_SHORT).show()
                }
                true
            } else {
                false
            }
        }
    }

    private fun generateAndLogRandomNumbers() {
        val numbers = ArrayList<Int>()
        val oddNumbers = ArrayList<Int>()
        val evenNumbers = ArrayList<Int>()

        val random = Random()

        for (i in 0 until 100) {
            val randomNumber = random.nextInt(100) + 1
            numbers.add(randomNumber)

            if (randomNumber % 2 == 0) {
                evenNumbers.add(randomNumber)
            } else {
                oddNumbers.add(randomNumber)
            }
        }

        Log.d("RandomNumbers", "Even Numbers: " + evenNumbers.toString())
        Log.d("RandomNumbers", "Odd Numbers: " + oddNumbers.toString())
    }
}