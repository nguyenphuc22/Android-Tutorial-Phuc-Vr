package com.phucvr.intent_parcelize_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("Person",Person("Nick Seven",21,true,"Nothing"))
            startActivity(intent)
        }
    }
}