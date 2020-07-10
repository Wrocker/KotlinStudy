package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import java.io.File

/**
 * 类型别名
 */
class TypeAliasesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.typeAliases
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  类型别名为现有类型提供替代名称。 "))
        data.add(ContentLayoutAdapter.LayType("     如果类型名称太长，你可以另外引入较短的名称，并使用新的名称替代原类型名。"))
        data.add(ContentLayoutAdapter.LayType("     它有助于缩短较长的泛型类型。"))
        data.add(ContentLayoutAdapter.LayType("     - 可以为函数类型提供另外的别名"))
        data.add(ContentLayoutAdapter.LayType("     - 可以为内部类和嵌套类创建新名称"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        //别名
        val earPhoneBrand = EarPhoneBrand(3){EarPhone.Brand()}

    }

}


class EarPhone{
    class Brand
}

typealias EarPhoneBrand = Array<EarPhone.Brand>
typealias FileTable<K> = MutableMap<K, MutableList<File>>

//你可以为函数类型提供另外的别名：
typealias MyHandler = (Int, String, Any) -> Unit //todo 没懂
typealias Predicate<T> = (T) -> Boolean

//可以为内部类和嵌套类创建新名称：
class A {
    inner class Inner
}
class B {
    inner class Inner
}
typealias AInner = A.Inner
typealias BInner = B.Inner

//类型别名不会引入新类型。 它们等效于相应的底层类型。
// 当你在代码中添加 typealias Predicate<T> 并使用 Predicate<Int> 时，Kotlin 编译器总是把它扩展为 (Int) -> Boolean。
// 因此，当你需要泛型函数类型时，你可以传递该类型的变量，反之亦然

fun foo(p: Predicate<Int>) = p(42)

fun main() {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // 输出 "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // 输出 "[1]"
}