package com.autumnsun.cleandictionary.feature_dictionary.domain.model


/*
 Created by Fatih Kurcenli on 12/16/2021
*/

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
