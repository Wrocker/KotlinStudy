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
        data.add(ContentLayoutAdapter.LayType(" ♦️  默认参数"))
        data.add(ContentLayoutAdapter.LayType("     函数参数可以有默认值，当省略相应的参数时使用默认值。与其他语言相比，这可以减少重载数量"))
        data.add(ContentLayoutAdapter.LayType("     默认值通过类型后面的 = 及给出的值来定义。"))
        data.add(ContentLayoutAdapter.LayType("     - 解决覆盖冲突"))
        data.add(ContentLayoutAdapter.LayType("         覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值"))
        data.add(ContentLayoutAdapter.LayType("     - 重载"))
        data.add(ContentLayoutAdapter.LayType("         如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用"))
        data.add(ContentLayoutAdapter.LayType("     - 参数是lambda 表达式"))
        data.add(ContentLayoutAdapter.LayType("         如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为具名参数在括号内传入，也可以在括号外传入"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  具名参数"))
        data.add(ContentLayoutAdapter.LayType("     可以使代码更具有可读性"))
        data.add(ContentLayoutAdapter.LayType("     当一个函数调用混用位置参数与具名参数时，所有位置参数都要放在第一个具名参数之前。"))
        data.add(ContentLayoutAdapter.LayType("     可以通过使用星号操作符将可变数量参数（vararg） 以具名形式传入"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  可变数量的参数（Varargs）"))
        data.add(ContentLayoutAdapter.LayType("     函数的参数（通常是最后一个）可以用 vararg 修饰符标记"))
        data.add(ContentLayoutAdapter.LayType("     只有一个参数可以标注为 vararg。"))
        data.add(ContentLayoutAdapter.LayType("     如果 vararg 参数不是列表中的最后一个参数， 可以使用具名参数语法传递其后的参数的值，或者，如果参数具有函数类型，则通过在括号外部传一个 lambda。"))
        data.add(ContentLayoutAdapter.LayType("     可以一个一个传参，也可以使用伸展（spread）操作符（在数组前面加 *）"))

        data.add(ContentLayoutAdapter.LayType("♦️  返回 Unit 的函数"))
        data.add(ContentLayoutAdapter.LayType("     不返回任何有用的值，它的返回类型是 Unit"))
        data.add(ContentLayoutAdapter.LayType("     Unit 返回类型声明也是可选的。"))

        data.add(ContentLayoutAdapter.LayType("♦️  单表达式函数"))
        data.add(ContentLayoutAdapter.LayType("     当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可"))
        data.add(ContentLayoutAdapter.LayType("     当返回值类型可由编译器推断时，显式声明返回类型是可选的"))

        data.add(ContentLayoutAdapter.LayType("♦️  显式返回类型"))
        data.add(ContentLayoutAdapter.LayType("     具有块代码体的函数必须始终显式指定返回类型，除非他们旨在返回 Unit"))
        data.add(ContentLayoutAdapter.LayType("♦️  中缀表示法"))

        adapter.data = data
        adapter.notifyDataSetChanged()


        copy(null, "这里", "那里")//函数参数可以有默认值，当省略相应的参数时使用默认值。
        copy(from = "这里", to = "那里", len = 3)//如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用
        //lambda表达式放参数末尾
        doSth("洗刷刷", { println("to do sth")})
        doSth("洗刷刷"){ println("to do sth")}
        //具名参数
        copy(sth = "wakaka", from = "这里", to = "那里")
        copy("wakaka", from = "这里", to = "那里")//混用位置参数和具名参数
//        copy(sth = "wakaka", "这里", "那里")//具名参数开始使用，后方的参数也必须使用
        printEveryThing(things = *arrayOf("1", "2", "3"))//可以通过使用星号操作符将可变数量参数（vararg） 以具名形式传入
    }


    fun copy(sth: String? = "thing", from: String, to: String, len: Int = from.length){
        println("the length of $sth is len! copy $sth from $from to $to")
    }

    fun doSth(sth: String, doing : () -> Unit){
        doing
    }

    fun printEveryThing(vararg things: String){//可变参数
        for(thing in things){
            print(thing)
        }
    }

    //继承重写
    open class Bottle{
        open fun openBottle(function: String = "扭开"){
            println("打开方式为$function")
        }
    }

    class BeerBottle : Bottle(){
        override fun openBottle(function: String){
            super.openBottle(function)
        }

        fun width() = 6 //当返回值类型可由编译器推断时，显式声明返回类型是可选的

        fun height(): Int = 26 //当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
    }
}