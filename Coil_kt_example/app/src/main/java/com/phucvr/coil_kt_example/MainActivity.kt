package com.phucvr.coil_kt_example

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation

class MainActivity : AppCompatActivity() {
    val uri = "https://i.pinimg.com/originals/d5/92/bb/d592bb659a23b715659f9fa1b7ed8798.jpg"
    val uriGif =  "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif"
    lateinit var imageView : ImageView
    lateinit var imageView2 : ImageView
    lateinit var imageView3: ImageView
    lateinit var imageView4: ImageView
    lateinit var imageView5: ImageView
    lateinit var imageView6: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)

        imageView.load(uri)
        // Animation Loading
        imageView2.load(uri) {
            placeholder(R.drawable.ic_launcher_foreground)
            crossfade(true)
            crossfade(1000)
        }
        // Loading - Trans Gray Picture
        imageView3.load(uri) {
            transformations(GrayscaleTransformation())
        }
        // Loading - Trans Cir Picture
        imageView4.load(uri) {
            transformations(CircleCropTransformation())
        }
        // Loading - Round,Gray,Blur Trans Picture
        imageView5.load(uri) {
            transformations(BlurTransformation(applicationContext),
                GrayscaleTransformation(),
                RoundedCornersTransformation(36f))
        }
        // Loading - Gif
        val imageLoader = ImageLoader.Builder(applicationContext)
            .componentRegistry {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder(applicationContext))
                } else {
                    add(GifDecoder())
                }
            }
            .build()
        imageView6.load(uriGif,imageLoader)
    }
}