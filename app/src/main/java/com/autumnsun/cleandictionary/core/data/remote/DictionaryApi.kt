package com.autumnsun.cleandictionary.core.data.remote

import com.autumnsun.cleandictionary.core.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

interface DictionaryApi {
    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>


    companion object{
        const val BASE_URL="https://api.dictionaryapi.dev/"
    }

}