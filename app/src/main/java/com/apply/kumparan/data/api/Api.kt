package com.apply.kumparan.data.api

import com.apply.kumparan.data.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("posts")
    fun getListPost():  Call<ArrayList<PostResponse>>

    @GET("posts/{id}/comments")
    fun getPostComments(
        @Path("id") id: Int
    ) : Call<ArrayList<CommentResponse>>

    @GET("users/{id}")
    fun getDetailUser(
        @Path("id") id: Int
    ) : Call<UserResponse>

    @GET("users/{id}/albums")
    fun getUserAlbums(
        @Path("id") id: Int
    ) : Call<ArrayList<AlbumResponse>>

    @GET("albums/{id}/photos")
    fun getAlbumPhotos(
        @Path("id") id: Int
    ) : Call<ArrayList<PhotoResponse>>

    @GET("photos/{id}")
    fun getDetailPhoto(
        @Path("id") id: Int
    ) : Call<PhotoResponse>

    @GET("users")
    fun getUsers(): Call<ArrayList<UserResponse>>
}