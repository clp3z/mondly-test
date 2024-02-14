package com.clp3z.mondlytest.data

import arrow.core.Either
import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item

interface ItemRemoteDataSource {

    suspend fun getItems(): Either<Error, List<Item>>
}