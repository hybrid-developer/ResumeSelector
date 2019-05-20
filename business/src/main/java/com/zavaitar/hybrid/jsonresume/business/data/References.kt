package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class References (
	@SerializedName("name") val name : String,
	@SerializedName("reference") val reference : String
): Parcelable