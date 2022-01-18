package com.apply.kumparan.ui.listpost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apply.kumparan.data.response.PostResponse
import com.apply.kumparan.databinding.ItemPostBinding

class ListPostAdapter(private val list: ArrayList<PostResponse>) : RecyclerView.Adapter<ListPostAdapter.ListPostViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: PostResponse)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(users: ArrayList<PostResponse>) {
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListPostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListPostViewHolder, position: Int) {
        val news = list[position]
        holder.bind(news)
        holder.itemView.setOnClickListener {
            @Suppress("DEPRECATION")
            onItemClickCallback.onItemClicked(list[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = list.size

    class ListPostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PostResponse) {
            with(binding) {
                tvTitle.text = data.title
                tvBody.text = data.body
                tvUser.text = data.userId.toString()
            }
        }
    }
}