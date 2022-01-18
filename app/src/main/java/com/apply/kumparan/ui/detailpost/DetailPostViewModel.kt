package com.apply.kumparan.ui.detailpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.data.response.CommentResponse
import com.apply.kumparan.data.response.UserResponse

class DetailPostViewModel(private val repository: DataRepository) : ViewModel()  {
    fun getPostComments(postId: Int): LiveData<ArrayList<CommentResponse>> = repository.getPostComments(postId)
    fun getDetailUser(userId: Int): LiveData<UserResponse> = repository.getDetailUser(userId)
}