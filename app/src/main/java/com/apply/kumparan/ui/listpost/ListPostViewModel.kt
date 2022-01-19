package com.apply.kumparan.ui.listpost

import androidx.lifecycle.*
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.data.response.PostResponse
import com.apply.kumparan.data.response.UserResponse

class ListPostViewModel(private val repository: DataRepository) : ViewModel()  {
    fun getListPost(): LiveData<ArrayList<PostResponse>> = repository.getListPost()
    fun getUsers(): LiveData<ArrayList<UserResponse>> = repository.getUsers()
}