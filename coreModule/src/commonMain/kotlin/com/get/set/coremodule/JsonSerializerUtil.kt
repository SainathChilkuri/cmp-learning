package com.get.set.coremodule

import kotlinx.serialization.json.Json
import kotlin.io.encoding.Base64

object JsonSerializerUtil {
    inline fun <reified T> parseToJson(t: T) : String {
        val encodedValue = Json.encodeToString(t);
        return Base64.UrlSafe.encode(encodedValue.encodeToByteArray())
    }

    inline fun <reified T> parseFromJson(value: String) : T {
        val decodedValue = Base64.UrlSafe.decode(value).decodeToString();
        return Json.decodeFromString<T>(decodedValue);
    }
}