package com.clp3z.mondlytest.domain

import com.clp3z.mondlytest.data.ItemRepository
import com.clp3z.mondlytest.entity.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemUseCase @Inject constructor(private val itemsRepository: ItemRepository) {

    operator fun invoke(id: Int): Flow<Item> = itemsRepository.getItemById(id)
}
