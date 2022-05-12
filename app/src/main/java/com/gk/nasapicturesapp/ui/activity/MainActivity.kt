package com.gk.nasapicturesapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.gk.nasapicturesapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(mainLooper).postDelayed({
            navigateToImagesGridScreen()
        }, 500)

    }

    private fun navigateToImagesGridScreen() {
        val imagesGridIntent = Intent(this, ImagesGridActivity::class.java)
        startActivity(imagesGridIntent)
        finish()
    }
}