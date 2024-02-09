package com.clp3z.mondlytest.data

import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.framework.persistence.model.LocalItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllItems(): Flow<List<Item>>

    fun getItem(id: Int): Flow<Item>

    suspend fun addItems(items: List<LocalItem>)

    suspend fun isEmpty(): Boolean
}