package com.autumnsun.cleandictionary.core.data.remote.dto


import com.autumnsun.cleandictionary.feature_home.domain.model.Meaning
import com.google.gson.annotations.SerializedName

data class MeaningDto(
    @SerializedName("definitions")
    val definitions: List<DefinitionDto> = listOf(),
    @SerializedName("partOfSpeech")
    val partOfSpeech: String = ""
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}