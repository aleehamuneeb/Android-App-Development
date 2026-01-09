package com.aleeha.welcomemessage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val btnClick=findViewById<Button>(R.id.btnclick)
        val editText=findViewById<EditText>(R.id.edittext)

        btnClick.setOnClickListener {
            val name = editText.text.toString() // Get text from box
            val intent = Intent(this, message::class.java)
            // Passing the name to the next activity
            intent.putExtra("USER_NAME", name)
            startActivity(intent)

        }
    }
}