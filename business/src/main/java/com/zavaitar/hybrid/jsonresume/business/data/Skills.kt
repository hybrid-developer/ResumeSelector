package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Skills (
	@SerializedName("name") val name : String,
	@SerializedName("level") val level : String,
	@SerializedName("keywords") val keywords : List<String>
): Parcelable