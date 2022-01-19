package com.apply.kumparan.ui.userdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apply.kumparan.data.response.PhotoResponse
import com.apply.kumparan.databinding.ItemPhotoBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class PhotoAlbumsAdapter(private val list: ArrayList<PhotoResponse>) : RecyclerView.Adapter<PhotoAlbumsAdapter.PhotoAlbumsViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: PhotoResponse)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(users: ArrayList<PhotoResponse>) {
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAlbumsViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoAlbumsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoAlbumsViewHolder, position: Int) {
        val posts = list[position]
        holder.bind(posts)
        holder.itemView.setOnClickListener {
            @Suppress("DEPRECATION")
            onItemClickCallback.onItemClicked(list[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = list.size

    class PhotoAlbumsViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PhotoResponse) {
            with(binding) {
                Glide.with(itemView)
                    .load(data.url)
                    .transition(DrawableTransitionOptions.withCrossFade()).centerCrop()
                    .into(imgPhoto)
            }
        }
    }
}