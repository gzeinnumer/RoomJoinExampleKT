package com.gzeinnumer.roomjoinexamplekt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gzeinnumer.roomjoinexamplekt.data.room.AppDatabase
import com.gzeinnumer.roomjoinexamplekt.data.room.join.Table1_Table2
import com.gzeinnumer.roomjoinexamplekt.data.room.table.Table1
import com.gzeinnumer.roomjoinexamplekt.data.room.table.Table2
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataTable1: MutableList<Table1> = mutableListOf()
    val dataTable2: MutableList<Table2> = mutableListOf()

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appDatabase: AppDatabase = AppDatabase.getInstance(application)

        dataTable1.add(Table1(1, "M. Fadli 1"))
        dataTable1.add(Table1(2, "M. Fadli 2"))
        dataTable1.add(Table1(3, "M. Fadli 3"))
        dataTable1.add(Table1(4, "M. Fadli 4"))

        appDatabase.sampleTable1Dao().insertAll(dataTable1)

        dataTable2.add(Table2(1, "Zein 1", 1))
        dataTable2.add(Table2(2, "Zein 2", 2))
        dataTable2.add(Table2(3, "Zein 3", 3))
        dataTable2.add(Table2(4, "Zein 4", 4))

        appDatabase.sampleTable2Dao().insertAll(dataTable2)

        val list: List<Table1_Table2> = appDatabase.sampleTable1Dao().getJOin

        for (i in list.indices) {
            val name1: String = list[i].name
            val name2: String = list[i].name2!!
            Log.d(TAG, "list: " + i + "_" + name1 + "_" + name2)
        }
    }
}