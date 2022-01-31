package com.autumnsun.cleandictionary.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.autumnsun.cleandictionary.core.data.local.entity.WordEntity
import com.autumnsun.cleandictionary.core.data.local.entity.WordInfoEntity

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

@Dao
interface WordInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordEntity(info: List<WordEntity>)

    @Query("DELETE FROM wordentity WHERE madde IN(:words)")
    suspend fun deleteWordEntity(words: List<String>)

    @Query("SELECT * FROM wordentity WHERE madde LIKE '%' || :word || '%'")
    suspend fun getWordInfo(word: String): List<WordEntity>
}