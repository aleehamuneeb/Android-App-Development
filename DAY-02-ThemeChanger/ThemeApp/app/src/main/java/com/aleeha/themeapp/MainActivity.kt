package com.aleeha.themeapp

import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.constraintlayout.widget.ConstraintLayout
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
        val darkBtn=findViewById<Button>(R.id.btndark)
        val readBtn=findViewById<Button>(R.id.btnread)
        val linearLayout=findViewById<LinearLayout>(R.id.linearLayout)
        val main=findViewById<LinearLayout>(R.id.main)
        val text=findViewById<TextView>(R.id.name)
        val defaultBtn=findViewById<Button>(R.id.btnDefault)

        readBtn.setOnClickListener(){

            linearLayout.setBackgroundResource(R.color.teal)
            readBtn.setBackgroundColor(R.color.beige)
            darkBtn.setBackgroundColor(R.color.beige)
            defaultBtn.setBackgroundColor(R.color.beige)
            text.setBackgroundColor(R.color.beige)


        }
        darkBtn.setOnClickListener(){

            linearLayout.setBackgroundResource(R.color.black)
            readBtn.setBackgroundColor(R.color.purole)
            darkBtn.setBackgroundColor(R.color.purole)
            defaultBtn.setBackgroundColor(R.color.purole)
            text.setBackgroundColor(R.color.white)

        }
        defaultBtn.setOnClickListener(){
            recreate()


        }

    }
}