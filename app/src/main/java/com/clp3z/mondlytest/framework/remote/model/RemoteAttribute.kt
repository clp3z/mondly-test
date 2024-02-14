package com.clp3z.mondlytest.framework.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteAttribute(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageInfo") val imageInfo: RemoteImageInfo
)
