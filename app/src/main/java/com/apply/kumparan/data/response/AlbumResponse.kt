package com.apply.kumparan.data.response

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumResponse(

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("title")
		val title: String? = null,

		@field:SerializedName("userId")
		val userId: Int? = null,

		val photos: ArrayList<PhotoResponse>? = null
) : Parcelable
