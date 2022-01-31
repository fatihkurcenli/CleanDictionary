package com.autumnsun.cleandictionary.core.data.repository

import com.autumnsun.cleandictionary.core.util.Resource
import com.autumnsun.cleandictionary.core.data.local.WordInfoDao
import com.autumnsun.cleandictionary.core.data.remote.DictionaryApi
import com.autumnsun.cleandictionary.feature_home.domain.model.WordInfo
import com.autumnsun.cleandictionary.feature_home.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfo))
        try {
            val remoteWordInfo = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfo.map { it.word })
            dao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })

        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error, network call!!", data = wordInfo))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection!!",
                    data = wordInfo
                )
            )
        }
        val newWordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}