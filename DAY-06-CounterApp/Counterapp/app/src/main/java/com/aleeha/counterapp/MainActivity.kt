package com.aleeha.counterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Declare a variable to hold the current count
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the views from the layout file
        val counterTextView: TextView = findViewById(R.id.textcount)
        val countButton: Button = findViewById(R.id.btnCount)
        val resetButton: Button = findViewById(R.id.resetbtn)
        // Optional: you can also set the static text programmatically
        // staticTextView.text = "Button clicks:"

        // Set a click listener for the button
        countButton.setOnClickListener {
            // Increment the counter
            count++
            // Update the text of the counterTextView to show the new count
            counterTextView.text = count.toString()
        }

        // Set a click listener for the reset button
        resetButton.setOnClickListener {
            // Reset the counter to 0
            count = 0
            // Update the text of the counterTextView to show "0"
            counterTextView.text = count.toString()
        }
    }
}
