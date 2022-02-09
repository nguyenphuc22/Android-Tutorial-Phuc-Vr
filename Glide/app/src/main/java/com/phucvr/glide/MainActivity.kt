package com.phucvr.glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var imageView : ImageView
    lateinit var btnGifs : Button
    lateinit var btnImages : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        btnImages = findViewById(R.id.btnImage)
        btnGifs = findViewById(R.id.btnGif)

        btnImages.setOnClickListener {
            val urlImage = "https://i.kym-cdn.com/entries/icons/original/000/027/475/Screen_Shot_2018-10-25_at_11.02.15_AM.png"
            Glide.with(this)
                .asBitmap()
                .load(urlImage)
                .into(imageView)
        }

        btnGifs.setOnClickListener {
            val urlGifs = "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif"
            Glide.with(this)
                .asGif()
                .load(urlGifs)
                .into(imageView)
        }


    }
}