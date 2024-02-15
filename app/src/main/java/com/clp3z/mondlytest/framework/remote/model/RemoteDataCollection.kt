package com.clp3z.mondlytest.framework.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteDataCollection(
    @SerializedName("item") val item: RemoteItem
)