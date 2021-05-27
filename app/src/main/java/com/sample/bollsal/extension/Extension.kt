package com.sample.bollsal.extension

import android.content.res.Resources
import android.util.TypedValue

fun Int.convertDpToPx(): Int {
  return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()
}

fun Float.convertDpToPx(): Int {
  return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics).toInt()
}
