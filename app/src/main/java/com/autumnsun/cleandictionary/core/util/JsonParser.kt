package com.autumnsun.cleandictionary.core.util

import java.lang.reflect.Type

/*
 Created by Fatih Kurcenli on 12/16/2021
*/

interface JsonParser {
    fun <T> fromJson(json: String, type: Type): T?
    fun <T> toJson(obj: T, type: Type): String?
}