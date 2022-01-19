package com.apply.kumparan.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.di.Injection
import com.apply.kumparan.ui.detailpost.DetailPostViewModel
import com.apply.kumparan.ui.userdetail.UserDetailViewModel
import com.apply.kumparan.ui.listpost.ListPostViewModel
import com.apply.kumparan.ui.photodetail.PhotoDetailViewModel

class ViewModelFactory private constructor(private val dataRepository: DataRepository)
    : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ListPostViewModel::class.java) -> {
                ListPostViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(DetailPostViewModel::class.java) -> {
                DetailPostViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(UserDetailViewModel::class.java) -> {
                UserDetailViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(PhotoDetailViewModel::class.java) -> {
                PhotoDetailViewModel(dataRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}