package com.clp3z.mondlytest.framework.remote.datasource

import com.clp3z.mondlytest.data.RemoteDataSource
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.framework.remote.api.RemoteService
import com.clp3z.mondlytest.framework.remote.model.RemoteItem

class ItemRemoteDatasource(private val remoteService: RemoteService) : RemoteDataSource {

    override suspend fun getItems(): List<Item> =
        remoteService
            .getItems()
            .dataCollection
            .map { it.toItem() }
}

private fun RemoteItem.toItem() = Item(
    id = id,
    name = attributes.name,
    description = attributes.description,
    image = attributes.imageInfo.imageUrl
)
