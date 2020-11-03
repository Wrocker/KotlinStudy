package com.rocker.kotlinstudy.util

import android.util.Log

class LogUtil {
    companion object {
        private const val TAG = "_______"
        fun e(message: String){
            Log.e(TAG, message)
        }
    }
}