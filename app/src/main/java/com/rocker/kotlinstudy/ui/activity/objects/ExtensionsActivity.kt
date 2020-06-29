package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 泛型写法，适用于所有MutableList<T>类型
 * 位于顶层，同一包内都能使用，不同包需要import(比如com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity中就需要import)
 */
fun <T> MutableList<T>.swapT(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * 拓展
 */
class ExtensionsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.extensions
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  扩展函数"))
        data.add(ContentLayoutAdapter.LayType("     声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀。"))
        data.add(ContentLayoutAdapter.LayType("     在类中定义的扩展函数只能在类中使用"))

        data.add(ContentLayoutAdapter.LayType("♦️  扩展是静态解析的"))
        data.add(ContentLayoutAdapter.LayType("     调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的"))
        data.add(ContentLayoutAdapter.LayType("     拓展函数和成员函数重复时，成员函数优先"))

        data.add(ContentLayoutAdapter.LayType("♦️  扩展属性"))
        data.add(ContentLayoutAdapter.LayType("     扩展属性不能有初始化器"))
        data.add(ContentLayoutAdapter.LayType("     扩展属性来说幕后字段是无效的"))

        data.add(ContentLayoutAdapter.LayType("♦️  伴生对象的扩展"))

        data.add(ContentLayoutAdapter.LayType("♦️  扩展的作用域"))
        data.add(ContentLayoutAdapter.LayType("     在类中，则只能在类中使用"))
        data.add(ContentLayoutAdapter.LayType("     在顶层，则能在当前包路径下使用，其他需要import"))

        data.add(ContentLayoutAdapter.LayType("♦️  扩展声明为成员")) //即成员方法
        data.add(ContentLayoutAdapter.LayType("     扩展声明所在的类的实例称为 分发接收者")) //todo 没理清
        data.add(ContentLayoutAdapter.LayType("     扩展方法调用所在的接收者类型的实例称为 扩展接收者"))

        data.add(ContentLayoutAdapter.LayType("♦️  关于可见性的说明"))
        data.add(ContentLayoutAdapter.LayType("     扩展的可见性与相同作用域内声明的其他实体的可见性相同"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        val list = mutableListOf<Int>(1 , 2, 3)
        list.swap(0, 1)
        println("list is ${list.toString()}")
        //拓展函数是静态的
        printClassName(Rectangle())
        //拓展函数和成员函数重复
        Example().printFunctionType()
        //拓展函数和成员函数参数不同（重载的情况）
        Example().printFunctionType(1)

        //伴生对象的扩展
        MyClass.printCompanion()

        //扩展声明为成员(拓展在类中)
        Connection(Host("kotl.in"), 443).connect()
        //Host("kotl.in").printConnectionString(443)  // 错误，该扩展函数在 Connection 外不可用
    }

    /**
     * 为MutableList添加交换的方法
     * 只在该类中使用
     */
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // “this”对应该列表
        this[index1] = this[index2]
        this[index2] = tmp
    }

    open class Shape

    class Rectangle: Shape()

    fun Shape.getName() = "Shape"

    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape) {
        println(s.getName()) //调用的Shape的拓展函数
    }

    class Example {
        fun printFunctionType() { println("Class method") }
    }

    fun Example.printFunctionType() { println("Extension function") }

    fun Example.printFunctionType(i: Int) { println("Extension function Int") }

//    fun Example.printFunctionType() : Boolean { println("Extension function Int") }

    //拓展属性
    val <T> List<T>.lastIndex: Int
        get() = this.size - 1

//    val <T> List<T>.lastIndex: Int = 1 //错误 //todo 幕后字段无效

    //伴生对象的使用
    class MyClass {
        companion object { }  // 将被称为 "Companion"
    }

    fun MyClass.Companion.printCompanion() { println("companion") }

    //拓展声明为成员
    class Host(val hostname: String) {
        fun printHostname() { print(hostname) }
    }

    class Connection(val host: Host, val port: Int) {
        fun printPort() { print(port) }

        fun Host.printConnectionString() {
            printHostname()   // 调用 Host.printHostname()
            print(":")
            printPort()   // 调用 Connection.printPort()
        }

        fun connect() {
            /*……*/
            host.printConnectionString()   // 调用扩展函数
        }
        //同一个方法的优先级
        fun Host.getConnectionString() {
            toString()         // 调用 Host.toString()
            this@Connection.toString()  // 调用 Connection.toString()
        }
    }

    //类中拓展声明方法的重写
    open class Base { }

    class Derived : Base() { }

    open class BaseCaller {
        open fun Base.printFunctionInfo() { //分发接收者
            println("Base extension function in BaseCaller")
        }

        open fun Derived.printFunctionInfo() { //扩展接收者
            println("Derived extension function in BaseCaller")
        }

        fun call(b: Base) {
            b.printFunctionInfo()   // 调用扩展函数
        }
    }

    class DerivedCaller: BaseCaller() {
        override fun Base.printFunctionInfo() {
            println("Base extension function in DerivedCaller")
        }

        override fun Derived.printFunctionInfo() {
            println("Derived extension function in DerivedCaller")
        }
    }

    fun main() {
        BaseCaller().call(Base())   // “Base extension function in BaseCaller”
        DerivedCaller().call(Base())  // “Base extension function in DerivedCaller”——分发接收者虚拟解析
        DerivedCaller().call(Derived())  // “Base extension function in DerivedCaller”——扩展接收者静态解析
    }

}