package com.apply.kumparan.ui.userdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apply.kumparan.data.response.AlbumResponse
import com.apply.kumparan.data.response.PhotoResponse
import com.apply.kumparan.data.response.UserResponse
import com.apply.kumparan.databinding.ActivityUserDetailBinding
import com.apply.kumparan.viewmodel.ViewModelFactory

class UserDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding: ActivityUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel
    private val albums = ArrayList<AlbumResponse>()
    private val albumsAdapter = UserAlbumsAdapter(albums)
    private lateinit var photos: ArrayList<PhotoResponse>

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
        viewModel.getPhotos().observe(this, Observer { photos = it })
        showRecyclerView()
        getUserAlbums(user.id)
    }

    private fun showRecyclerView() {
        albumsAdapter.notifyDataSetChanged()
        albumsAdapter.setPhotos(object: UserAlbumsAdapter.GetPhotos {
            override fun getPhotos(albumId: Int): ArrayList<PhotoResponse>? {
                return viewModel.getAlbumsPhotos(albumId).value
            }
        } )

        binding.apply {
            rvAlbums.layoutManager = LinearLayoutManager(this@UserDetailActivity)
            rvAlbums.setHasFixedSize(true)
            rvAlbums.adapter = albumsAdapter
        }
    }

    private fun getUserAlbums(userId: Int?) {
        if (userId != null) {
            viewModel.getUserAlbums(userId).observe(this, Observer {
                if (it != null) {
                    albumsAdapter.setList(it)
                }
            })
        }
    }
}