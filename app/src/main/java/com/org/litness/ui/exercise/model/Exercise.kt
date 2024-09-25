package com.org.litness.ui.exercise.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise(
    val id: String = "",
    val title: String = "",
    val imgUrl: String = "",
    val focusArea: String = "",
    val metScore: Double = 0.0,
    val steps: String = ""
) : Parcelable
