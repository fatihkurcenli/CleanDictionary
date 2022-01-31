package com.autumnsun.cleandictionary.feature_search.presentation

import com.autumnsun.cleandictionary.feature_search.domain.data.WordData

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

data class WordInfoState(
    val wordInfoItems: List<WordData> = emptyList(),
    val isLoading: Boolean = false
)
