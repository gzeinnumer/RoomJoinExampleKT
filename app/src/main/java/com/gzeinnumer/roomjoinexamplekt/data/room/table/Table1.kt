package com.gzeinnumer.roomjoinexamplekt.data.room.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_1")
open class Table1(
    @field:ColumnInfo(name = "id")
    @field:PrimaryKey(autoGenerate = true)
    var id: Int,

    @field:ColumnInfo(name = "name")
    var name: String
)