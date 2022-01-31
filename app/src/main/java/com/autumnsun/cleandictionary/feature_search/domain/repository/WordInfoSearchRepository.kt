package com.autumnsun.cleandictionary.feature_search.domain.repository

import com.autumnsun.cleandictionary.core.util.Resource
import com.autumnsun.cleandictionary.feature_search.domain.data.WordData
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordData>>>
}