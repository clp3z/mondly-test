package com.clp3z.mondlytest.data

import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.framework.common.tryCall
import com.clp3z.mondlytest.framework.persistence.model.LocalItem
import kotlinx.coroutines.flow.Flow

class ItemRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    val items: Flow<List<Item>> = localDataSource.getAllItems()

    suspend fun retrieveItems(): Error? = tryCall {
        if (localDataSource.isEmpty()) {
            remoteDataSource.getItems().fold(
                ifLeft = { return it },
                ifRight = { localDataSource.addItems(it.toLocalItems()) }
            )
        }
    }.fold(
        ifLeft = { it },
        ifRight = { null }
    )

    suspend fun getItemById(id: Int): Flow<Item> = localDataSource.getItem(id)
}

private fun List<Item>.toLocalItems() = map { it.toLocalItem() }

private fun Item.toLocalItem() = LocalItem(
    id = id,
    name = name,
    description = description,
    image = image
)