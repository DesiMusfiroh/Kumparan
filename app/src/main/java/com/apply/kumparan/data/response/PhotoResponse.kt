package com.apply.kumparan.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoResponse(

	@field:SerializedName("albumId")
	val albumId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String? = null
) : Parcelable
