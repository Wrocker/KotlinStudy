package com.rocker.kotlinstudy.ui.activity.objects

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 泛型
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

        data.add(ContentLayoutAdapter.LayType("♦️  使用处型变：类型投影（type projections）"))
        data.add(ContentLayoutAdapter.LayType("     有些类既需要被生存，又需要被消费的情况//例如Array"))
        data.add(ContentLayoutAdapter.LayType("     即out和in 应用于同一个类的方法中"))

        data.add(ContentLayoutAdapter.LayType("♦️  星投影"))
        data.add(ContentLayoutAdapter.LayType("     - 对于 Foo <out T : TUpper>，其中 T 是一个具有上界 TUpper 的协变类型参数，Foo <*> 等价于 Foo <out TUpper>。"))
        data.add(ContentLayoutAdapter.LayType("       这意味着当 T 未知时，你可以安全地从 Foo <*> 读取 TUpper 的值。"))
        data.add(ContentLayoutAdapter.LayType("     - 对于 Foo <in T>，其中 T 是一个逆变类型参数，Foo <*> 等价于 Foo <in Nothing>。"))
        data.add(ContentLayoutAdapter.LayType("       这意味着当 T 未知时，没有什么可以以安全的方式写入 Foo <*>。"))
        data.add(ContentLayoutAdapter.LayType("     - 对于 Foo <T : TUpper>，其中 T 是一个具有上界 TUpper 的不型变类型参数，Foo<*> 对于读取值时等价于 Foo<out TUpper> 而对于写值时等价于 Foo<in Nothing>。"))
        data.add(ContentLayoutAdapter.LayType("      注意：星投影非常像 Java 的原始类型，但是安全。"))

        data.add(ContentLayoutAdapter.LayType("♦️  泛型函数"))
        data.add(ContentLayoutAdapter.LayType("     要调用泛型函数，在调用处函数名之后指定类型参数即可："))
        val l1 = singletonList<Int>(1)
        data.add(ContentLayoutAdapter.LayType("     可以省略能够从上下文中推断出来的类型参数，所以以下示例同样适用："))
        val l2 = singletonList(1)

        data.add(ContentLayoutAdapter.LayType("♦️  泛型约束"))
        data.add(ContentLayoutAdapter.LayType("♦️  上界"))
        data.add(ContentLayoutAdapter.LayType("♦️  多个上界，where语句"))

        data.add(ContentLayoutAdapter.LayType("♦️  类型擦除"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        //一般来说，要创建这样类的实例，我们需要提供类型参数：
        val box: Box<Int> = Box<Int>(1)
        //如果类型参数可以推断出来，例如从构造函数的参数或者从其他途径，允许省略类型参数
        val box1 = Box(2)

        //使用处型变
        val ints: Array<Int> = arrayOf(1, 2, 3)
        val anys = Array<Any>(3) { 3; 4 }
//        copy(ints, any)//报错，copy时，Any和Int是不型变的
        copyOut(ints, anys)
        val chars = Array<Char>(3){'1'}
        fill(anys, "haha")
//        fill(chars, "haha")

        //星投影
        val list1 : Array<TextView> = arrayOf(rootBinding.tvTitle);
        val list2 : Array<*> = list1
        //这里Array<*>等价于下面的
        val list3 : Array<out View> = list1
        val list4 : Array<in CheckBox> = list1

        //泛型约束
//        sort(listOf(1, 2, 3)) // OK。Int 是 Comparable<Int> 的子类型
//        sort(listOf(HashMap<Int, String>())) // 错误：HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型
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

    //泛型函数
    fun <T> singletonList(item: T): List<T> {
        return arrayListOf(item)
    }

    fun <T> T.basicToString(): String {  // 扩展函数
        return "hash:${hashCode()}"
    }

    val <T> List<T>.lastIndex: Int
        get() = size - 1

    //泛型约束 上界 //todo 同一个类中出现同名类
    fun <T : Comparable<T>> sort(list: List<T>) {  } //只有 Comparable<T> 的子类型可以替代 T
    //多个上界的情况
    fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
            where T : CharSequence,
                  T : Comparable<T> {
        return list.filter { it > threshold }.map { it.toString() }
    }
}