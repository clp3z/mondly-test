package com.clp3z.mondlytest.framework.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clp3z.mondlytest.framework.persistence.dao.ItemDAO
import com.clp3z.mondlytest.framework.persistence.model.LocalItem

@Database(
    entities = [LocalItem::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun itemDao(): ItemDAO
}