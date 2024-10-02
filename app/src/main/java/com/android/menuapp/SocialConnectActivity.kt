package com.android.menuapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SocialConnectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_connect)

        val buttonFacebook: ImageButton = findViewById(R.id.buttonFacebook)
        val buttonInstagram: ImageButton = findViewById(R.id.buttonInstagram)
        val buttonWebsite: ImageButton = findViewById(R.id.buttonWebsite)

        buttonFacebook.setOnClickListener {
            openUrl("https://www.facebook.com/christoffel")
        }

        buttonInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/christoffel")
        }

        buttonWebsite.setOnClickListener {
            openUrl("https://www.christoffelwebsite.com")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}