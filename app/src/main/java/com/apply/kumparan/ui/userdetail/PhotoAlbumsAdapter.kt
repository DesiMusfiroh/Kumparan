package com.apply.kumparan.ui.userdetail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apply.kumparan.R
import com.apply.kumparan.data.response.PhotoResponse
import com.apply.kumparan.databinding.ItemPhotoBinding
import com.apply.kumparan.ui.photodetail.PhotoDetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

class PhotoAlbumsAdapter(private val list: ArrayList<PhotoResponse>) : RecyclerView.Adapter<PhotoAlbumsAdapter.PhotoAlbumsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAlbumsViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoAlbumsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoAlbumsViewHolder, position: Int) {
        val posts = list[position]
        holder.bind(posts)
    }

    override fun getItemCount(): Int = list.size

    class PhotoAlbumsViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PhotoResponse) {
            with(binding) {
                tvId.text = data.id.toString()
                Glide.with(itemView)
                    .load(data.thumbnailUrl)
                    .transition(DrawableTransitionOptions.withCrossFade()).centerCrop()
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgPhoto)
            }
            itemView.setOnClickListener {
                val intent =  Intent(itemView.context, PhotoDetailActivity::class.java)
                intent.putExtra(PhotoDetailActivity.EXTRA_PHOTO, data.id)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                itemView.context.startActivity(intent)
            }
        }
    }
}