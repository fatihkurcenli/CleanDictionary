package com.autumnsun.cleandictionary.feature_dictionary.data.remote.dto


import com.autumnsun.cleandictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.autumnsun.cleandictionary.feature_dictionary.domain.model.WordInfo
import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    @SerializedName("meanings")
    val meanings: List<MeaningDto> = listOf(),
    @SerializedName("origin")
    val origin: String = "",
    @SerializedName("phonetic")
    val phonetic: String = "",
    @SerializedName("phonetics")
    val phonetics: List<PhoneticDto> = listOf(),
    @SerializedName("word")
    val word: String = ""
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}