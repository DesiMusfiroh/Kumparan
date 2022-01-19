package com.apply.kumparan.ui.photodetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.data.response.PhotoResponse

class PhotoDetailViewModel(private val repository: DataRepository) : ViewModel()  {
    fun getDetailPhoto(photoId: Int): LiveData<PhotoResponse> = repository.getDetailPhoto(photoId)
}