package com.clp3z.mondlytest.framework.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteResult(
    @SerializedName("dataCollection") val dataCollection: List<RemoteDataCollection>,
)
