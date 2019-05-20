package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Work (
	@SerializedName("company") val company : String,
	@SerializedName("position") val position : String,
	@SerializedName("website") val website : String,
	@SerializedName("startDate") val startDate : String,
	@SerializedName("endDate") val endDate : String,
	@SerializedName("summary") val summary : String,
	@SerializedName("highlights") val highlights : List<String>
): Parcelable