package com.org.litness.util

import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showShortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showLongToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.setupActionBar(
    toolbar: androidx.appcompat.widget.Toolbar?,
    title: String = "",
    isDisplayHomeAsUpEnabled: Boolean = true,
) {
    setSupportActionBar(toolbar)
    if(title.isNotEmpty()) supportActionBar?.title = title
    supportActionBar?.setDisplayHomeAsUpEnabled(isDisplayHomeAsUpEnabled)
}

inline fun AppCompatActivity.appOnBackPressed(crossinline action: () -> Unit) {
    val callback = object: OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            action()
        }
    }
    onBackPressedDispatcher.addCallback(this, callback)
}