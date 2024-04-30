package com.clp3z.mondlytest.di

import android.app.Application
import androidx.room.Room
import com.clp3z.mondlytest.framework.persistence.Database
import com.clp3z.mondlytest.framework.persistence.dao.ItemDAO
import com.clp3z.mondlytest.framework.remote.api.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): Database =
        Room.databaseBuilder(
            context = application,
            klass = Database::class.java,
            name = "items-database",
        ).build()

    @Provides
    @Singleton
    fun provideItemsDAO(database: Database): ItemDAO = database.itemDao()

    @Provides
    @Singleton
    fun provideHttpInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://europe-west1-mondly-workflows.cloudfunctions.net")
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideRemoteService(retrofit: Retrofit): RemoteService = retrofit.create(RemoteService::class.java)
}
