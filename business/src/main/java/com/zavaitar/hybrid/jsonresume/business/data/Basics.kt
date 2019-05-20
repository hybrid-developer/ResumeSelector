package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Basics (
		@SerializedName("name") val name : String,
		@SerializedName("label") val label : String,
		@SerializedName("picture") val picture : String,
		@SerializedName("email") val email : String,
		@SerializedName("phone") val phone : String,
		@SerializedName("website") val website : String,
		@SerializedName("summary") val summary : String,
		@SerializedName("location") val location : Location,
		@SerializedName("profiles") val profiles : List<Profiles>
): Parcelable