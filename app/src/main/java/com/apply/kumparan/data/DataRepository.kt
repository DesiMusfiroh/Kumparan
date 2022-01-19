package com.apply.kumparan.data

import androidx.lifecycle.LiveData
import com.apply.kumparan.data.response.*

class DataRepository private constructor (private val remoteDataSource: RemoteDataSource) {
    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(remoteData: RemoteDataSource): DataRepository =
            instance ?: synchronized(this) {
                instance ?: DataRepository(remoteData).apply {
                    instance = this
                }
            }
    }

    fun getListPost(): LiveData<ArrayList<PostResponse>> = remoteDataSource.getListPost()
    fun getPostComments(postId: Int): LiveData<ArrayList<CommentResponse>> = remoteDataSource.getPostComments(postId)
    fun getDetailUser(userId: Int): LiveData<UserResponse> = remoteDataSource.getDetailUser(userId)
    fun getUserAlbums(userId: Int): LiveData<ArrayList<AlbumResponse>> = remoteDataSource.getUserAlbums(userId)
    fun getAlbumPhotos(albumId: Int): LiveData<ArrayList<PhotoResponse>> = remoteDataSource.getAlbumPhotos(albumId)
    fun getDetailPhoto(photoId: Int): LiveData<PhotoResponse> = remoteDataSource.getDetailPhoto(photoId)
    fun getUsers(): LiveData<ArrayList<UserResponse>> = remoteDataSource.getUsers()
    fun getPhotos(): LiveData<ArrayList<PhotoResponse>> = remoteDataSource.getPhotos()
}