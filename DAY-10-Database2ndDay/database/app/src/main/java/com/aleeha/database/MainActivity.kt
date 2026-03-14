package com.aleeha.database

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
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signupbtn = findViewById<Button>(R.id.btnsignup)
        val mail = findViewById<EditText>(R.id.Email)
        val name = findViewById<EditText>(R.id.Name)
        val password = findViewById<EditText>(R.id.Password)
        val ID = findViewById<EditText>(R.id.UniqueId)

        signupbtn.setOnClickListener {
            val name = name.text.toString()
            val password = password.text.toString()
            val mail = mail.text.toString()
            val ID = ID.text.toString()
            val user = User(name, mail, password, ID)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(ID).setValue(user).addOnSuccessListener {

                val signINIntent = Intent(this, MainActivity2::class.java)
                startActivity(signINIntent)
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
        val signIn = findViewById<TextView>(R.id.signIn)
        signIn.setOnClickListener{
            val signINIntent = Intent(this, MainActivity2::class.java)
            startActivity(signINIntent)
        }
    }
}