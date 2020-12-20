package com.semyong.scalabletask.presentation.helpers

import android.content.Context
import android.widget.Toast

fun Context.showToastLong(errorMessage:String) =
    Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
