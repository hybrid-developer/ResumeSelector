package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location (
	@SerializedName("address") val address : String,
	@SerializedName("postalCode") val postalCode : String,
	@SerializedName("city") val city : String,
	@SerializedName("countryCode") val countryCode : String,
	@SerializedName("region") val region : String
): Parcelable