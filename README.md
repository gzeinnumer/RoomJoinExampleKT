# RoomJoinExampleKT

References
- [Room Join](https://developer.android.com/training/data-storage/room/accessing-data.html#query-multiple-tables)
- [Embedded](https://stackoverflow.com/questions/45059942/return-type-for-android-room-joins) only if your table use difference entity.

Enable Room with this code [Room Java](https://github.com/gzeinnumer/AndroidJetpackRoom) & [Room Kotlin](https://github.com/gzeinnumer/AndroidJetpackRoomKT)

- Table1
```kotlin
@Entity(tableName = "table_1")
open class Table1(
    @field:ColumnInfo(name = "id")
    @field:PrimaryKey(autoGenerate = true)
    var id: Int,

    @field:ColumnInfo(name = "name")
    var name: String
)
```

- Table2
```kotlin
@Entity(tableName = "table_2")
class Table2(
    @field:ColumnInfo(name = "id")
    @field:PrimaryKey(autoGenerate = true)
    var id: Int,

    @field:ColumnInfo(name = "name")
    var name: String,

    @field:ColumnInfo(name = "table_1_id")
    var table_1_id: Int
)
```

- Table1 Join with Table2
```kotlin
@Dao
interface Table1Dao {

    @get:Query("SELECT table_1.id, " +
     "table_1.name, " +
      "table_2.id as id2, " +
       "table_2.name as name2, " +
        "table_2.table_1_id " +
         "FROM table_1 " +
          "LEFT JOIN table_2 ON table_2.table_1_id = table_1.id;")
    val getJOin: List<Table1_Table2>
}
```

- Joined Entity
```kotlin
class Table1_Table2(id: Int, name: String) : Table1(id, name) {
    var id2 = 0
    var name2: String? = null
    var table_1_id = 0
}
```

- Use on your activity
```kotlin
val appDatabase: AppDatabase = AppDatabase.getInstance(application)

val list: List<Table1_Table2> = appDatabase.sampleTable1Dao().getJOin

for (i in list.indices) {
    val name1: String = list[i].name
    val name2: String = list[i].name2!!
    Log.d(TAG, "list: " + i + "_" + name1 + "_" + name2)
}
```

- Example
```kotlin
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
```
[Example Project](https://github.com/gzeinnumer/RoomJoinExampleKT)

- Preview

|![](https://github.com/gzeinnumer/RoomJoinExampleKT/blob/master/preview/example1.JPG)|
|---|

---

```
Copyright 2020 M. Fadli Zein
```
