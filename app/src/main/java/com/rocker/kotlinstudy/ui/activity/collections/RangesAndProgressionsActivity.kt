package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 区间和数列
 */
class RangesAndProgressionsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.rangesAndProgressions
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  rangeTo"))
        data.add(ContentLayoutAdapter.LayType("     通过调用 kotlin.ranges 包中的 rangeTo() 函数及其操作符形式的 .. 轻松地创建两个值的区间"))
        data.add(ContentLayoutAdapter.LayType("     通常，rangeTo() 会辅以 in 或 !in 函数"))
        data.add(ContentLayoutAdapter.LayType("     整数类型区间（IntRange、LongRange、CharRange）还有一个拓展特性：可以对其进行迭代"))
        data.add(ContentLayoutAdapter.LayType("     这些区间也是相应整数类型的等差数列。"))
        data.add(ContentLayoutAdapter.LayType("     反向迭代数字，请使用 downTo 函数"))
        data.add(ContentLayoutAdapter.LayType("     通过任意步长（不一定为 1 ）迭代数字。 这是通过 step 函数完成的。"))
        data.add(ContentLayoutAdapter.LayType("     迭代不包含其结束元素的数字区间，请使用 until 函数："))

        data.add(ContentLayoutAdapter.LayType("♦️  区间"))
        data.add(ContentLayoutAdapter.LayType("     区间的主要操作是 contains，通常以 in 与 !in 操作符的形式使用。"))
        data.add(ContentLayoutAdapter.LayType("     要为类创建一个区间，请在区间起始值上调用 rangeTo() 函数，并提供结束值作为参数。 "))
        data.add(ContentLayoutAdapter.LayType("     rangeTo() 通常以操作符 .. 形式调用。"))

        data.add(ContentLayoutAdapter.LayType("♦️  数列"))
        data.add(ContentLayoutAdapter.LayType("     如上个示例所示，整数类型的区间（例如 Int、Long 与 Char）可视为等差数列。"))
        data.add(ContentLayoutAdapter.LayType("     在 Kotlin 中，这些数列由特殊类型定义：IntProgression、LongProgression 与 CharProgression。"))
        data.add(ContentLayoutAdapter.LayType("     数列具有三个基本属性：first 元素、last 元素和一个非零的 step。"))
        data.add(ContentLayoutAdapter.LayType("     通过迭代数列隐式创建区间时，此数列的 first 与 last 元素是区间的端点，step 为 1 "))
        data.add(ContentLayoutAdapter.LayType("     数列的 last 元素是这样计算的 "))
        data.add(ContentLayoutAdapter.LayType("     - 对于正步长：不大于结束值且满足 (last - first) % step == 0 的最大值。"))
        data.add(ContentLayoutAdapter.LayType("     - 对于负步长：不小于结束值且满足 (last - first) % step == 0 的最小值。"))
        data.add(ContentLayoutAdapter.LayType("     因此，last 元素并非总与指定的结束值相同。"))
        data.add(ContentLayoutAdapter.LayType("     数列实现 Iterable<N>，其中 N 分别是 Int、Long 或 Char，因此可以在各种集合函数（如 map、filter 与其他）中使用它们。"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple(3)
    }

    private fun simple(number: Int) {
        if (number in 1..4) {  // 等同于 1 <= i && i <= 4
            print(number)
        }
        println()
        println("迭代")
        //迭代
        for (i in 1..4)
            print(i)
        println()
        //反向迭代
        println("反向迭代")
        for (i in 4 downTo 1) print(i)
        //通过任意步长迭代
        println()
        println("通过任意步长迭代")
        for (i in 1..8 step 2) print(i)
        println()
        for (i in 8 downTo 1 step 2) print(i)
        //不包含结尾
        println()
        println("不包含结尾")
        for (i in 1 until 10) {       // i in [1, 10), 10被排除
            print(i)
        }

        println()
//        //区间 todo 没懂
//        val versionRange = Version(1, 11)..Version(1, 30)
//        println(Version(0, 9) in versionRange)
//        println(Version(1, 20) in versionRange)

        println()
        //迭代数列隐式创建区间 此数列的 first 与 last 元素是区间的端点，step 为 1
        for (i in 1..10) print(i)
        //数列实现 Iterable<N>，其中 N 分别是 Int、Long 或 Char，因此可以在各种集合函数（如 map、filter 与其他）中使用它们。
        println()
        println((1..10).filter { it % 2 == 0 })
    }

//    inner class Version(val build: Int, val version: Int)
}