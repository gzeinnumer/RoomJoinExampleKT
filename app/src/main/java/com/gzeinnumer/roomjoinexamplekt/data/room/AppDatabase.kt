package com.gzeinnumer.roomjoinexamplekt.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gzeinnumer.roomjoinexamplekt.data.room.dao.Table1Dao
import com.gzeinnumer.roomjoinexamplekt.data.room.dao.Table2Dao
import com.gzeinnumer.roomjoinexamplekt.data.room.table.Table1
import com.gzeinnumer.roomjoinexamplekt.data.room.table.Table2

@Database(entities = [Table1::class, Table2::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun sampleTable1Dao(): Table1Dao
    abstract fun sampleTable2Dao(): Table2Dao

    companion object {

        private val TAG = "AppDatabase"
        private val dbName = "sample.db"

        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java,dbName)
                .setJournalMode(JournalMode.TRUNCATE)
                .allowMainThreadQueries()
                .build()
        }
    }
}