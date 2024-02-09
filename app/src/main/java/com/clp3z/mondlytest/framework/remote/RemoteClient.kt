package com.clp3z.mondlytest.framework.remote

import com.clp3z.mondlytest.framework.remote.api.RemoteService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * In a real-life architecture the retrofit client would be created using dependency injection.
 */
object RemoteClient {

    private const val BASE_URL = "https://europe-west1-mondly-workflows.cloudfunctions.net/"

    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RemoteService = builder.create()
}