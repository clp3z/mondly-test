package com.clp3z.mondlytest.framework.remote.datasource

import arrow.core.Either
import com.clp3z.mondlytest.data.RemoteDataSource
import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.framework.common.tryCall
import com.clp3z.mondlytest.framework.remote.api.RemoteService
import com.clp3z.mondlytest.framework.remote.model.RemoteItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val remoteService: RemoteService
) : RemoteDataSource {

    override suspend fun getItems(): Either<Error, List<Item>> = tryCall {
        remoteService
            .getItems()
            .dataCollection
            .map { it.toItem() }
    }
}

private fun RemoteItem.toItem() = Item(
    id = id,
    name = attributes.name,
    description = attributes.description,
    image = attributes.imageInfo.imageUrl
)
