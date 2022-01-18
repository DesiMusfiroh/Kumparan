package com.apply.kumparan.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.data.response.UserResponse

class UserDetailViewModel(private val repository: DataRepository) : ViewModel()  {
    fun getDetailUser(userId: Int): LiveData<UserResponse> = repository.getDetailUser(userId)
}