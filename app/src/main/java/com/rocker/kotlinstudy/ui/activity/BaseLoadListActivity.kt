package com.rocker.kotlinstudy.ui.activity

import android.view.View
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseLoadActivity
import com.rocker.kotlinstudy.databinding.LayoutListBinding

/**
 * 基类标题
 */
abstract class BaseLoadListActivity : BaseLoadActivity<LayoutListBinding>() {
    override fun initLoadLayout(): Int {
        return R.layout.layout_list
    }

    override fun initLoadBinding(inflate: View): LayoutListBinding {
        return LayoutListBinding.bind(inflate)
    }

    override fun initView() {
        super.initView()
        rootBinding.tvTitle.text = getString(initTitle())
    }

    /**
     * 初始化标题
     */
    abstract fun initTitle() : Int
}