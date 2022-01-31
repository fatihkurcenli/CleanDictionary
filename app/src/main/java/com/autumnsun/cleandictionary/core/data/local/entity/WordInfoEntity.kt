package com.autumnsun.cleandictionary.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.autumnsun.cleandictionary.feature_home.domain.model.Meaning
import com.autumnsun.cleandictionary.feature_home.domain.model.WordInfo


/*
 Created by Fatih Kurcenli on 12/16/2021
*/

@Entity
data class WordInfoEntity(
    @PrimaryKey
    val id: Int? = null,
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic
        )
    }
}
