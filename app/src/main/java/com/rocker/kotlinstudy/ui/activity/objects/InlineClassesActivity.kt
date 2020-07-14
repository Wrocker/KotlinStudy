package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * 内联类 todo 目前实验性
 */
class InlineClassesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.inlineClasses
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  inline 修饰符"))
        data.add(ContentLayoutAdapter.LayType("     业务逻辑需要围绕某种类型创建包装器"))//例如stringUtil工具类

        data.add(ContentLayoutAdapter.LayType("♦️  成员"))
        data.add(ContentLayoutAdapter.LayType("     内联类可以声明属性与函数"))
        data.add(ContentLayoutAdapter.LayType("     内联类的成员也有一些限制："))
        data.add(ContentLayoutAdapter.LayType("     - 内联类不能含有 init 代码块"))
        data.add(ContentLayoutAdapter.LayType("     - 内联类不能含有幕后字段"))
        data.add(ContentLayoutAdapter.LayType("     内联类只能含有简单的计算属性（不能含有延迟初始化/委托属性）"))

        data.add(ContentLayoutAdapter.LayType("♦️  继承"))
        data.add(ContentLayoutAdapter.LayType("     内联类允许去继承接口"))
        data.add(ContentLayoutAdapter.LayType("     禁止内联类参与到类的继承关系结构中。"))
        data.add(ContentLayoutAdapter.LayType("     内联类必须是final的"))

        data.add(ContentLayoutAdapter.LayType("♦️  表示方式"))
        data.add(ContentLayoutAdapter.LayType("     内联类既可以表示为基础类型又可以表示为包装器"))
        data.add(ContentLayoutAdapter.LayType("     引用相等对于内联类而言毫无意义，因此这也是被禁止的。即===和!=="))

        data.add(ContentLayoutAdapter.LayType("♦️  名字修饰"))
        data.add(ContentLayoutAdapter.LayType("     由于内联类被编译为其基础类型，因此可能会导致各种模糊的错误"))
        data.add(ContentLayoutAdapter.LayType("     解决：一般会通过在函数名后面拼接一些稳定的哈希码来重命名函数"))//转为java代码可以看见

        data.add(ContentLayoutAdapter.LayType("♦️  内联类与类型别名"))
        data.add(ContentLayoutAdapter.LayType("     内联类引入了一个真实的新类型，类型别名不是"))



        adapter.data = data
        adapter.notifyDataSetChanged()

        //运行时并不会创建StringUtil类，只会有time参数
        println("this is a simple inline class ${StringUtil(null)}")
        println("this is a simple inline class ${StringUtil("0.23").toPercent()}")
        StringUtil("wakaa").print()

        //表达方式
        val f = Foo(42)
        asInline(f)    // 拆箱操作: 用作 Foo 本身
        asGeneric(f)   // 装箱操作: 用作泛型类型 T
        asInterface(f) // 装箱操作: 用作类型 I
        asNullable(f)  // 装箱操作: 用作不同于 Foo 的可空类型 Foo?

        // 在下面这里例子中，'f' 首先会被装箱（当它作为参数传递给 'id' 函数时）然后又被拆箱（当它从'id'函数中被返回时）
        // 最后， 'c' 中就包含了被拆箱后的内部表达(也就是 '42')， 和 'f' 一样
        val c = id(f)
    }

    //和typealias的区别

    fun acceptString(s: String) {}
    fun acceptNameTypeAlias(n: NameTypeAlias) {}
    fun acceptNameInlineClass(p: NameInlineClass) {}

    fun main() {
        val nameAlias: NameTypeAlias = ""
        val nameInlineClass: NameInlineClass = NameInlineClass("")
        val string: String = ""

        acceptString(nameAlias) // 正确: 传递别名类型的实参替代函数中基础类型的形参
//        acceptString(nameInlineClass) // 错误: 不能传递内联类的实参替代函数中基础类型的形参

        // And vice versa:
        acceptNameTypeAlias(string) // 正确: 传递基础类型的实参替代函数中别名类型的形参
//        acceptNameInlineClass(string) // 错误: 不能传递基础类型的实参替代函数中内联类类型的形参
    }
}
typealias NameTypeAlias = String
inline class NameInlineClass(val s: String)


interface PrintSelf{
    fun print()
}

//open class PrintIt{//内联类不能继承类
//
//}

inline class StringUtil(private val info: String?) : PrintSelf{//ide警告说是实验的

    fun toPercent(): String {//作为静态方法调用
        var temp = "0"
        if(info == null || "null" == info){
            return temp
        }else{
            val format = DecimalFormat("0.##")
            format.roundingMode = RoundingMode.FLOOR
            temp = format.format(info)
        }
        return "$temp%"
    }

    override fun print() {
        println("i am $info")
    }
}

interface I

inline class Foo(val i: Int) : I

fun asInline(f: Foo) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo?) {}

fun <T> id(x: T): T = x


//名字修饰
inline class UInt(val x: Int)

// 在 JVM 平台上被表示为'public final void compute(int x)'
fun compute(x: Int) { }
// 同理，在 JVM 平台上也被表示为'public final void compute(int x)'！//因此方法名后方编译时加了hashcode
fun compute(x: UInt) { }