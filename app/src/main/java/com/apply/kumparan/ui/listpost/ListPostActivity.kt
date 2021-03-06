package com.apply.kumparan.ui.listpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apply.kumparan.data.response.PostResponse
import com.apply.kumparan.data.response.UserResponse
import com.apply.kumparan.databinding.ActivityListPostBinding
import com.apply.kumparan.ui.detailpost.DetailPostActivity
import com.apply.kumparan.viewmodel.ViewModelFactory

class ListPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListPostBinding
    private lateinit var viewModel: ListPostViewModel
    private val posts = ArrayList<PostResponse>()
    private val adapter = ListPostAdapter(posts)
    private lateinit var users: ArrayList<UserResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPostBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[ListPostViewModel::class.java]
        showRecyclerView()
        getListPost()

        viewModel.getUsers().observe(this, Observer {
            users = it
        })
    }

    private fun showRecyclerView() {
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickCallback(object : ListPostAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PostResponse) {
                Intent(this@ListPostActivity, DetailPostActivity::class.java).also {
                    it.putExtra(DetailPostActivity.EXTRA_POST, data)
                    it.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(it)
                }
            }
        })
        adapter.setUser(object: ListPostAdapter.GetUser {
            override fun getUser(userId: Int): UserResponse? {
                var response: UserResponse? = null
                users.forEach { if (it.id == userId) { response = it } }
                return response
            }
        })

        binding.apply {
            rvPosts.layoutManager = LinearLayoutManager(this@ListPostActivity)
            rvPosts.setHasFixedSize(true)
            rvPosts.adapter = adapter
        }
    }

    private fun getListPost() {
        viewModel.getListPost().observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
            }
        })
    }
}