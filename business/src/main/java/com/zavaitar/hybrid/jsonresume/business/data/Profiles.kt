package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profiles (
	@SerializedName("network") val network : String,
	@SerializedName("username") val username : String,
	@SerializedName("url") val url : String
): Parcelable