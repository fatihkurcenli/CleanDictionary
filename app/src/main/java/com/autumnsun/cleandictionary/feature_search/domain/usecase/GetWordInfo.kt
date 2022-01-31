package com.autumnsun.cleandictionary.feature_search.domain.usecase

import com.autumnsun.cleandictionary.core.util.Resource
import com.autumnsun.cleandictionary.feature_home.domain.repository.WordInfoRepository
import com.autumnsun.cleandictionary.feature_search.domain.data.WordData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordData>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}