package com.clp3z.mondlytest.data

import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.framework.persistence.model.LocalItem
import kotlinx.coroutines.flow.Flow

class ItemRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    val items: Flow<List<Item>> = localDataSource.getAllItems()

    suspend fun retrieveItems() {
        if (localDataSource.isEmpty()) {
            val items = remoteDataSource.getItems().toLocalItems()
            localDataSource.addItems(items)
        }
    }

    suspend fun getItemById(id: Int): Flow<Item> = localDataSource.getItem(id)
}

private fun List<Item>.toLocalItems() = map { it.toLocalItem() }

private fun Item.toLocalItem() = LocalItem(
    id = id,
    name = name,
    description = description,
    image = image
)