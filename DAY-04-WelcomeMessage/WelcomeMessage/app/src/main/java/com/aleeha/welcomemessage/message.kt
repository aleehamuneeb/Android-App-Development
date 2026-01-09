package com.aleeha.welcomemessage

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class message : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mesage)

        val outputtext = findViewById<TextView>(R.id.output)
        val name = intent.getStringExtra("USER_NAME")

        if (name != null) {
            outputtext.text = "Hello, $name!"
        }
    }
}