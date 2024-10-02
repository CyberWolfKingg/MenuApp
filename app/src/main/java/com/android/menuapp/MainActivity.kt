package com.android.menuapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMenu: Button = findViewById(R.id.buttonMenu)
        val buttonConnect: Button = findViewById(R.id.buttonConnect)

        // Navigation to the menu screen
        buttonMenu.setOnClickListener {
            val intent = Intent(this, DishListActivity::class.java)
            startActivity(intent)
        }

        // Navigation to the connection screen
        buttonConnect.setOnClickListener {
            val intent = Intent(this, SocialConnectActivity::class.java)
            startActivity(intent)
        }

    }
}