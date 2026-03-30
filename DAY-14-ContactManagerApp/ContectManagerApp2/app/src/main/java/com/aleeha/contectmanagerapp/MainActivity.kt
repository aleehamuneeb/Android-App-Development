package com.aleeha.contectmanagerapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import number

class MainActivity : AppCompatActivity() {
    lateinit var dialog : Dialog
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

        val name = findViewById<EditText>(R.id.etname)
        val number = findViewById<EditText>(R.id.etnumber)
        val add = findViewById<Button>(R.id.add)

        add.setOnClickListener {
            val name = name.text.toString()
            val number = number.text.toString()
            val num = number(name, number)
            database = FirebaseDatabase.getInstance().getReference("contact")
            database.child(number).setValue(num).addOnSuccessListener {
                dialog = Dialog(this)
                dialog.setContentView(R.layout.alertdiaologbox)

                val btnok = dialog.findViewById<Button>(R.id.ok)
                btnok.setOnClickListener {
                    dialog.dismiss()
                }
                dialog.show()
            }
                .addOnFailureListener {
                    Toast.makeText(this, "Please try again!", Toast.LENGTH_SHORT).show()
                }
        }

    }
}