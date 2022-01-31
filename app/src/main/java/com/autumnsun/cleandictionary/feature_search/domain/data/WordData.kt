package com.autumnsun.cleandictionary.feature_search.domain.data

import com.autumnsun.cleandictionary.core.data.remote.turkish.AnlamlarListe
import com.autumnsun.cleandictionary.feature_home.domain.model.Meaning

data class WordData(
/*    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String*/
    val madde: String?,
    val birlesikler: String?,
    val anlamlarListe: List<AnlamlarListe>?,
)
