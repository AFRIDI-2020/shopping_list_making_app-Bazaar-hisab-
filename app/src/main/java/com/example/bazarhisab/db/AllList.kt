package com.example.bazarhisab.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class AllList(
    @ColumnInfo(name = "list_name") val listName : String
) {
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}