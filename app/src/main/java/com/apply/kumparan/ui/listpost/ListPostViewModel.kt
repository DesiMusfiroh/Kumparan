package com.apply.kumparan.ui.listpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.data.response.PostResponse

class ListPostViewModel(private val repository: DataRepository) : ViewModel()  {
    fun getListPost(): LiveData<ArrayList<PostResponse>> = repository.getListPost()
}