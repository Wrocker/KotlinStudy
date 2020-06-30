package com.rocker.kotlinstudy.ui.activity.objects

import android.view.View
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.adapter.BaseRecAdapter
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 嵌套类和内部类
 */
class NestedAndInnerClassesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.nestedAndInnerClasses
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  嵌套类"))
        data.add(ContentLayoutAdapter.LayType("     类可以嵌套在其他类中, 嵌套类无法获取外部类成员"))
        data.add(ContentLayoutAdapter.LayType("♦️  内部类"))
        data.add(ContentLayoutAdapter.LayType("     标记为 inner 的嵌套类能够访问其外部类的成员。内部类会带有一个对外部类的对象的引用："))
        data.add(ContentLayoutAdapter.LayType("♦️  匿名内部类"))

        adapter.data = data
        adapter.notifyDataSetChanged()


        val nested = Outer.Nested().foo() // == 2
        val inner = Outer().Inner().foo() // == 1

        //匿名内部类
        adapter.onItemClickListener = object : BaseRecAdapter.OnItemClickListener {//todo 对象表达式
            override fun onItemClick(view: View?) {
                println()
            }
        }
        //todo 对于 JVM 平台, 如果对象是函数式 Java 接口（即具有单个抽象方法的 Java 接口）的实例， 你可以使用带接口类型前缀的lambda表达式创建它：

    }

    class Outer {
        private val bar: Int = 1
        class Nested {
            fun foo() = 2
        }

        inner class Inner {
            fun foo() = bar
        }
    }
}