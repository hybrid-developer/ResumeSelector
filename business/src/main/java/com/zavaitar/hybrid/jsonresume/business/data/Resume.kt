package com.zavaitar.hybrid.jsonresume.business.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Resume(
        @SerializedName("id") val id: Int,
        @SerializedName("basics") val basics: Basics,
        @SerializedName("work") val work: List<Work> = emptyList(),
        @SerializedName("education") val education: List<Education> = emptyList(),
        @SerializedName("publications") val publications: List<Publications> = emptyList(),
        @SerializedName("skills") val skills: List<Skills> = emptyList(),
        @SerializedName("references") val references: List<References> = emptyList()
) : Parcelable