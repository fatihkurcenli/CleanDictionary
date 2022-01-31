package com.autumnsun.cleandictionary.feature_home.domain.model

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)