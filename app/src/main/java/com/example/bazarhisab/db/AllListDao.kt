package com.example.bazarhisab.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AllListDao {

    @Insert
    suspend fun addList(allList: AllList)

    @Query ("SELECT * FROM AllList ORDER BY id DESC")
    suspend fun getAllList() : List<AllList>
}