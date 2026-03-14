package com.aleeha.database

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra(MainActivity2.key2)
        val mail = intent.getStringExtra(MainActivity2.key1)
        val userid = intent.getStringExtra(MainActivity2.key3)

        val welcomeText = findViewById<TextView>(R.id.tvWelcome)
        val Mail = findViewById<TextView>(R.id.tvmail)
        val ID = findViewById<TextView>(R.id.tvid)

        welcomeText.text = "Welcome $name"
        Mail.text = "EMail : $mail"
        ID.text = "UserID : $userid"

    }
}