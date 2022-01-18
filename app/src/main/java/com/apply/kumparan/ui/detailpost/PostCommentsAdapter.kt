package com.apply.kumparan.ui.detailpost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apply.kumparan.data.response.CommentResponse
import com.apply.kumparan.databinding.ItemCommentBinding

class PostCommentsAdapter(private val list: ArrayList<CommentResponse>) : RecyclerView.Adapter<PostCommentsAdapter.PostCommentsViewHolder>() {
    fun setList(comments: ArrayList<CommentResponse>) {
        list.clear()
        list.addAll(comments)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostCommentsViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostCommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostCommentsViewHolder, position: Int) {
        val comments = list[position]
        holder.bind(comments)
    }

    override fun getItemCount(): Int = list.size

    class PostCommentsViewHolder(private val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CommentResponse) {
            with(binding) {
                tvName.text = data.name
                tvBody.text = data.body
            }
        }
    }
}