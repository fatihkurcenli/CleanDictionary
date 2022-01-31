package com.autumnsun.cleandictionary.core.data.remote.turkish


import com.google.gson.annotations.SerializedName

data class OrneklerListe(
    @SerializedName("anlam_id")
    val anlamId: String?,
    @SerializedName("kac")
    val kac: String?,
    @SerializedName("ornek")
    val ornek: String?,
    @SerializedName("ornek_id")
    val ornekId: String?,
    @SerializedName("ornek_sira")
    val ornekSira: String?,
    @SerializedName("yazar_id")
    val yazarId: String?
) {
    fun toOrneklerListe(): OrneklerListe {
        return OrneklerListe(
            anlamId = anlamId,
            kac = kac,
            ornek = ornek,
            ornekId = ornekId,
            ornekSira = ornekSira,
            yazarId = yazarId
        )
    }
}