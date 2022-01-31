package com.autumnsun.cleandictionary.core.data.repository

import com.autumnsun.cleandictionary.core.data.local.WordInfoDao
import com.autumnsun.cleandictionary.core.data.remote.DictionaryApi
import com.autumnsun.cleandictionary.core.util.Resource
import com.autumnsun.cleandictionary.feature_home.domain.repository.WordInfoRepository
import com.autumnsun.cleandictionary.feature_search.domain.data.WordData
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

    override fun getWordInfo(word: String): Flow<Resource<List<WordData>>> = flow {
        emit(Resource.Loading())
        val wordData = dao.getWordInfo(word).map { it.toWordData() }
        emit(Resource.Loading(data = wordData))
        try {
            val remoteWordInfo = api.getWordInfo(word)
            val deletedList = remoteWordInfo.map { it.madde }
            dao.deleteWordEntity(deletedList as List<String>)
            dao.insertWordEntity(remoteWordInfo.map { it.toWordEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Error, network call!!", data = wordData))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection!!",
                    data = wordData
                )
            )
        }
        val newWordInfo = dao.getWordInfo(word).map { it.toWordData() }
        emit(Resource.Success(newWordInfo))

        /*val wordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
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
        emit(Resource.Success(newWordInfo))*/
    }
}