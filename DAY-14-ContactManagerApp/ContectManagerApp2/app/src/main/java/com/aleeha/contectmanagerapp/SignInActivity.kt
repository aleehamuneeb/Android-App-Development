package com.aleeha.contectmanagerapp

import User
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.jvm.java
import kotlin.text.replace

class SignInActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.etname)
        val email = findViewById<EditText>(R.id.etemail)
        val password = findViewById<EditText>(R.id.etpassword)
        val signup = findViewById<Button>(R.id.signup)
        val Aaccount = findViewById<TextView>(R.id.paccount)

        signup.setOnClickListener{
            val name = name.text.toString()
            val mail = email.text.toString()
            val sanitizedEmail = mail.replace(".", ",")
            val password = password.text.toString()
            val user = User(name, mail, password)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(sanitizedEmail).setValue(user).addOnSuccessListener{
                val LogINIntent = Intent(this, LogIn::class.java)
                startActivity(LogINIntent)
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
        Aaccount.setOnClickListener{
            val LogINIntent = Intent(this, LogIn::class.java)
            startActivity(LogINIntent)
        }



    }
}