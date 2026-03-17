package com.aleeha.viewbinding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aleeha.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button.setOnClickListener {
            val name = binding.etname.text.toString()
            val email = binding.etemail.text.toString()

            if(binding.checkBox.isChecked){

                val intent = Intent(this, MainActivity2::class.java).apply{
                    putExtra("name", name)
                    putExtra("Email", email)
                }
                startActivity(intent)
            } else{
                Toast.makeText(this, "Please Accept out T&C", Toast.LENGTH_SHORT).show()
            }
        }
    }
}