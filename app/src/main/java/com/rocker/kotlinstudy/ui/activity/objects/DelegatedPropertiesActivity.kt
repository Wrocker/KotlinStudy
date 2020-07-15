package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 委托属性activity
 */
class DelegatedPropertiesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.delegatedProperties
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  适用需求"))
        data.add(ContentLayoutAdapter.LayType("     - 延迟属性（lazy properties）: 其值只在首次访问时计算；"))
        data.add(ContentLayoutAdapter.LayType("     - 可观察属性（observable properties）: 监听器会收到有关此属性变更的通知；"))
        data.add(ContentLayoutAdapter.LayType("     - 把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。"))
        data.add(ContentLayoutAdapter.LayType("     - 。。。"))

        data.add(ContentLayoutAdapter.LayType("♦️  语法"))
        data.add(ContentLayoutAdapter.LayType("     val/var <属性名>: <类型> by <表达式>"))
        data.add(ContentLayoutAdapter.LayType("     在 by 后面的表达式是该 委托"))
        data.add(ContentLayoutAdapter.LayType("     属性的委托不必实现任何的接口，但是需要提供一个 getValue() 函数（与 setValue()——对于 var 属性）"))

        data.add(ContentLayoutAdapter.LayType("♦️  标准委托"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 标准库为几种有用的委托提供了工厂方法。"))
        data.add(ContentLayoutAdapter.LayType("     - 延迟属性 Lazy"))
        data.add(ContentLayoutAdapter.LayType("         默认情况下，对于 lazy 属性的求值是同步锁的（synchronized）"))
        data.add(ContentLayoutAdapter.LayType("         多个线程可以同时执行，LazyThreadSafetyMode.PUBLICATION 作为参数传递给 lazy() 函数"))
        data.add(ContentLayoutAdapter.LayType("         不会有任何线程安全的保证以及相关的开销，LazyThreadSafetyMode.NONE 作为参数传递给 lazy() 函数"))
        data.add(ContentLayoutAdapter.LayType("     - 可观察属性 Observable 观察"))
        data.add(ContentLayoutAdapter.LayType("         Delegates.observable() 接受两个参数：初始值与修改时处理程序"))
        data.add(ContentLayoutAdapter.LayType("         处理程序（在赋值后执行）: 三个参数：被赋值的属性、旧值与新值"))
        data.add(ContentLayoutAdapter.LayType("     - 可观察属性 vetoable() “否决”"))

        data.add(ContentLayoutAdapter.LayType("♦️  把属性储存在映射中"))
        data.add(ContentLayoutAdapter.LayType("     一个常见的用例是在一个映射（map）里存储属性的值。"))

        data.add(ContentLayoutAdapter.LayType("♦️ 局部委托属性"))
        data.add(ContentLayoutAdapter.LayType("     局部变量声明为委托属性。 "))

        data.add(ContentLayoutAdapter.LayType("♦️ 属性委托要求"))
        data.add(ContentLayoutAdapter.LayType("     - 对于一个只读属性（即 val 声明的），委托必须提供一个操作符函数 getValue()，该函数具有以下参数："))
        data.add(ContentLayoutAdapter.LayType("         - thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是其超类型。"))
        data.add(ContentLayoutAdapter.LayType("         - property —— 必须是类型 KProperty<*> 或其超类型。"))
        data.add(ContentLayoutAdapter.LayType("         etValue() 必须返回与属性相同的类型（或其子类型）。"))
        data.add(ContentLayoutAdapter.LayType("     - 对于一个可变属性（即 var 声明的），委托必须额外提供一个操作符函数 setValue()"))
        data.add(ContentLayoutAdapter.LayType("         - thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是其超类型。"))
        data.add(ContentLayoutAdapter.LayType("         - property —— 必须是类型 KProperty<*> 或其超类型。"))
        data.add(ContentLayoutAdapter.LayType("         - value — 必须与属性类型相同（或者是其超类型）。"))
        data.add(ContentLayoutAdapter.LayType("         etValue() 必须返回与属性相同的类型（或其子类型）。"))
        data.add(ContentLayoutAdapter.LayType("      getValue() 或/与 setValue() 函数可以通过委托类的成员函数提供或者由扩展函数提供。"))
        data.add(ContentLayoutAdapter.LayType("      当你需要委托属性到原本未提供的这些函数的对象时后者会更便利。 两函数都需要用 operator 关键字来进行标记。"))

        data.add(ContentLayoutAdapter.LayType("♦️ 翻译规则"))

        data.add(ContentLayoutAdapter.LayType("♦️ 提供委托"))
        data.add(ContentLayoutAdapter.LayType("     通过定义 provideDelegate 操作符，可以扩展创建属性实现所委托对象的逻辑。"))

        data.add(ContentLayoutAdapter.LayType("     provideDelegate 的参数与 getValue 相同："))
        data.add(ContentLayoutAdapter.LayType("     - thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型；"))
        data.add(ContentLayoutAdapter.LayType("     - property —— 必须是类型 KProperty<*> 或其超类型。"))
        data.add(ContentLayoutAdapter.LayType("     provideDelegate 方法只影响辅助属性的创建，并不会影响为 getter 或 setter 生成的代码。"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        println(brand)
        brand = "KOTLIN"
        println(brand)

        count ++

        //属性储存在映射中
        val user = User(mapOf(
            "name" to "John Doe",
            "age"  to 25
        ))
        println(user.name)
        println(user.age)
        //局部委托属性
        partExample(false)
        partExample(true)
    }

//    class ResourceDelegate<T> : ReadOnlyProperty<MyUI, T> {
//        override fun getValue(thisRef: MyUI, property: KProperty<*>): T { ... }
//    }
//
//    class ResourceLoader<T>(id: ResourceID<T>) {
//        operator fun provideDelegate(
//            thisRef: MyUI,
//            prop: KProperty<*>
//        ): ReadOnlyProperty<MyUI, T> {
//            checkProperty(thisRef, prop.name)
//            // 创建委托
//            return ResourceDelegate()
//        }
//
//        private fun checkProperty(thisRef: MyUI, name: String) { …… }
//    }
//
//    class MyUI {
//        fun <T> bindResource(id: ResourceID<T>): ResourceLoader<T> { …… }
//
//        val image by bindResource(ResourceID.image_id)
//        val text by bindResource(ResourceID.text_id)
//    }

    //源码中标准的例子
    interface ReadOnlyProperty<in R, out T> {
        operator fun getValue(thisRef: R, property: KProperty<*>): T
    }

    interface ReadWriteProperty<in R, T> {
        operator fun getValue(thisRef: R, property: KProperty<*>): T
        operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
    }

    //局部委托属性
    fun partExample(isUse: Boolean){
        val language by lazy {
            println("this is init")
            "Kotlin"
        }
        if(isUse)
            println("this language is $language") //只有isUse为true时，language才会初始化
    }

    //属性储存在映射中
    class User(val map: Map<String, Any?>) {
        val name: String by map
        val age: Int     by map
    }
    class MutableUser(val map: MutableMap<String, Any?>) {
        var name: String by map
        var age: Int     by map
    }

    //可观察属性 vetoable()
    var second : Int by Delegates.vetoable(59, {
        prop, old, new -> new <= 59
    })

    //可观察属性 Observable
    var count : Int by Delegates.observable(0){
        prop, old, new -> println("$old is covered by $new")
    }

    //lazy
    val language : String by lazy {
        println("lazy language")
        "english"
    }

    //val/var <属性名>: <类型> by <表达式>
    var brand : String by NamePlate()

    class NamePlate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, this '${property.name}' is 'JAVA' !"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }
}