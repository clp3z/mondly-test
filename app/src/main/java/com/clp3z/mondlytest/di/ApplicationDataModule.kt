package com.clp3z.mondlytest.di

import com.clp3z.mondlytest.data.ItemLocalDataSource
import com.clp3z.mondlytest.data.ItemRemoteDataSource
import com.clp3z.mondlytest.framework.persistence.datasource.ItemLocalDataSourceImpl
import com.clp3z.mondlytest.framework.remote.datasource.ItemRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationDataModule {

    @Binds
    abstract fun bindRemoteDataSource(itemRemoteDataSourceImpl: ItemRemoteDataSourceImpl): ItemRemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(itemLocalDataSourceImpl: ItemLocalDataSourceImpl): ItemLocalDataSource
}
