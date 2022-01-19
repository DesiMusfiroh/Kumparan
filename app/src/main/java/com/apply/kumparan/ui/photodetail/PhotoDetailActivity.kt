package com.apply.kumparan.ui.photodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.apply.kumparan.R
import com.apply.kumparan.databinding.ActivityPhotoDetailBinding
import com.apply.kumparan.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

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

        val extras = intent.extras
        val photoId = extras!!.getInt(EXTRA_PHOTO)

        viewModel.getDetailPhoto(photoId).observe(this, { photo ->
            binding.apply {
                tvTitle.text = photo.title
                Glide.with(this@PhotoDetailActivity)
                        .load(photo.url)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPhoto)
            }
        })

    }
}