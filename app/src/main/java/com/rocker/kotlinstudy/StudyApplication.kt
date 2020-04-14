package com.rocker.kotlinstudy

import android.app.Application
import android.content.Context

class StudyApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}