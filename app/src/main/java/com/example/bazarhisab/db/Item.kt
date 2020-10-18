package com.example.bazarhisab.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Item(
    @ColumnInfo(name = "list_name") val listName : String,
    @ColumnInfo(name = "item_name") val itemName : String,
    @ColumnInfo(name = "quantity") val quantity: String,
    @ColumnInfo(name = "cost") val cost : String
) {
    @PrimaryKey(autoGenerate = true) var id : Int = 0

}