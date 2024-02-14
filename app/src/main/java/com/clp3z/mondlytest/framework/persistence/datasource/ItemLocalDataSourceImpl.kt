package com.clp3z.mondlytest.framework.persistence.datasource

import com.clp3z.mondlytest.data.ItemLocalDataSource
import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.framework.common.tryCall
import com.clp3z.mondlytest.framework.persistence.dao.ItemDAO
import com.clp3z.mondlytest.framework.persistence.model.LocalItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ItemLocalDataSourceImpl @Inject constructor(
    private val dao: ItemDAO
) : ItemLocalDataSource {

    override fun getAllItems(): Flow<List<Item>> = dao.getAllItems().map { it.toItems() }

    override fun getItem(id: Int): Flow<Item> = dao.getItem(id).map { it.toItem() }

    override suspend fun addItems(items: List<Item>): Error? = tryCall {
        dao.insertItems(items.map { it.toLocalItem() })
    }.fold(
        ifLeft = { it },
        ifRight = { null }
    )

    override suspend fun isEmpty(): Boolean = dao.itemsCount() == 0
}

private fun List<LocalItem>.toItems() = map { it.toItem() }

private fun LocalItem.toItem() = Item(id, name, description, image)

private fun Item.toLocalItem() = LocalItem(id, name, description, image)
