package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 类与继承
 */
class ClassesAndInheritanceActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.classesAndInheritance
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️ 类"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin中用class申明类"))
        data.add(ContentLayoutAdapter.LayType("     类声明由类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成。"))
        data.add(ContentLayoutAdapter.LayType("     若没有类体，可省略花括号"))
        data.add(ContentLayoutAdapter.LayType("♦️ 主构造函数"))
        data.add(ContentLayoutAdapter.LayType("      "))
        data.add(ContentLayoutAdapter.LayType("♦️ 次构造函数"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        Student("Li")
        Customer("Lu", Customer("Hei"))
        Animal()
    }

    class Empty

    //主构造函数 constructor修饰
    class People constructor(firstName: String){}
    //如果主构造函数没有任何注解或者可见性修饰符 constructor可省略（主构造函数的参数,在初始化器中都能使用，但在方法中不能使用）
    class Student (firstName: String){//参数/init 初始化顺序由代码位置前后决定
        //todo also{}的用法
        val first = "first is $firstName".also { println(it) }
        //todo also（）的用法
        val second = "second is $firstName".also (::println)

        init {
            //主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
            println("third $firstName")
        }

        init {
            //主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
            println("fourth $firstName")
        }
    }

    //声明属性以及从主构造函数初始化属性
    class Teacher (val firstName: String)

    //如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
    class Professor public constructor(name: String)//todo 可见性修饰符怎么放


    //此构造函数有constructor申明
    class Customer(name: String) {
        val theatre: MutableList<Customer> = arrayListOf()

        init {//初始化代码块/初始化变量 语句包含在主构造中，因此先执行
            println("is First $name")
        }

        constructor(name: String, customer: Customer): this(name){//可这样委托到主构造函数/其他构造函数
            customer.theatre.add(this)
            println("add")
        }
    }

    //如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的主构造函数。构造函数的可见性是 public。
    // 如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数：
    class DontCreateMe private constructor ()

    //在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，它将使用默认值。
    class Animal(val name: String = "")
}