package com.apply.kumparan.data.api

import com.apply.kumparan.data.response.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getListPost():  Call<ArrayList<PostResponse>>
}