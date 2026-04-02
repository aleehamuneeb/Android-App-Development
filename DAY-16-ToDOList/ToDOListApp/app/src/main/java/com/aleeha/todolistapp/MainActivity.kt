package com.aleeha.todolistapp

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
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
        val listView = findViewById<ListView>(R.id.ListView)

        val Tasklist = arrayListOf<String>()
        Tasklist.add("Recite Quran")
        Tasklist.add("Say Prayers")
        Tasklist.add("Go to uni")
        Tasklist.add("Prepare test")
        Tasklist.add("Buy some fruits")

        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Tasklist)

        listView.adapter = listAdapter

        listView.setOnItemClickListener{ parent, view, position, id ->
            val text = "Clicked on item " +(view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}