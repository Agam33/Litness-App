package com.org.litness.data.source.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FocusAreaFB(
    val id: String = "",
    val name: String = ""
)
