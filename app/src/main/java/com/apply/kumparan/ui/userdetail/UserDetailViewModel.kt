package com.apply.kumparan.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.data.response.AlbumResponse
import com.apply.kumparan.data.response.PhotoResponse
import com.apply.kumparan.data.response.UserResponse

class UserDetailViewModel(private val repository: DataRepository) : ViewModel()  {
    fun getUserAlbums(userId: Int): LiveData<ArrayList<AlbumResponse>> = repository.getUserAlbums(userId)
    fun getPhotos(): LiveData<ArrayList<PhotoResponse>> = repository.getPhotos()
    fun getAlbumsPhotos(albumId: Int): LiveData<ArrayList<PhotoResponse>> = repository.getAlbumPhotos(albumId)
}