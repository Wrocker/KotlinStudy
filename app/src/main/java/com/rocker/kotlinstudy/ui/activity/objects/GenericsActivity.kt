package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 嵌套类和内部类
 */
class GenericsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.generics
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  使用关键字 interface 来定义接口"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 的接口可以既包含抽象方法的声明也包含实现。"))
        data.add(ContentLayoutAdapter.LayType("     与抽象类不同的是，接口无法保存状态。它可以有属性但必须声明为抽象或提供访问器实现。"))
        data.add(ContentLayoutAdapter.LayType("     若没有类体，可省略花括号"))
        data.add(ContentLayoutAdapter.LayType("♦️  实现接口"))
        data.add(ContentLayoutAdapter.LayType("     一个类或者对象可以实现一个或多个接口。"))
        data.add(ContentLayoutAdapter.LayType("♦️  接口中的属性"))
        data.add(ContentLayoutAdapter.LayType("     一个类或者对象可以实现一个或多个接口。"))
        data.add(ContentLayoutAdapter.LayType("♦️  接口继承"))
        data.add(ContentLayoutAdapter.LayType("♦️  解决覆盖冲突"))


        adapter.data = data
        adapter.notifyDataSetChanged()
    }
}