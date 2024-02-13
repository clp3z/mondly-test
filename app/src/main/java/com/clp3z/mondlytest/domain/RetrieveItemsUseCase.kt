package com.clp3z.mondlytest.domain

import com.clp3z.mondlytest.data.ItemRepository
import com.clp3z.mondlytest.entity.Error
import javax.inject.Inject

class RetrieveItemsUseCase @Inject constructor(private val itemsRepository: ItemRepository) {

    suspend operator fun invoke(): Error? = itemsRepository.retrieveItems()
}