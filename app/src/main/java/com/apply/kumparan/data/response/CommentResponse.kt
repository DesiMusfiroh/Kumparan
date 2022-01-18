package com.apply.kumparan.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommentResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("postId")
	val postId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("email")
	val email: String? = null
) : Parcelable
