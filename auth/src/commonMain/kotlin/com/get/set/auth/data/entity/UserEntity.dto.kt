package com.get.set.auth.data.entity

import com.get.set.auth.domain.models.UserModel

class UserEntity(private val usernameValue: String? = null, private val emailValue: String?, private val displayNameValue: String?): UserModel(
    username = usernameValue?: "", email = emailValue?: "", displayName = displayNameValue?: ""
) {
}