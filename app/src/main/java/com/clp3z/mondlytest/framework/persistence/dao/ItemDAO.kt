package com.clp3z.mondlytest.framework.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clp3z.mondlytest.framework.persistence.model.LocalItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDAO {
    @Query("SELECT * FROM LocalItem")
    fun getAllItems(): Flow<List<LocalItem>>

    @Query("SELECT * FROM LocalItem WHERE id = :id")
    fun getItem(id: Int): Flow<LocalItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<LocalItem>)

    @Query("SELECT COUNT(id) FROM LocalItem")
    suspend fun itemsCount(): Int
}
