package com.rocker.kotlinstudy.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseLoadActivity
import com.rocker.kotlinstudy.databinding.ActivityBasicBinding
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import com.rocker.kotlinstudy.util.ToastUtil

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
        val adapter = ContentLayoutAdapter(this)
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("kotlin 导包同java"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_import))
        data.add(ContentLayoutAdapter.LayType("java中的程序入口"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_main))
        adapter.data = data
        loadBinding.rvContent.adapter = adapter
    }

    fun main() {
        ToastUtil.showToast("this is main")
    }
}