package com.autumnsun.cleandictionary.feature_home.presentation

import com.autumnsun.cleandictionary.feature_home.domain.model.WordInfo

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
