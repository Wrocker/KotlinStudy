package com.rocker.kotlinstudy.ui.activity.objects

import android.view.View
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 对象
 */
class ObjectsActivity : BaseLoadListActivity(){
    override fun initTitle(): Int {
        return R.string.objects
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  对象表达式"))
        data.add(ContentLayoutAdapter.LayType("     创建一个继承自某个（或某些）类型的匿名类的对象"))
        data.add(ContentLayoutAdapter.LayType("     如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。 多个超类型可以由跟在冒号后面的逗号分隔的列表指定："))

        data.add(ContentLayoutAdapter.LayType("♦️  对象声明"))
        data.add(ContentLayoutAdapter.LayType("     单例模式在一些场景中很有用， 而 Kotlin（继 Scala 之后）使单例声明变得很容易："))
        data.add(ContentLayoutAdapter.LayType("     且它总是在 object 关键字后跟一个名称。 就像变量声明一样，对象声明不是一个表达式，不能用在赋值语句的右边。"))
        data.add(ContentLayoutAdapter.LayType("     对象声明的初始化过程是线程安全的并且在首次访问时进行。"))
        data.add(ContentLayoutAdapter.LayType("     对象声明不能在局部作用域（即直接嵌套在函数内部），但是它们可以嵌套到其他对象声明或非内部类中。"))

        data.add(ContentLayoutAdapter.LayType("♦️  伴生对象"))
        data.add(ContentLayoutAdapter.LayType("     类内部的对象声明可以用 companion 关键字标记："))
        data.add(ContentLayoutAdapter.LayType("     该伴生对象的成员可通过只使用类名作为限定符来调用"))
        data.add(ContentLayoutAdapter.LayType("     可以省略伴生对象的名称，在这种情况下将使用名称 Companion："))
        data.add(ContentLayoutAdapter.LayType("     其自身所用的类的名称（不是另一个名称的限定符）可用作对该类的伴生对象 （无论是否具名）的引用："))
        data.add(ContentLayoutAdapter.LayType("     即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口："))

        data.add(ContentLayoutAdapter.LayType("     在 JVM 平台，如果使用 @JvmStatic 注解，你可以将伴生对象的成员生成为真正的静态方法和字段。"))

        data.add(ContentLayoutAdapter.LayType("♦️  对象表达式和对象声明之间的语义差异"))
        data.add(ContentLayoutAdapter.LayType("     - 对象表达式是在使用他们的地方立即执行（及初始化）的；"))
        data.add(ContentLayoutAdapter.LayType("     - 对象声明是在第一次被访问到时延迟初始化的；"))
        data.add(ContentLayoutAdapter.LayType("     - 伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配。"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        //创建一个继承自某个（或某些）类型的匿名类的对象
        rootBinding.tvTitle.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                println("this is title")
            }
        })
        //如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。 多个超类型可以由跟在冒号后面的逗号分隔的列表指定：
        val clickFruit = object : Fruit("click"), View.OnClickListener{
            override fun onClick(v: View?) {
                println("this is clickFruit")
            }
        }
        //任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写：
        val dest = object  {
            var name: String = "书桌"
            var material: String = "木质"
        }
        println("print ${dest.name}")

        //请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。
        // 如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，那么该函数或属性的实际类型会是匿名对象声明的超类型，如果你没有声明任何超类型，就会是 Any。
        // 在匿名对象中添加的成员将无法访问。
        println("his name is ${objectFun().name}") //能.name
        println("his name is ${publicobjectFun()}")//默认返回的Any,所以.name报错
        //对象表达式中的代码可以访问来自包含它的作用域的变量。

        //______________对象声明__________________
        //单例
        FruitProduction.getFruit()[0].toString()

        //______________伴生对象__________________
        //该伴生对象的成员可通过只使用类名作为限定符来调用
        val myClass = MyClass.create() //未调用factory
        val factory = Paper.Companion //伴生对象的名称若省略，调用时可.Companion调用
        //其自身所用的类的名称（不是另一个名称的限定符）可用作对该类的伴生对象 （无论是否具名）的引用：
        Paper.showPaper()
    }

    open class Fruit(name: String)

    private fun objectFun() = object {
        val name = "objectFun"
    }

    public fun publicobjectFun() = object {
        val name = "publicobjectFun"
    }

    fun includeSimple(){
        val tempA = "A"
        rootBinding.tvTitle.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                println("tempA is $tempA")
            }

        })
    }


    object FruitProduction : Fruit("水果厂"){//对象可以有超类型
        fun getFruit() : Array<Fruit> {
            return wareHouse
        }

        val wareHouse : Array<Fruit>
            get() = arrayOf(Fruit("苹果"), Fruit("香蕉"))
    }


    class MyClass {
        companion object Factory {//伴生对象
            fun create(): MyClass = MyClass()
        }
    }

    class Paper {
        companion object : View.OnClickListener {//伴生对象
            fun create(): Paper = Paper()

            fun showPaper(){
                println("show Paper content")
            }

            override fun onClick(v: View?) {
                println("click paper")
            }
        }
    }
}