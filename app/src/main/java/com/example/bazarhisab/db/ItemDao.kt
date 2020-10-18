package com.example.bazarhisab.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    suspend fun addDesiredItem(item: Item)

    @Query ("SELECT * FROM item ORDER BY id DESC")
    suspend fun getDesiredItem(): List<Item>
}