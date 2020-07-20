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
        data.add(ContentLayoutAdapter.LayType("     函数参数默认val修饰，不可修改"))
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
        data.add(ContentLayoutAdapter.LayType("     标有 infix 关键字的函数也可以使用中缀表示法（忽略该调用的点与圆括号）调用。"))
        data.add(ContentLayoutAdapter.LayType("     - 必须是成员函数或扩展函数；"))
        data.add(ContentLayoutAdapter.LayType("     - 必须只有一个参数；"))
        data.add(ContentLayoutAdapter.LayType("     - 其参数不得接受可变数量的参数且不能有默认值。"))
        data.add(ContentLayoutAdapter.LayType("     中缀函数调用的优先级低于算术操作符、类型转换以及 rangeTo 操作符。"))
        data.add(ContentLayoutAdapter.LayType("     - 1 shl 2 + 3 等价于 1 shl (2 + 3)"))
        data.add(ContentLayoutAdapter.LayType("     - 0 until n * 2 等价于 0 until (n * 2)"))
        data.add(ContentLayoutAdapter.LayType("     - xs union ys as Set<*> 等价于 xs union (ys as Set<*>)"))
        //优先级见https://www.kotlincn.net/docs/reference/grammar.html#expressions
        data.add(ContentLayoutAdapter.LayType("     中缀函数调用的优先级高于布尔操作符 && 与 ||、is- 与 in- 检测以及其他一些操作符。"))
        data.add(ContentLayoutAdapter.LayType("     - a && b xor c 等价于 a && (b xor c)"))
        data.add(ContentLayoutAdapter.LayType("     - a xor b in c 等价于 (a xor b) in c"))
        data.add(ContentLayoutAdapter.LayType("     中缀函数总是要求指定接收者与参数。当使用中缀表示法在当前接收者上调用方法时，需要显式使用 this；"))

        data.add(ContentLayoutAdapter.LayType("♦️  函数作用域"))
        data.add(ContentLayoutAdapter.LayType("     在 Kotlin 中函数可以在文件顶层声明"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 中函数也可以声明在局部作用域、作为成员函数以及扩展函数。"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  局部函数"))//编译为java后，发现是创建一个类，方法在类中，通过类调用
        data.add(ContentLayoutAdapter.LayType("     Kotlin 支持局部函数，即一个函数在另一个函数内部"))
        data.add(ContentLayoutAdapter.LayType("     局部函数可以访问外部函数（即闭包）的局部变量"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  成员函数"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  泛型函数"))
        data.add(ContentLayoutAdapter.LayType("     函数可以有泛型参数，通过在函数名前使用尖括号指定"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  内联函数"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  扩展函数"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  高阶函数和 Lambda 表达式"))
        data.add(ContentLayoutAdapter.LayType(" ♦️  尾递归函数"))
        data.add(ContentLayoutAdapter.LayType("     一种称为尾递归的函数式编程风格。 这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。"))
        data.add(ContentLayoutAdapter.LayType("     当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本"))
        data.add(ContentLayoutAdapter.LayType("     符合 tailrec 修饰符的条件"))
        data.add(ContentLayoutAdapter.LayType("     - 函数必须将其自身调用作为它执行的最后一个操作"))
        data.add(ContentLayoutAdapter.LayType("     - 在递归调用后有更多代码时，不能使用尾递归，并且不能用在 try/catch/finally 块中"))
        data.add(ContentLayoutAdapter.LayType("     - 目前在 Kotlin for JVM 与 Kotlin/Native 中支持尾递归。"))

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
        //中缀
        percent(0.6)
        this percent 0.5//中缀函数总是要求指定接收者与参数。当使用中缀表示法在当前接收者上调用方法时，需要显式使用 this；
        println(this percent 0.5)
    }

    //尾递归函数
    tailrec fun countAdd(start: Int): Int = if((start + 1) > 10) (start + 1) else countAdd(start + 1)

    //官方
    val eps = 1E-10 // "good enough", could be 10^-15

    tailrec fun findFixPoint(x: Double = 1.0): Double
            = if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))
    //以上代码写成循环
    fun cycle2findFixPoint(): Double {
        var x = 1.0
        while (true) {
            val y = Math.cos(x)
            if (Math.abs(x - y) < eps) return x
            x = Math.cos(x)
        }
    }

    //泛型函数
    fun <T> addToPrint(obj: T){
        println("${obj.toString()} is added to print")
    }

    //局部函数
    fun partFunction(){
        val tool = "打印机"
        fun printSth(sth: String){
            println("$tool print $sth")//局部函数可以访问外部函数（即闭包）的局部变量
        }
        printSth("lalala")
    }

    //中缀
    infix fun percent(ratio: Double): String = "${ratio * 100}%"

    //重载
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