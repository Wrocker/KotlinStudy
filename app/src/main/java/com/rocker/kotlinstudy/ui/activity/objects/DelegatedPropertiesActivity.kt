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


        adapter.data = data
        adapter.notifyDataSetChanged()

        println(brand)
        brand = "KOTLIN"
        println(brand)

        count ++

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