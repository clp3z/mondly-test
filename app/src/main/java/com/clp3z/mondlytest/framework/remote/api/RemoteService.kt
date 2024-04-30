package com.clp3z.mondlytest.framework.remote.api

import com.clp3z.mondlytest.framework.remote.model.RemoteResult
import retrofit2.http.GET

interface RemoteService {
    @GET("/mondly_android_code_task_json")
    suspend fun getItems(): RemoteResult
}
