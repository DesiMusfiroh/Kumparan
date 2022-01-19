package com.apply.kumparan.ui.userdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apply.kumparan.data.response.AlbumResponse
import com.apply.kumparan.databinding.ItemAlbumBinding

class UserAlbumsAdapter(private val list: ArrayList<AlbumResponse>) : RecyclerView.Adapter<UserAlbumsAdapter.UserAlbumsViewHolder>() {


    fun setList(albums: ArrayList<AlbumResponse>) {
        list.clear()
        list.addAll(albums)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAlbumsViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserAlbumsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: UserAlbumsViewHolder, position: Int) {
        val posts = list[position]
        holder.bind(posts)
    }

    override fun getItemCount(): Int = list.size

    inner class UserAlbumsViewHolder(private val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AlbumResponse) {
            with(binding) {
                tvTitle.text = data.title
                rvPhotos.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = data.photos?.let { PhotoAlbumsAdapter(it) }
                    adapter?.notifyDataSetChanged()
                    recycledViewPool
                }
            }
        }
    }
}