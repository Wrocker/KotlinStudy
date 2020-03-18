package com.rocker.kotlinstudy.ui

import android.view.View
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.BaseLoadActivity
import com.rocker.kotlinstudy.databinding.ActivityMainBinding

class MainActivity : BaseLoadActivity<ActivityMainBinding>() {

    override fun initLoadLayout(): Int {
        return R.layout.activity_main
    }

    override fun initLoadBinding(inflate: View): ActivityMainBinding {
        return ActivityMainBinding.bind(inflate)
    }

    override fun initLoad() {
        loadBinding.tvTitle.text = "哈哈哈"
    }

}
