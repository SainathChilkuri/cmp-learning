package org.demo.cmp.project.presentation.navigations

import androidx.navigation.NavBackStackEntry
import com.get.set.coremodule.JsonSerializerUtil

inline fun <reified T> NavBackStackEntry.fetchData(fieldName: String) : T? {
    val encodedData: String? =  arguments?.getString(fieldName);
    encodedData?.let {
        val result: T = JsonSerializerUtil.parseFromJson<T>(encodedData);
        return result;
    }
    return null;
}