package com.apply.kumparan.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apply.kumparan.data.api.ApiConfig
import com.apply.kumparan.data.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        fun getInstance(): RemoteDataSource {
            return RemoteDataSource()
        }
        private const val TAG = "REMOTE DATA SOURCE"
    }

    fun getListPost(): LiveData<ArrayList<PostResponse>>  {
        val results = MutableLiveData<ArrayList<PostResponse>>()
        ApiConfig.getApiService().getListPost().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }
            override fun onResponse(call: Call<ArrayList<PostResponse>>, response: Response<ArrayList<PostResponse>>) {
                if (response.isSuccessful) {
                    results.postValue(response.body())
                    Log.d(TAG, response.body().toString())
                }
            }
        })
        return results
    }

    fun getPostComments(postId: Int): LiveData<ArrayList<CommentResponse>>  {
        val results = MutableLiveData<ArrayList<CommentResponse>>()
        ApiConfig.getApiService().getPostComments(postId).enqueue(object : Callback<ArrayList<CommentResponse>> {
            override fun onFailure(call: Call<ArrayList<CommentResponse>>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }
            override fun onResponse(call: Call<ArrayList<CommentResponse>>, response: Response<ArrayList<CommentResponse>>) {
                if (response.isSuccessful) {
                    results.postValue(response.body())
                    Log.d(TAG, response.body().toString())
                }
            }
        })
        return results
    }

    fun getDetailUser(userId: Int): LiveData<UserResponse> {
        val user = MutableLiveData<UserResponse>()
        ApiConfig.getApiService().getDetailUser(userId).enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    user.postValue(response.body())
                }
            }
        })
        return user
    }

    fun getUserAlbums(userId: Int): LiveData<ArrayList<AlbumResponse>>  {
        val results = MutableLiveData<ArrayList<AlbumResponse>>()
        ApiConfig.getApiService().getUserAlbums(userId).enqueue(object : Callback<ArrayList<AlbumResponse>> {
            override fun onFailure(call: Call<ArrayList<AlbumResponse>>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }
            override fun onResponse(call: Call<ArrayList<AlbumResponse>>, response: Response<ArrayList<AlbumResponse>>) {
                if (response.isSuccessful) {
                    results.postValue(response.body())
                    Log.d(TAG, response.body().toString())
                }
            }
        })
        return results
    }

    fun getAlbumPhotos(albumId: Int): LiveData<ArrayList<PhotoResponse>>  {
        val results = MutableLiveData<ArrayList<PhotoResponse>>()
        ApiConfig.getApiService().getAlbumPhotos(albumId).enqueue(object : Callback<ArrayList<PhotoResponse>> {
            override fun onFailure(call: Call<ArrayList<PhotoResponse>>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }
            override fun onResponse(call: Call<ArrayList<PhotoResponse>>, response: Response<ArrayList<PhotoResponse>>) {
                if (response.isSuccessful) {
                    results.postValue(response.body())
                    Log.d(TAG, response.body().toString())
                }
            }
        })
        return results
    }

    fun getDetailPhoto(photoId: Int): LiveData<PhotoResponse> {
        val photo = MutableLiveData<PhotoResponse>()
        ApiConfig.getApiService().getDetailPhoto(photoId).enqueue(object : Callback<PhotoResponse>{
            override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }
            override fun onResponse(call: Call<PhotoResponse>, response: Response<PhotoResponse>) {
                if (response.isSuccessful) {
                    photo.postValue(response.body())
                }
            }
        })
        return photo
    }

    fun getUsers(): LiveData<ArrayList<UserResponse>>  {
        val results = MutableLiveData<ArrayList<UserResponse>>()
        ApiConfig.getApiService().getUsers().enqueue(object : Callback<ArrayList<UserResponse>> {
            override fun onFailure(call: Call<ArrayList<UserResponse>>, t: Throwable) {
                t.message?.let { Log.d(TAG, it) }
            }
            override fun onResponse(call: Call<ArrayList<UserResponse>>, response: Response<ArrayList<UserResponse>>) {
                if (response.isSuccessful) {
                    results.postValue(response.body())
                    Log.d(TAG, response.body().toString())
                }
            }
        })
        return results
    }
}