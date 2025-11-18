package com.get.set.coremodels.models

import kotlinx.serialization.Serializable

@Serializable
data class UserDataModel(val username: String?=null, val email: String?=null, val displayName: String?=null, val userId: String) {}