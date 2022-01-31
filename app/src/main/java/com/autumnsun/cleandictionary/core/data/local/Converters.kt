package com.autumnsun.cleandictionary.core.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.autumnsun.cleandictionary.core.data.remote.turkish.AnlamlarListe
import com.autumnsun.cleandictionary.core.util.JsonParser
import com.autumnsun.cleandictionary.feature_home.domain.model.Meaning
import com.google.gson.reflect.TypeToken

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromAnlamlarListeJson(json: String): List<AnlamlarListe> {
        return jsonParser.fromJson<ArrayList<AnlamlarListe>>(
            json,
            object : TypeToken<ArrayList<AnlamlarListe>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toAnlamlarListeJson(meanings: List<AnlamlarListe>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<AnlamlarListe>>() {}.type
        ) ?: "[]"
    }
}