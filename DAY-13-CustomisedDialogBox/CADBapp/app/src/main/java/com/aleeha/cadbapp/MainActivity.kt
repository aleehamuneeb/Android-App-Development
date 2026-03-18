package com.aleeha.cadbapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aleeha.cadbapp.databinding.ActivityMainBinding
import com.aleeha.cadbapp.databinding.CustomisedAlertDialogBoxBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var binding1: CustomisedAlertDialogBoxBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding1 = CustomisedAlertDialogBoxBinding.inflate(layoutInflater)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dialog = Dialog(this)
        dialog.setContentView(binding1.root)
        binding1.btnbad.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "We'll make it better for users better experience.", Toast.LENGTH_LONG).show()

        }
        binding1.btngood.setOnClickListener {
            Toast.makeText(this, "Thanks for your feedback.", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        binding.button.setOnClickListener {
            dialog.show()
        }
    }
}