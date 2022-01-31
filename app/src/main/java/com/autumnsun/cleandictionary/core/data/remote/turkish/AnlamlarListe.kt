package com.autumnsun.cleandictionary.core.data.remote.turkish


import com.google.gson.annotations.SerializedName

data class AnlamlarListe(
    @SerializedName("anlam")
    val anlam: String?,
    @SerializedName("anlam_id")
    val anlamId: String?,
    @SerializedName("anlam_sira")
    val anlamSira: String?,
    @SerializedName("fiil")
    val fiil: String?,
    @SerializedName("gos")
    val gos: String?,
    @SerializedName("madde_id")
    val maddeId: String?,
    @SerializedName("orneklerListe")
    val orneklerListe: List<OrneklerListe>?,
    @SerializedName("tipkes")
    val tipkes: String?
) {
    fun toAnlamlarListe(): AnlamlarListe {
        return AnlamlarListe(
            orneklerListe = orneklerListe?.map { it.toOrneklerListe() },
            anlam = anlam,
            anlamId = anlamId,
            anlamSira = anlamSira,
            fiil = fiil,
            gos = gos,
            maddeId = maddeId,
            tipkes = tipkes
        )
    }
}