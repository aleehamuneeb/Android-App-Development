package com.aleeha.registrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val firstName = findViewById<TextInputLayout>(R.id.firstName)
        val secondName = findViewById<TextInputLayout>(R.id.secondName)
        val password = findViewById<TextInputLayout>(R.id.password)
        val email = findViewById<TextInputLayout>(R.id.email)
        val submit = findViewById<Button>(R.id.submitbtn)
        submit.setOnClickListener(){
            val name = firstName.editText?.text.toString()
            val secondName = secondName.editText?.text.toString()
            val password = password.editText?.text.toString()
            val email = email.editText?.text.toString()

        }

    }
}