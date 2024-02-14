package com.clp3z.mondlytest.data

import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val itemLocalDataSource: ItemLocalDataSource,
    private val itemRemoteDataSource: ItemRemoteDataSource
) {

    val items: Flow<List<Item>> = itemLocalDataSource.getAllItems()

    suspend fun retrieveItems(): Error? {
        if (itemLocalDataSource.isEmpty()) {
            itemRemoteDataSource.getItems().fold(
                ifLeft = { return it },
                ifRight = { itemLocalDataSource.addItems(it) }
            )
        }
        return null
    }

    fun getItemById(id: Int): Flow<Item> = itemLocalDataSource.getItem(id)
}
