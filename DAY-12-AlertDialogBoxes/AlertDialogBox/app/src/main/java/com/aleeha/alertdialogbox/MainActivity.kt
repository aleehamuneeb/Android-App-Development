package com.aleeha.alertdialogbox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aleeha.alertdialogbox.databinding.ActivityMainBinding

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
        // No actions will perform because it is just a prototyp.

        binding.tvcountry.setOnClickListener {
            val builderc = AlertDialog.Builder(this)
            builderc.setTitle("What is your Nationality?")
            builderc.setMessage("Are you Pakistani?")
            builderc.setPositiveButton("Yes", DialogInterface.OnClickListener{ dialoginterface, i -> })
            builderc.setNegativeButton("No", DialogInterface.OnClickListener{ dialoginterface, i -> })
            builderc.show()
        }
        binding.tvgender.setOnClickListener {
            val gender = arrayOf("Male", "Female", "Other")
            val builderg = AlertDialog.Builder(this)
            builderg.setTitle("What is your Gender?")
            builderg.setSingleChoiceItems(gender, 0, DialogInterface.OnClickListener{ dialog, which ->
                Toast.makeText(this, "You Checked ${gender[which]}", Toast.LENGTH_SHORT).show()
            })
            builderg.setPositiveButton("Enter", DialogInterface.OnClickListener{ dialoginterface, i -> })
            builderg.setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialoginterface, i -> })
            builderg.show()
        }
        binding.tvhobbies.setOnClickListener {
            val hobbies = arrayOf("Reading", "Writing", "Gardening", "Exploring", "scrolling Reels", "Making Apps", "Designing")
            val builderh = AlertDialog.Builder(this)
            builderh.setTitle("What are your Hobbies?")
            builderh.setMultiChoiceItems(hobbies, null, DialogInterface.OnMultiChoiceClickListener{ dialog, which, isChecked ->
                Toast.makeText(this, "You Checked ${hobbies[which]}", Toast.LENGTH_SHORT).show()
            })
            builderh.setPositiveButton("Enter", DialogInterface.OnClickListener{ dialoginterface, i -> })
            builderh.setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialoginterface, i -> })
            builderh.show()
        }

        binding.btnexit.setOnClickListener {
            finish()
        }

    }
}