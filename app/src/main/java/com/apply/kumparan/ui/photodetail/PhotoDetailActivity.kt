package com.apply.kumparan.ui.photodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.apply.kumparan.databinding.ActivityPhotoDetailBinding
import com.apply.kumparan.viewmodel.ViewModelFactory

class PhotoDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PHOTO = "extra_photo"
    }

    private lateinit var binding: ActivityPhotoDetailBinding
    private lateinit var viewModel: PhotoDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoDetailBinding.inflate(layoutInflater)
        supportActionBar?.title = "Photo Detail Page"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[PhotoDetailViewModel::class.java]


    }
}