package com.autumnsun.cleandictionary.core.data.remote

import com.autumnsun.cleandictionary.core.data.remote.turkish.WordDtoItem
import retrofit2.http.GET
import retrofit2.http.Query

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

interface DictionaryApi {
    /* @GET("/api/v2/entries/en/{word}")
     suspend fun getWordInfo(
         @Path("word") word: String
     ): List<WordInfoDto>*/

    @GET("gts")
    suspend fun getWordInfo(
        @Query("ara") word: String
    ): List<WordDtoItem>

    companion object {
        //const val BASE_URL="https://api.dictionaryapi.dev/"
        const val BASE_URL = "https://sozluk.gov.tr/"
    }

}