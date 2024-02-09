package com.clp3z.mondlytest.data

import com.clp3z.mondlytest.entity.Item

interface RemoteDataSource {

    suspend fun getItems(): List<Item>
}