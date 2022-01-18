package com.apply.kumparan.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apply.kumparan.data.api.ApiConfig
import com.apply.kumparan.data.response.PostResponse
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

//    fun getListPost(): LiveData<List<PostResponse>> {
//        val results = MutableLiveData<List<PostResponse>>()
//        ApiConfig.getApiService().getListPost().enqueue(object: Callback<ListPostResponse> {
//            override fun onResponse(call: Call<ListPostResponse>, response: Response<ListPostResponse>) {
//                if (response.isSuccessful) {
//                    results.postValue(response.body()?.posts)
//                } else {
//                    Log.e(TAG, "onFailure Response: ${response.message()}")
//                }
//            }
//            override fun onFailure(call: Call<ListPostResponse>, t: Throwable) {
//                Log.e(TAG, "onFailure: ${t.message.toString()}")
//            }
//        })
//        return results
//    }
}