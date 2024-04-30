package com.clp3z.mondlytest.framework.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteItem(
    @SerializedName("id") val id: Int,
    @SerializedName("attributes") val attributes: RemoteAttribute,
)
