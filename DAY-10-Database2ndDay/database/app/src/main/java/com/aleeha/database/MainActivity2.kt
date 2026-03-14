package com.aleeha.database

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

class MainActivity2 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
        const val key1 = "com.aleeha.database.MainActivity2.mail"
        const val key2 = "com.aleeha.database.MainActivity2.name"
        const val key3 = "com.aleeha.database.MainActivity2.id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LogIn)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signin = findViewById<Button>(R.id.btnsignIN)
        val username = findViewById<EditText>(R.id.sEmail)


        signin.setOnClickListener{
            val uniqueId = username.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this, "Please Enter Your User Name", Toast.LENGTH_LONG).show()
            }
        }
        val signUP = findViewById<TextView>(R.id.sign)
        signUP.setOnClickListener{
            val signUPIntent = Intent(this, MainActivity::class.java)
            startActivity(signUPIntent)
        }


    }

    private fun readData(uniqueId: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            if (it.exists()){
                val email = it.child("email").value
                val name = it.child("name").value
                val uniqueid = it.child("id").value

                val intentHome = Intent(this, HomeActivity::class.java)
                intentHome.putExtra(key1, email.toString())
                intentHome.putExtra(key2, name.toString())
                intentHome.putExtra(key3, uniqueid.toString())
                startActivity(intentHome)
            }

            else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }

    }
}