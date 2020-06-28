package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

private fun printSomeThing(someThing: String){// 在 VisibilityModifiersActivity.kt 内可见
    println(someThing)
}

public var exampleX: Int = 1// 该属性随处可见
    private set // setter 只在 VisibilityModifiersActivity.kt 内可见

internal val exampleY: Int = 2 //相同模块可见

/**
 * 可见性修饰符
 */
class VisibilityModifiersActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.visibilityModifiers
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  模块"))
        data.add(ContentLayoutAdapter.LayType("     可见性修饰符 internal 意味着该成员只在相同模块内可见。"))
        data.add(ContentLayoutAdapter.LayType("     — 一个 IntelliJ IDEA 模块；"))
        data.add(ContentLayoutAdapter.LayType("     — 一个 Maven 项目；"))
        data.add(ContentLayoutAdapter.LayType("     — 一个 Gradle 源集（例外是 test 源集可以访问 main 的 internal 声明）；"))
        data.add(ContentLayoutAdapter.LayType("     — 一次 <kotlinc> Ant 任务执行所编译的一套文件。"))
        data.add(ContentLayoutAdapter.LayType("♦️  kotlin中有4个可见性修饰符，没有显示指定修饰符，则默认为public"))
        data.add(ContentLayoutAdapter.LayType("     类、对象、接口、构造函数、方法、属性和它们的 setter 都可以有 可见性修饰符。(getter 总是与属性有着相同的可见性)"))
        data.add(ContentLayoutAdapter.LayType("     private、 protected、 internal 和 public"))
        data.add(ContentLayoutAdapter.LayType("♦️  包"))
        data.add(ContentLayoutAdapter.LayType("     函数、属性和类、对象和接口可以在顶层声明，即直接在包内"))
        data.add(ContentLayoutAdapter.LayType("     — 如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见；"))
        data.add(ContentLayoutAdapter.LayType("     — 如果你声明为 private，它只会在声明它的文件内可见；"))
        data.add(ContentLayoutAdapter.LayType("     — 如果你声明为 internal，它会在相同模块内随处可见；"))
        data.add(ContentLayoutAdapter.LayType("     — protected 不适用于顶层声明。"))
        data.add(ContentLayoutAdapter.LayType("♦️  类和接口"))
        data.add(ContentLayoutAdapter.LayType("     — private 意味着只在这个类内部（包含其所有成员）可见；"))
        data.add(ContentLayoutAdapter.LayType("     — protected —— 和 private一样 + 在子类中可见。"))
        data.add(ContentLayoutAdapter.LayType("     — internal —— 能见到类声明的 本模块内 的任何客户端都可见其 internal 成员；"))
        data.add(ContentLayoutAdapter.LayType("     — public —— 能见到类声明的任何客户端都可见其 public 成员。"))
        data.add(ContentLayoutAdapter.LayType("     请注意在 Kotlin 中，外部类不能访问内部类的 private 成员"))
        data.add(ContentLayoutAdapter.LayType("     如果你覆盖一个 protected 成员并且没有显式指定其可见性，该成员还会是 protected 可见性。"))
        data.add(ContentLayoutAdapter.LayType("♦️  构造函数"))
        data.add(ContentLayoutAdapter.LayType("     默认情况下，所有构造函数都是 public，这实际上等于类可见的地方它就可见（即 一个 internal 类的构造函数只能在相同模块内可见)."))
        data.add(ContentLayoutAdapter.LayType("♦️  局部声明"))
        data.add(ContentLayoutAdapter.LayType("     局部变量、函数和类不能有可见性修饰符。"))


        adapter.data = data
        adapter.notifyDataSetChanged()
        val outer = Outer()
//        outer.simpleA 不可见
//        outer.simpleB 不可见
        outer.simpleC
        outer.simpleD
//        Outer.Inner不可见
//        Outer.Inner.simpleE不可见
        val another = Outer.Another()
        another.simpleF
        another.simpleG
    }

    open class Outer {
        private val simpleA = 1
        protected open val simpleB = 2
        internal val simpleC = 3
        val simpleD = 4

        protected class Inner{
            public val simpleE = 5
        }

        class Another{
            internal val simpleF = 6
            val simpleG = 6
        }
    }

    class SubClass : Outer() {
        override val simpleB: Int = 7 //默认protected修饰
    }

    //构造函数
    class privateObject private constructor(a: String)
}