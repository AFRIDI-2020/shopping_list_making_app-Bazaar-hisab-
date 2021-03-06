package com.example.bazarhisab.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AllList::class, Item::class], version = 1)
abstract class BazaarHisabDatabase : RoomDatabase(){
    abstract fun allUserDao() : AllListDao
    abstract fun itemDao() : ItemDao

    companion object{

        @Volatile private var instance : BazaarHisabDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BazaarHisabDatabase::class.java,
            "bazaarHisabDatabase"
        ).build()
    }
}