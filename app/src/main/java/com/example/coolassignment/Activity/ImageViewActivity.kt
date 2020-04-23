package com.example.coolassignment.Activity

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.example.coolassignment.R


class ImageViewActivity : AppCompatActivity() {
    internal lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportActionBar != null)
            this.supportActionBar!!.hide()

        setContentView(R.layout.activity_image_view)

        val bundle = intent.extras

        val u = bundle!!.getString("url")

        imageView = findViewById(R.id.image_show)

        Glide.with(applicationContext)
                .load(u)
                .into(imageView)

    }

}
