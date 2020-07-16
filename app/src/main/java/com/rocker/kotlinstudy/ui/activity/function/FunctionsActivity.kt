package com.rocker.kotlinstudy.ui.activity.function

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 函数
 */
class FunctionsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.functions
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  函数声明"))
        data.add(ContentLayoutAdapter.LayType("     函数使用 fun 关键字声明"))
        data.add(ContentLayoutAdapter.LayType("♦️  函数用法"))
        data.add(ContentLayoutAdapter.LayType("     调用函数使用传统的方法,调用成员函数使用点表示法"))
        data.add(ContentLayoutAdapter.LayType("♦️  参数"))
        data.add(ContentLayoutAdapter.LayType("     函数参数使用 Pascal 表示法定义，即 name: type。参数用逗号隔开。每个参数必须有显式类型"))
        data.add(ContentLayoutAdapter.LayType("♦️  默认参数"))
        data.add(ContentLayoutAdapter.LayType("     函数参数可以有默认值，当省略相应的参数时使用默认值。与其他语言相比，这可以减少重载数量"))
        data.add(ContentLayoutAdapter.LayType("     默认值通过类型后面的 = 及给出的值来定义。"))
        data.add(ContentLayoutAdapter.LayType("     覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值"))
        data.add(ContentLayoutAdapter.LayType("♦️  解决覆盖冲突"))

        adapter.data = data
        adapter.notifyDataSetChanged()


        copy(null, "这里", "那里")//函数参数可以有默认值，当省略相应的参数时使用默认值。
        copy(from = "这里", to = "那里", len = 3)//如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用
    }


    fun copy(sth: String? = "thing", from: String, to: String, len: Int = from.length){
        println("the length of $sth is len! copy $sth from $from to $to")
    }
}