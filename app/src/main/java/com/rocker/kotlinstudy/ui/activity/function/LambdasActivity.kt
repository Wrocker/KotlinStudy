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
        data.add(ContentLayoutAdapter.LayType("♦️  函数类型"))
        data.add(ContentLayoutAdapter.LayType("     使用类似 (Int) -> String 的一系列函数类型来处理函数的声明"))
        data.add(ContentLayoutAdapter.LayType("     函数类型表示法可以选择性地包含函数的参数名：(x: Int, y: Int) -> Point。 这些名称可用于表明参数的含义。"))
        data.add(ContentLayoutAdapter.LayType("     - 所有函数类型都有一个圆括号括起来的参数类型列表以及一个返回类型：(A, B) -> C 表示接受类型分别为 A 与 B 两个参数并返回一个 C 类型值的函数类型。 参数类型列表可以为空，如 () -> A。Unit 返回类型不可省略。"))
        data.add(ContentLayoutAdapter.LayType("     - 函数类型可以有一个额外的接收者类型，它在表示法中的点之前指定： 类型 A.(B) -> C 表示可以在 A 的接收者对象上以一个 B 类型参数来调用并返回一个 C 类型值的函数。"))
        data.add(ContentLayoutAdapter.LayType("     - 挂起函数属于特殊种类的函数类型，它的表示法中有一个 suspend 修饰符 ，例如 suspend () -> Unit 或者 suspend A.(B) -> C。"))
        data.add(ContentLayoutAdapter.LayType("     函数类型表示法可以选择性地包含函数的参数名：(x: Int, y: Int) -> Point。 这些名称可用于表明参数的含义。"))
        data.add(ContentLayoutAdapter.LayType("     - 如需将函数类型指定为可空，请使用圆括号：((Int, Int) -> Int)?"))
        data.add(ContentLayoutAdapter.LayType("     - 函数类型可以使用圆括号进行接合：(Int) -> ((Int) -> Unit)"))
        data.add(ContentLayoutAdapter.LayType("     - 箭头表示法是右结合的，(Int) -> (Int) -> Unit 与前述示例等价，但不等于 ((Int) -> (Int)) -> Unit。"))
        data.add(ContentLayoutAdapter.LayType("     可以通过使用类型别名给函数类型起一个别称"))
        data.add(ContentLayoutAdapter.LayType("♦️  函数类型实例化"))
        data.add(ContentLayoutAdapter.LayType("     有几种方法可以获得函数类型的实例"))
        data.add(ContentLayoutAdapter.LayType("     - 使用函数字面值的代码块，采用以下形式之一"))
        data.add(ContentLayoutAdapter.LayType("         _lambda 表达式: { a, b -> a + b }"))
        data.add(ContentLayoutAdapter.LayType("         _匿名函数: fun(s: String): Int { return s.toIntOrNull() ?: 0 }"))
        data.add(ContentLayoutAdapter.LayType("         _带有接收者的函数字面值可用作带有接收者的函数类型的值"))
        data.add(ContentLayoutAdapter.LayType("     - 使用已有声明的可调用引用"))
        data.add(ContentLayoutAdapter.LayType("         _顶层、局部、成员、扩展函数：::isOdd、 String::toInt"))
        data.add(ContentLayoutAdapter.LayType("         _顶层、成员、扩展属性：List<Int>::size"))
        data.add(ContentLayoutAdapter.LayType("         _构造函数：::Regex"))
        data.add(ContentLayoutAdapter.LayType("         这包括指向特定实例成员的绑定的可调用引用：foo::toString"))
        data.add(ContentLayoutAdapter.LayType("     - 使用实现函数类型接口的自定义类的实例"))

        data.add(ContentLayoutAdapter.LayType("♦️  解决覆盖冲突"))


        adapter.data = data
        adapter.notifyDataSetChanged()
        
        //右结合法 todo 例子
//        doSth("右结合", {
//            string
//            -> println("打印$string")
//            "$string 1"
//            -> println("打印$string")
//            "$string 2"
//        })

        //高阶函数
        doSth("内容", {
            string ->
            println("打印$string")
            "print $string"
        })
        //高阶函数 官方的例子
        val items = listOf(1, 2, 3, 4, 5)
        // Lambdas 表达式是花括号括起来的代码块。
        items.fold(0, {
            // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
                acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i
            println("result = $result")
            // lambda 表达式中的最后一个表达式是返回值：
            result
        })
        // lambda 表达式的参数类型是可选的，如果能够推断出来的话：
        val joinedToString = items.fold("Elements:", { acc, i -> "$acc $i" })
        // 函数引用也可以用于高阶函数调用
        val product = items.fold(1, Int::times)//Int::times的意思是 3.times(2)表示3的几倍
    }

    //高阶函数
    fun doSth(string: String, action: (string: String) -> String){
        action(string)
    }
}

//类型别名给表达式起别称
typealias ClickHandler = (String, Int) -> Unit