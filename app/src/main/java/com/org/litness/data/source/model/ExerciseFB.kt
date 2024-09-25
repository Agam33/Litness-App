package com.org.litness.data.source.model

import com.google.firebase.database.IgnoreExtraProperties

/**
    This class only for input data into Realtime Database
 */
@IgnoreExtraProperties
data class ExerciseFB(
    val id: String = "",
    val title: String = "",
    val imgUrl: String = "",
    val steps: String = "",
    val metScore: Double = 0.0,
    val focusAreas: Map<String, FocusAreaFB> = mapOf()
)
