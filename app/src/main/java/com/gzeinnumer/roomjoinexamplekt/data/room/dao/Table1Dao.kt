package com.gzeinnumer.roomjoinexamplekt.data.room.dao

import androidx.room.*
import com.gzeinnumer.roomjoinexamplekt.data.room.join.Table1_Table2
import com.gzeinnumer.roomjoinexamplekt.data.room.table.Table1

@Dao
interface Table1Dao {
    @get:Query("SELECT * FROM table_1")
    val all: List<Table1>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(table1s: List<Table1>)

    @Delete
    fun delete(table1: Table1)

    @get:Query("SELECT table_1.id, table_1.name, table_2.id as id2, table_2.name as name2, table_2.table_1_id FROM table_1 LEFT JOIN table_2 ON table_2.table_1_id = table_1.id;")
    val getJOin: List<Table1_Table2>
}