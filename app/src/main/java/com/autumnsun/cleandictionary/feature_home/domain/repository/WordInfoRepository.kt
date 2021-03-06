package com.autumnsun.cleandictionary.feature_home.domain.repository

import com.autumnsun.cleandictionary.core.util.Resource
import com.autumnsun.cleandictionary.feature_search.domain.data.WordData
import kotlinx.coroutines.flow.Flow

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordData>>>
}