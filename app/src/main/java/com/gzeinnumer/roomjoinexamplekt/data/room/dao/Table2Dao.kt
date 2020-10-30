package com.gzeinnumer.roomjoinexamplekt.data.room.dao

import androidx.room.*
import com.gzeinnumer.roomjoinexamplekt.data.room.table.Table2

@Dao
interface Table2Dao {
    @get:Query("SELECT * FROM table_2")
    val all: List<Table2>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(table2s: List<Table2>)

    @Delete
    fun delete(table2: Table2)
}