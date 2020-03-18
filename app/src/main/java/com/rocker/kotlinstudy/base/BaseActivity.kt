package com.rocker.kotlinstudy.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    lateinit var rootBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootBinding = initLayout()
        setContentView(rootBinding.root)
        initView()
    }

    /**
     * 初始化布局
     */
    abstract fun initLayout(): T

    /**
     * 初始化布局
     */
    abstract fun initView()

}