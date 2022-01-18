package com.apply.kumparan.data.response

import com.google.gson.annotations.SerializedName

data class ListPostResponse(
    @SerializedName("post")
    val posts: MutableList<PostResponse>
)