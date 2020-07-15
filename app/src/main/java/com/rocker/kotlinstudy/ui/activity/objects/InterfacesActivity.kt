package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 接口
 */
class InterfacesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.interfaces
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

    interface Fruit{

        val name: String //抽象的属性

        val color: String
            get() = "绿色"

        fun taste()
    }

    class Banana : Fruit{
        override val name: String = "香蕉"

        override val color: String
            get() = "黄色" //super.color

        override fun taste() {
            println("taste a litter sweet")
        }

    }


    interface Named {
        val name: String
    }

    //接口的继承
    interface Person : Named {
        val firstName: String
        val lastName: String

        override val name: String get() = "$firstName $lastName"
    }

    data class Employee(
        // 不必实现“name”
        override val firstName: String,
        override val lastName: String,
        val position: String
    ) : Person

    //接口方法的覆盖
    interface  Aspell {
        fun spell() = println("A is a")

        fun name(): String
    }
    interface Bspell {
        fun spell() = println("B is b")

        fun name() = "b"
    }

    class AB : Aspell, Bspell{
        override fun spell() {
            super<Aspell>.spell()
            super<Bspell>.spell()
        }

        override fun name(): String {
            return super<Bspell>.name()
        }


    }
}