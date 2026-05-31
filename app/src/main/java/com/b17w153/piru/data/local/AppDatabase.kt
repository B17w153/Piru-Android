package com.b17w153.piru.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.b17w153.piru.data.local.dao.SubstanceDao
import com.b17w153.piru.data.local.entities.SubstanceEntity

@Database(
    entities = [SubstanceEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun substanceDao(): SubstanceDao
}