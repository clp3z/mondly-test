package com.clp3z.mondlytest.framework.persistence.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalItem (
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val image: String
)