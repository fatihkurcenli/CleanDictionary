package com.autumnsun.cleandictionary.core.util

import com.google.gson.Gson
import java.lang.reflect.Type

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

class GsonParser(
    private val gson: Gson
) : JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj, type)
    }
}