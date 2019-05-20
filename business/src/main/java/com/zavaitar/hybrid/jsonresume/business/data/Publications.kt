package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Publications (
	@SerializedName("name") val name : String,
	@SerializedName("publisher") val publisher : String,
	@SerializedName("releaseDate") val releaseDate : String,
	@SerializedName("website") val website : String,
	@SerializedName("summary") val summary : String
): Parcelable
