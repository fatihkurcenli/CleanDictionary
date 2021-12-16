package com.autumnsun.cleandictionary.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.autumnsun.cleandictionary.feature_dictionary.data.local.entity.WordInfoEntity

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {
    abstract val dao: WordInfoDao

    companion object {
        const val DB_NAME = "word_dictionary"
    }
}