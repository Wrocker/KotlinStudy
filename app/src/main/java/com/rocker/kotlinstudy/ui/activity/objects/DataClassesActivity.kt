package com.rocker.kotlinstudy.ui.activity.objects

import android.util.Log
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 数据类
 */
class DataClassesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.dataClasses
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  data修饰的类"))
        data.add(ContentLayoutAdapter.LayType("     编译器自动从主构造函数中声明的所有属性导出以下成员"))
        data.add(ContentLayoutAdapter.LayType("     - equals()/hashCode() 对；"))
        data.add(ContentLayoutAdapter.LayType("     - toString() 格式是 \"User(name=John, age=42)\"；"))
        data.add(ContentLayoutAdapter.LayType("     - componentN() 函数 按声明顺序对应于所有属性；")) //todo 解构声明
        data.add(ContentLayoutAdapter.LayType("     - copy() 函数；"))
        data.add(ContentLayoutAdapter.LayType("♦️  为了确保所生成代码的一致性和有意义的行为，数据类必须满足以下要求"))
        data.add(ContentLayoutAdapter.LayType("     - 主构造函数需要至少有一个参数；"))
        data.add(ContentLayoutAdapter.LayType("     - 主构造函数的所有参数需要标记为 val 或 var；"))
        data.add(ContentLayoutAdapter.LayType("     - 数据类不能是抽象、开放、密封或者内部的；"))
        data.add(ContentLayoutAdapter.LayType("     - （在1.1之前）数据类只能实现接口。"))
        data.add(ContentLayoutAdapter.LayType("♦️  关于成员继承，成员生成遵循以下规则："))
        data.add(ContentLayoutAdapter.LayType("     - 如果在数据类体中有显式实现 equals()、 hashCode() 或者 toString()，或者这些函数在父类中有 final 实现，那么不会生成这些函数，而会使用现有函数；"))
        data.add(ContentLayoutAdapter.LayType("     - 如果超类型具有 open 的 componentN() 函数并且返回兼容的类型， 那么会为数据类生成相应的函数，并覆盖超类的实现。如果超类型的这些函数由于签名不兼容或者是 final 而导致无法覆盖，那么会报错；"))
        data.add(ContentLayoutAdapter.LayType("     - 从一个已具 copy(……) 函数且签名匹配的类型派生一个数据类在 Kotlin 1.2 中已弃用，并且在 Kotlin 1.3 中已禁用。"))
        data.add(ContentLayoutAdapter.LayType("     - 不允许为 componentN() 以及 copy() 函数提供显式实现。"))
        data.add(ContentLayoutAdapter.LayType("     如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。 "))
        data.add(ContentLayoutAdapter.LayType("♦️  在类体中声明的属性"))
        data.add(ContentLayoutAdapter.LayType("     对于那些自动生成的函数，编译器只使用在主构造函数内部定义的属性。如需在生成的实现中排除一个属性，请将其声明在类体中："))
        data.add(ContentLayoutAdapter.LayType("♦️  复制"))
        data.add(ContentLayoutAdapter.LayType("♦️  数据类与解构声明"))
        data.add(ContentLayoutAdapter.LayType("     为数据类生成的 Component 函数 使它们可在解构声明中使用"))
        data.add(ContentLayoutAdapter.LayType("♦️  标准数据类"))
        data.add(ContentLayoutAdapter.LayType("     标准库提供了 Pair 与 Triple。尽管在很多情况下具名数据类是更好的设计选择， 因为它们通过为属性提供有意义的名称使代码更具可读性。"))

        adapter.data = data
        adapter.notifyDataSetChanged()
        User()

        //在 toString()、 equals()、 hashCode() 以及 copy() 的实现中只会用到 name 属性，并且只有一个 component 函数 component1()。虽然两个 Person 对象可以有不同的年龄，但它们会视为相等。
        val person1 = Person("张三")
        val person2 = Person("张三")
        person1.age = 10
        person2.age = 11
        Log.e("____", "is Equal = ${person1 == person2}") // true
        //复制
        val oldPerson1 = person1.copyTemp(name = "aw", age = 1)
        val oldPerson2 = person2.copyTemp(age = 1)
        //todo 解构声明
        val jane = User("Jane", 35)
        val (name, age) = jane
        println("$name, $age years of age") // 输出 "Jane, 35 years of age"

        //pair
        val pair = Pair(0x111, person1)
        //triple
        val triple = Triple(0x112, person2, oldPerson2)

        Log.e("____", jane.toString()) //User(name=Jane, age=35)
        Log.e("____", person1.toString()) //张三 is 10 years old
    }

    data class User(val name: String = "", val age: Int = 0) //如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。

    data class Person(val name: String) {
        var age: Int = 0 //生成中排除age

        //复制代码类似这样，实际可转成java看
        fun copyTemp(name: String = this.name, age: Int = this.age) = User(name, age)

        override fun toString(): String {
            return "$name is $age years old"
        }
    }
}