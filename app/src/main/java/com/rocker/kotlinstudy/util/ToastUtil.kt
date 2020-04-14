package com.rocker.kotlinstudy.util

import android.widget.Toast
import com.rocker.kotlinstudy.StudyApplication

class ToastUtil {
    companion object {
        private lateinit var toast: Toast

        fun showToast(message: String){
            toast = Toast.makeText(StudyApplication.context, message, Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}