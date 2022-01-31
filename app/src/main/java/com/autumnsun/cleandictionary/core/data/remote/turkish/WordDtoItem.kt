package com.autumnsun.cleandictionary.core.data.remote.turkish


import com.autumnsun.cleandictionary.core.data.local.entity.WordEntity
import com.google.gson.annotations.SerializedName

data class WordDtoItem(
    @SerializedName("madde")
    val madde: String?,
    @SerializedName("birlesikler")
    val birlesikler: String?,
    @SerializedName("anlamlarListe")
    val anlamlarListe: List<AnlamlarListe>?,
) {
    fun toWordEntity(): WordEntity {
        return WordEntity(
            madde = madde,
            birlesikler = birlesikler,
            anlamlarListe = anlamlarListe?.map { it.toAnlamlarListe() }
        )
    }
}