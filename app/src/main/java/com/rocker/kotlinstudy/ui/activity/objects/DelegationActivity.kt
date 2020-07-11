package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 委托
 */
class DelegationActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.delegation
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  属性委托")) //委托模式
        data.add(ContentLayoutAdapter.LayType("     属性委托在单独"))
        data.add(ContentLayoutAdapter.LayType("♦️  由委托实现"))
        data.add(ContentLayoutAdapter.LayType("     Derived 的超类型列表中的 by-子句表示 b 将会在 Derived 中内部存储， 并且编译器将生成转发给 b 的所有 Base 的方法。"))

        data.add(ContentLayoutAdapter.LayType("♦️  覆盖由委托实现的接口成员"))
        data.add(ContentLayoutAdapter.LayType("     成员方法会覆盖"))
        data.add(ContentLayoutAdapter.LayType("     变量不会覆盖"))
        
        adapter.data = data
        adapter.notifyDataSetChanged()

        //代理
        Derived(Printer(20)).print()

    }

    interface PrintTool {
        val info : String
        fun print()
    }

    class Printer(val x: Int) : PrintTool {
        override val info: String
            get() = "print info is $x"

        override fun print() { print(info) }
    }

    class Derived(b: PrintTool) : PrintTool by b{
        override val info: String
            get() = "this property has bean override"

        override fun print() {
            print("this function has bean override")
        }
    }

}