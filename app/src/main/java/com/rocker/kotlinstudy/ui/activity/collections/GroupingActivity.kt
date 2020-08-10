package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 分组
 */
class GroupingActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.grouping
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  基本函数 groupBy() 使用一个 lambda 函数并返回一个 Map。"))
        data.add(ContentLayoutAdapter.LayType("     在此 Map 中，每个键都是 lambda 结果，而对应的值是返回此结果的元素 List。"))
        data.add(ContentLayoutAdapter.LayType("     可以使用第二个 lambda 参数（值转换函数）调用 groupBy()。"))
        data.add(ContentLayoutAdapter.LayType("     在带有两个 lambda 的 groupBy() 结果 Map 中，由 keySelector 函数生成的键映射到值转换函数的结果，而不是原始元素。"))

        data.add(ContentLayoutAdapter.LayType("♦️  Grouping"))
        data.add(ContentLayoutAdapter.LayType("     如果要对元素进行分组，然后一次将操作应用于所有分组，请使用 groupingBy() 函数。"))
        data.add(ContentLayoutAdapter.LayType("     返回一个 Grouping 类型的实例。 "))
        data.add(ContentLayoutAdapter.LayType("     通过 Grouping 实例，可以以一种惰性的方式将操作应用于所有组：这些分组实际上是刚好在执行操作前构建的。"))
        data.add(ContentLayoutAdapter.LayType("     Grouping 支持以下操作："))
        data.add(ContentLayoutAdapter.LayType("     - eachCount() 计算每个组中的元素"))
        data.add(ContentLayoutAdapter.LayType("     - fold() 与 reduce() 对每个组分别执行 fold 与 reduce 操作，作为一个单独的集合并返回结果。"))
        data.add(ContentLayoutAdapter.LayType("     - aggregate() 随后将给定操作应用于每个组中的所有元素并返回结果。 这是对 Grouping 执行任何操作的通用方法。当折叠或缩小不够时，可使用它来实现自定义操作。"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = listOf("one", "two", "three", "four", "five", "six")

        println(numbers.groupBy { it.first().toUpperCase() }) //返回map，key是处理之后的，value是原始参数的集合。key相同则会氛围一组
        //keySelector 分组  valueTransform转换
        println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))

        println(numbers.groupingBy { it.first() }.eachCount()) //显示每个分组的元素数量
    }
}