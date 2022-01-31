package com.autumnsun.cleandictionary.feature_home.domain.model

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
){

}
