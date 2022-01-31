package com.autumnsun.cleandictionary.core.data.remote.dto


import com.autumnsun.cleandictionary.feature_home.domain.model.Definition
import com.google.gson.annotations.SerializedName

data class DefinitionDto(
    @SerializedName("antonyms")
    val antonyms: List<String> = listOf(),
    @SerializedName("definition")
    val definition: String = "",
    @SerializedName("example")
    val example: String = "",
    @SerializedName("synonyms")
    val synonyms: List<String> = listOf()
) {
    fun toDefinition(): Definition {
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}