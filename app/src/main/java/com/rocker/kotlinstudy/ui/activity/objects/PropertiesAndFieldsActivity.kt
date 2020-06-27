package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 属性和字段
 */
class PropertiesAndFieldsActivity : BaseLoadListActivity(){
    override fun initTitle(): Int {
        return R.string.propertiesAndFields
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦    声明属性"))
        data.add(ContentLayoutAdapter.LayType("     关键字 var 声明为可变的"))
        data.add(ContentLayoutAdapter.LayType("     关键字 val 声明为只读的"))
        data.add(ContentLayoutAdapter.LayType("     若没有类体，可省略花括号"))
        data.add(ContentLayoutAdapter.LayType("♦    Getters 与 Setters"))
        data.add(ContentLayoutAdapter.LayType("     声明属性完整的语法如下"))
        data.add(ContentLayoutAdapter.LayType("     var <propertyName>[: <PropertyType>] [= <property_initializer>]"))
        data.add(ContentLayoutAdapter.LayType("         [<getter>]"))
        data.add(ContentLayoutAdapter.LayType("         [<setter>]"))
        data.add(ContentLayoutAdapter.LayType("     其中property_initializer、getter和setter都是可选"))
        data.add(ContentLayoutAdapter.LayType("     val 修饰的属性为只读，只有getter方法"))
        data.add(ContentLayoutAdapter.LayType("     当类型能通过值推断出来时，属性类型也可省略"))
        data.add(ContentLayoutAdapter.LayType("     当类型能通过值推断出来时，属性类型也可省略"))
        data.add(ContentLayoutAdapter.LayType("♦    幕后字段"))
        data.add(ContentLayoutAdapter.LayType("♦    幕后属性"))
        data.add(ContentLayoutAdapter.LayType("♦    编译期常量"))
        data.add(ContentLayoutAdapter.LayType("     const修饰的属性 为 编译期常量,需满足如下需求"))
        data.add(ContentLayoutAdapter.LayType("     - 位于顶层或者是 object 声明 或 companion object 的一个成员"))
        data.add(ContentLayoutAdapter.LayType("     - 以 String 或原生类型值初始化"))
        data.add(ContentLayoutAdapter.LayType("     - 没有自定义 getter"))
        data.add(ContentLayoutAdapter.LayType("♦    延迟初始化属性与变量"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        userProperty()
    }

    class ChineseAddress {

        //todo 编译期常量
//        const val SUBSYSTEM_DEPRECATED_: String = "This subsystem is deprecated"
//        @Deprecated(SUBSYSTEM_DEPRECATED_) fun foo() {  }

        val country: String = "中国" //只读，不可变
        var city: String = "成都" //可变
        lateinit var lat: String //延迟初始化
        lateinit var lng: String //延迟初始化
        var name: String? = null //可为null的属性

        //var <propertyName>[: <PropertyType>] [= <property_initializer>]
        //    [<getter>]
        //    [<setter>]
        var street: String? = null
            get() = if(field == null) "no street" else field //自定义getter
            set(value) = if(value == null) field = "no street" else field = value //自定义setter （field 幕后，便于对值进行修改    ）

//        var ha: String? //报错，必须初始化
        var number = 1 //类型能推断出来，则类型也可以省略

        val isEmpty get() = lat == "0.00" //如果可以从 getter 推断出属性类型,则可省略类型

        var setterVisibility: String = "abc"
            private set // 私有setter方法，而不定义实现。

//        var setterWithAnnotation: Any? = null
//            @Inject set // 用 Inject 注解此 setter


        //幕后字段
        var counter = 0 // 注意：这个初始器直接为幕后字段赋值
            set(value) {
                if (value >= 0) field = value//field 标识符只能用在属性的访问器内。
            }

        //幕后属性
        //对于 JVM 平台：通过默认 getter 和 setter 访问私有属性会被优化， 所以本例不会引入函数调用开销。
        private var _table: Map<String, Int>? = null
        public val table: Map<String, Int> //相当于通过table属性的getter方法 对_table进行初始化
            get() {
                if (_table == null) {
                    _table = HashMap() // 类型参数已推断出
                }
                return _table ?: throw AssertionError("Set to null by another thread")
            }

    }

    fun userProperty(){
        val address = ChineseAddress()
        address.lat = "34.3535"//用名称引用 获取/设置属性
        address.lng = "132.123"
        println("this address is in ${address.country}")
        
    }
}