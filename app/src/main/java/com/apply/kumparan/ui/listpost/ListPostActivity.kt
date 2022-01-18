package com.apply.kumparan.ui.listpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apply.kumparan.R
import com.apply.kumparan.data.response.PostResponse
import com.apply.kumparan.databinding.ActivityListPostBinding
import com.apply.kumparan.viewmodel.ViewModelFactory

class ListPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListPostBinding
    private lateinit var viewModel: ListPostViewModel
    private val posts = ArrayList<PostResponse>()
    private val adapter = ListPostAdapter(posts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPostBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[ListPostViewModel::class.java]
        showRecyclerView()
        getListPost()
    }

    private fun showRecyclerView() {
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickCallback(object : ListPostAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PostResponse) {

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