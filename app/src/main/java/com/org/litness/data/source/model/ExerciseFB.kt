package com.org.litness.data.source.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ExerciseFB(
    val id: String = "",
    val title: String = "",
    val imgUrl: String = "",
    val steps: String = "",
    val focusAreas: Map<String, FocusAreaFB> = mapOf()
)
