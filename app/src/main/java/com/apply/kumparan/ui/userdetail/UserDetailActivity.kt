package com.apply.kumparan.ui.userdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apply.kumparan.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding: ActivityUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        supportActionBar?.title = "User Detail Page"
        setContentView(binding.root)

    }
}