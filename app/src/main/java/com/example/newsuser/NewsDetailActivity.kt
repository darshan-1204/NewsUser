package com.example.newsuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.newsuser.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title = intent.getStringExtra("title")
        var img = intent.getStringExtra("img")
        var description = intent.getStringExtra("desc")

        binding.title.text = title
        binding.descNd.text = description
        Glide.with(this).load(img).into(binding.imgNd)
    }
}