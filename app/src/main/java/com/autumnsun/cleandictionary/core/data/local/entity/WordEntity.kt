package com.autumnsun.cleandictionary.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.autumnsun.cleandictionary.core.data.remote.turkish.AnlamlarListe
import com.autumnsun.cleandictionary.feature_search.domain.data.WordData

@Entity
data class WordEntity(
    @PrimaryKey
    val id: Int? = null,
    val madde: String?,
    val birlesikler: String?,
    val anlamlarListe: List<AnlamlarListe>?,
) {
    fun toWordData(): WordData {
        return WordData(
            madde = madde,
            birlesikler = birlesikler,
            anlamlarListe = anlamlarListe
        )
    }
}