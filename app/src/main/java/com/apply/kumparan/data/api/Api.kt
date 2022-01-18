package com.apply.kumparan.data.api

import com.apply.kumparan.data.response.CommentResponse
import com.apply.kumparan.data.response.PostResponse
import com.apply.kumparan.data.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("posts")
    fun getListPost():  Call<ArrayList<PostResponse>>

    @GET("posts/{id}")
    fun getDetailPost(
        @Path("id") id: String
    ) : Call<PostResponse>

    @GET("users/{id}")
    fun getDetailUser(
        @Path("id") id: Int
    ) : Call<UserResponse>

    @GET("posts/{id}/comments")
    fun getPostComments(
        @Path("id") id: Int
    ) : Call<ArrayList<CommentResponse>>

    @GET("users")
    fun getUsers():  Call<ArrayList<UserResponse>>

    @GET("comments")
    fun getComments():  Call<ArrayList<CommentResponse>>
}