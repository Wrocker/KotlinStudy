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
        data.add(ContentLayoutAdapter.LayType("♦️  Kotlin 中的类也可以有类型参数"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 的接口可以既包含抽象方法的声明也包含实现。"))

        data.add(ContentLayoutAdapter.LayType("♦️  型变"))
        data.add(ContentLayoutAdapter.LayType("     一个类或者对象可以实现一个或多个接口。"))

        //out相当于 java通配符类型参数 ? extends E
        data.add(ContentLayoutAdapter.LayType("♦️  声明处型变（declaration-site variance"))
        data.add(ContentLayoutAdapter.LayType("     接口中不存在任何以 T 作为参数的方法，只是方法返回 T 类型值，用out进行修饰"))
        data.add(ContentLayoutAdapter.LayType("     out修饰符称为型变注解，并且由于它在类型参数声明处提供，所以我们称之为声明处型变。 "))
        data.add(ContentLayoutAdapter.LayType("     in 只可以被消费而不可以被生产。"))
        data.add(ContentLayoutAdapter.LayType("     只可以被消费而不可以被生产。"))

        data.add(ContentLayoutAdapter.LayType("♦️  类型投影（type projections）"))
        data.add(ContentLayoutAdapter.LayType("     有些类既需要被生存，又需要被消费的情况//例如Array"))

        data.add(ContentLayoutAdapter.LayType("♦️  泛型函数"))

        data.add(ContentLayoutAdapter.LayType("♦️  泛型约束"))

        data.add(ContentLayoutAdapter.LayType("♦️  类型擦除"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        //一般来说，要创建这样类的实例，我们需要提供类型参数：
        val box: Box<Int> = Box<Int>(1)
        //如果类型参数可以推断出来，例如从构造函数的参数或者从其他途径，允许省略类型参数
        val box1 = Box(2)

        val ints: Array<Int> = arrayOf(1, 2, 3)
        val anys = Array<Any>(3) { 3; 4 }
//        copy(ints, any)//报错，copy时，Any和Int是不型变的
        copyOut(ints, anys)
        val chars = Array<Char>(3){'1'}
        fill(anys, "haha")
//        fill(chars, "haha")
    }

    class Box<T>(var t: T)

    //————————————声明处型变————————————
    interface Source<out T> { //不加out,下面方法编译报错
        fun nextT(): T
    }

    fun demo(strs: Source<String>) {
        val objects: Source<Any> = strs // 这个没问题，因为 T 是一个 out-参数
        // ……
    }
    //in
    interface Comparable<in T> {
        operator fun compareTo(other: T): Int
    }

    fun demo(x: Comparable<Number>) {
        x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的子类型
        // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
        val y: Comparable<Double> = x // OK！
    }

    //--------类型投影--------
//    class List<T>(val size: Int) {
//
//        val list = ArrayList<T>(size)
//
//        fun get(index: Int): T {
//            return list[index]
//        }
//
//        fun set(index: Int, value: T) {
//            list[index] = value
//        }
//
//        fun copy(from: Array<Any>, to: Array<Any>) {
//            assert(from.size == to.size)
//            for (i in from.indices)
//                to[i] = from[i]
//        }
//    }

    fun copy(from: Array<Any>, to: Array<Any>) {
        assert(from.size == to.size)
        for (i in from.indices)
            to[i] = from[i]
    }

    //out修饰，表示传进来的父类是Any就可以
    fun copyOut(from: Array<out Any>, to: Array<Any>) {
        assert(from.size == to.size)
        for (i in from.indices)
            to[i] = from[i]
    }

    fun fill(dest: Array<in String>, value: String) {
        dest.forEachIndexed { index, any -> if(any == null) dest[index] = value }
    }

}