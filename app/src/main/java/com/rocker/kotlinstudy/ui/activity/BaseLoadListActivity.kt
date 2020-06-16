package com.rocker.kotlinstudy.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseLoadActivity
import com.rocker.kotlinstudy.databinding.LayoutListBinding
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 基类标题
 */
abstract class BaseLoadListActivity : BaseLoadActivity<LayoutListBinding>() {
    lateinit var adapter: ContentLayoutAdapter

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

    override fun initLoad() {
        loadBinding.rvContent.layoutManager = LinearLayoutManager(this)
        adapter = ContentLayoutAdapter(this)
        loadBinding.rvContent.adapter = adapter
        initContent()
    }

    /**
     * 初始化标题
     */
    abstract fun initTitle() : Int

    /**
     * 加载内容
     */
    abstract fun initContent()
}