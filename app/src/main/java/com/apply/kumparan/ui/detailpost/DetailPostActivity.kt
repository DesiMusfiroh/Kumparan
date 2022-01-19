package com.apply.kumparan.ui.detailpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apply.kumparan.data.response.CommentResponse
import com.apply.kumparan.data.response.PostResponse
import com.apply.kumparan.databinding.ActivityDetailPostBinding
import com.apply.kumparan.ui.userdetail.UserDetailActivity
import com.apply.kumparan.viewmodel.ViewModelFactory
import java.lang.StringBuilder

class DetailPostActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_POST = "extra_post"
    }

    private lateinit var binding: ActivityDetailPostBinding
    private lateinit var viewModel: DetailPostViewModel
    private val comments = ArrayList<CommentResponse>()
    private val commentsAdapter = PostCommentsAdapter(comments)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPostBinding.inflate(layoutInflater)
        supportActionBar?.title = "Detail Post Page"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailPostViewModel::class.java]

        val post = intent.getParcelableExtra<PostResponse>(EXTRA_POST) as PostResponse
        val postId = post.id
        val userId = post.userId

        binding.apply {
            tvTitle.text = post.title
            tvBody.text = post.body
        }

        showRecyclerView()
        getPostComments(postId)
        getDetailUser(userId)
    }

    private fun showRecyclerView() {
        commentsAdapter.notifyDataSetChanged()
        binding.apply {
            rvComments.layoutManager = LinearLayoutManager(this@DetailPostActivity)
            rvComments.setHasFixedSize(true)
            rvComments.adapter = commentsAdapter
        }
    }

    private fun getPostComments(postId: Int?) {
        if (postId != null) {
            viewModel.getPostComments(postId).observe(this, Observer {
                if (it != null) {
                    commentsAdapter.setList(it)
                }
            })
        }
    }

    private fun getDetailUser(userId: Int?) {
        if (userId != null) {
            viewModel.getDetailUser(userId).observe(this, Observer { user ->
                binding.tvUser.text = StringBuilder("Posted by : ${user.name}")
                binding.tvUser.setOnClickListener {
                    val intent = Intent(this, UserDetailActivity::class.java)
                    intent.putExtra(UserDetailActivity.EXTRA_USER, user)
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                }
            })
        }
    }

}