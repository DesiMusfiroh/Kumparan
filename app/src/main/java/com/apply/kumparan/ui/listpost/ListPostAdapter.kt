package com.apply.kumparan.ui.listpost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apply.kumparan.data.response.PostResponse
import com.apply.kumparan.data.response.UserResponse
import com.apply.kumparan.databinding.ItemPostBinding
import java.lang.StringBuilder

class ListPostAdapter(private val list: ArrayList<PostResponse>) : RecyclerView.Adapter<ListPostAdapter.ListPostViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var user: GetUser

    interface OnItemClickCallback {
        fun onItemClicked(data: PostResponse)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface GetUser {
        fun getUser(userId: Int): UserResponse?
    }

    fun setUser(getUser: GetUser) {
        this.user = getUser
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
        val posts = list[position]
        holder.bind(posts)
        holder.itemView.setOnClickListener {
            @Suppress("DEPRECATION")
            onItemClickCallback.onItemClicked(list[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ListPostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PostResponse) {
            with(binding) {
                tvTitle.text = data.title
                tvBody.text = data.body
                data.userId?.let {
                    tvUser.text = StringBuilder("Posted by : ${user.getUser(it)?.name} from ${user.getUser(it)?.company?.name}")
                }
            }
        }
    }
}