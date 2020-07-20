package com.rocker.kotlinstudy.ui.activity.function

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

class LambdasActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.lambdas
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  高阶函数与 lambda 表达式"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 函数都是头等的"))//理解为能像参数一样使用函数
        data.add(ContentLayoutAdapter.LayType("     可以存储在变量与数据结构中、作为参数传递给其他高阶函数以及从其他高阶函数返回"))

        data.add(ContentLayoutAdapter.LayType("♦️  高阶函数"))
        data.add(ContentLayoutAdapter.LayType("    高阶函数是将函数用作参数或返回值的函数。"))
        data.add(ContentLayoutAdapter.LayType("♦️  接口中的属性"))
        data.add(ContentLayoutAdapter.LayType("     一个类或者对象可以实现一个或多个接口。"))
        data.add(ContentLayoutAdapter.LayType("♦️  接口继承"))
        data.add(ContentLayoutAdapter.LayType("♦️  解决覆盖冲突"))


        adapter.data = data
        adapter.notifyDataSetChanged()
    }


}