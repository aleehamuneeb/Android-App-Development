package com.aleeha.contectmanagerapp

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

class LogIn : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val email = findViewById<EditText>(R.id.etmail)
        val password = findViewById<EditText>(R.id.epassword)
        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            val email = email.text.toString()
            val safeEmail = email.replace(".", ",")
            val password = password.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                readData(safeEmail)
            } else {
                Toast.makeText(this, "Please fill all fields to continue.", Toast.LENGTH_LONG)
                    .show()
            }
            val signUP = findViewById<TextView>(R.id.account)
            signUP.setOnClickListener {
                val signUPIntent = Intent(this, SignInActivity::class.java)
                startActivity(signUPIntent)
            }
        }
    }

    private fun readData(email: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(email).get().addOnSuccessListener {
            if(it.exists()) {
              val intentmain = Intent(this, MainActivity::class.java)
              startActivity(intentmain)
            }
            else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }
}

