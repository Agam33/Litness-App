package com.org.litness.data.source.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class UserFB(
    val id: String = "",
    val email: String = "",
    val age: Int = 0,
    val weight: Double = 0.0,
    val height: Double = 0.0,
    val gender: String = ""
)
