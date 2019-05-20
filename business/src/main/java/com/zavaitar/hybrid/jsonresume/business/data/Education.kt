package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Education (
	@SerializedName("institution") val institution : String,
	@SerializedName("area") val area : String,
	@SerializedName("studyType") val studyType : String,
	@SerializedName("startDate") val startDate : String,
	@SerializedName("endDate") val endDate : String,
	@SerializedName("gpa") val gpa : String,
	@SerializedName("courses") val courses : List<String>
): Parcelable