package com.clp3z.mondlytest.data

import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item
import kotlinx.coroutines.flow.Flow

interface ItemLocalDataSource {

    fun getAllItems(): Flow<List<Item>>

    fun getItem(id: Int): Flow<Item>

    suspend fun addItems(items: List<Item>): Error?

    suspend fun isEmpty(): Boolean
}
