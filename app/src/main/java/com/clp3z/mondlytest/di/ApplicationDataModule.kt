package com.clp3z.mondlytest.di

import com.clp3z.mondlytest.data.LocalDataSource
import com.clp3z.mondlytest.data.RemoteDataSource
import com.clp3z.mondlytest.framework.persistence.datasource.LocalDataSourceImpl
import com.clp3z.mondlytest.framework.remote.datasource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationDataModule {

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}