package com.clp3z.mondlytest.domain

import com.clp3z.mondlytest.data.ItemRepository
import javax.inject.Inject

class GetItemUseCase @Inject constructor(private val itemsRepository: ItemRepository) {

    fun invoke(id: Int) = itemsRepository.getItemById(id)
}