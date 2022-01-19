package com.apply.kumparan.ui.userdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.apply.kumparan.data.response.UserResponse
import com.apply.kumparan.databinding.ActivityUserDetailBinding
import com.apply.kumparan.viewmodel.ViewModelFactory

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[UserDetailViewModel::class.java]

        val user = intent.getParcelableExtra<UserResponse>(EXTRA_USER) as UserResponse
        binding.apply {
            tvName.text = user.name
            tvEmail.text = user.email
            tvAddress.text = StringBuilder("${user.address?.street}, ${user.address?.suite}, ${user.address?.city}. Postcode: ${user.address?.zipcode}")
            tvCompany.text = user.company?.name
        }

    }
}