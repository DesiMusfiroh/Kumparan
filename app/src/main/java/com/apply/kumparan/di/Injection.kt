package com.apply.kumparan.di

import android.content.Context
import com.apply.kumparan.data.DataRepository
import com.apply.kumparan.data.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return DataRepository.getInstance(remoteDataSource)
    }
}