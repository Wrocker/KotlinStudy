package com.rocker.kotlinstudy.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseLoadActivity
import com.rocker.kotlinstudy.databinding.ActivityBasicBinding

/**
 * 基本语法
 */
class BasicActivity : BaseLoadActivity<ActivityBasicBinding>() {
    override fun initLoadLayout(): Int {
        return R.layout.activity_basic
    }

    override fun initLoadBinding(inflate: View): ActivityBasicBinding {
        return ActivityBasicBinding.bind(inflate)
    }

    override fun initLoad() {
        loadBinding.rvContent.layoutManager = LinearLayoutManager(this)

    }
}