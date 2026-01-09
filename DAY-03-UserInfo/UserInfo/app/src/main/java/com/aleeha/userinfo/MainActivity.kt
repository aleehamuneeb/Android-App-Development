package com.aleeha.userinfo

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

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

        val editName=findViewById<EditText>(R.id.editName)
        val editPassword=findViewById<EditText>(R.id.editPassword)
        val editAddress=findViewById<EditText>(R.id.editAddress)
        val rbmale=findViewById<RadioButton>(R.id.malebtn)
        val rbfemale=findViewById<RadioButton>(R.id.btnfemale)
        val editAge=findViewById<EditText>(R.id.editAge)
        val editdob=findViewById<EditText>(R.id.editDOB)
        val state=findViewById<Spinner>(R.id.spinner)
        val submitbtn=findViewById<Button>(R.id.submitbtn)
        val result=findViewById<TextView>(R.id.outputbtn)
        val states=arrayOf("Select State", "Punjab", "Sindh", "KPK", "Balochistan", "Gilgit")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, states)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        state.adapter = adapter

        // 3. Setup DatePicker for DOB field
        editdob.isFocusable = false // Prevent keyboard from opening
        editdob.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                    val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    editdob.setText(date)
                }, year, month, day)

            datePickerDialog.show()
        }

        // 4. Submit Button Logic
        submitbtn.setOnClickListener {
            val name = editName.text.toString()
            val password = editPassword.text.toString()
            val address = editAddress.text.toString()
            val age = editAge.text.toString()
            val dob = editdob.text.toString()
            val selectedState = state.selectedItem.toString()

            val gender = when {
                rbmale.isChecked -> "Male"
                rbfemale.isChecked -> "Female"
                else -> "Not Selected"
            }

            // Validation check
            if (name.isEmpty() || password.isEmpty() || selectedState == "Select State") {
                Toast.makeText(this, "Please fill required fields", Toast.LENGTH_SHORT).show()
            } else {
                // Displaying the result in the bottom TextView
                val summary = """
                    Registration Successful!
                    Name: $name
                    Address: $address
                    Gender: $gender
                    Age: $age
                    DOB: $dob
                    State: $selectedState
                """.trimIndent()

                result.text = summary
            }
    }

}}