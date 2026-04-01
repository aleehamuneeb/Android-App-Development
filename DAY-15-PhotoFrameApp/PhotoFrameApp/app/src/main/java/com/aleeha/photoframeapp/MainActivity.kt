package com.aleeha.photoframeapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var currentiamge = 0
    var names = arrayOf("Quaid-e-azam", "Allam Iqbal", "Fatima Jinnah", "Banzeer Bhutto", "Major Aziz Bhatti")
    lateinit var image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.btnprev)
        val next = findViewById<ImageButton>(R.id.btnnext)
        val text = findViewById<TextView>(R.id.btnname)

        prev.setOnClickListener {
            val idcurrentimgstring = "pic$currentiamge"
            val idcurrentimgint = this.resources.getIdentifier(idcurrentimgstring, "id", packageName)

            image = findViewById(idcurrentimgint)
            image.alpha = 0f
            currentiamge = (5+currentiamge-1)%5

            val idimagetoshowstring = "pic$currentiamge"
            val idimagetoshowint = this.resources.getIdentifier(idimagetoshowstring, "id", packageName)
            image = findViewById(idimagetoshowint)
            image.alpha = 1f
            text.text = names[currentiamge]
        }

        next.setOnClickListener {
            val idcurrentimagestring = "pic$currentiamge"
            val idcurrentimageint = this.resources.getIdentifier(idcurrentimagestring, "id", packageName)
            image = findViewById(idcurrentimageint)
            image.alpha = 0f
            currentiamge = (5+ currentiamge+1)%5
            val idimagetoshowstring = "pic$currentiamge"
            val idimagetoshowint = this.resources.getIdentifier(idimagetoshowstring, "id", packageName)
            image = findViewById(idimagetoshowint)
            image.alpha = 1f
            text.text = names[currentiamge]
        }
    }
}