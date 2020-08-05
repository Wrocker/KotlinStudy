package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 集合转换
 */
class TransformationsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.transformations
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  映射"))
        data.add(ContentLayoutAdapter.LayType("     映射 转换从另一个集合的元素上的函数结果创建一个集合"))
        data.add(ContentLayoutAdapter.LayType("     基本的映射函数是 map()"))
        data.add(ContentLayoutAdapter.LayType("     _它将给定的 lambda 函数应用于每个后续元素，并返回 lambda 结果列表。 结果的顺序与元素的原始顺序相同。"))
        data.add(ContentLayoutAdapter.LayType("     _如需应用还要用到元素索引作为参数的转换，请使用 mapIndexed()。"))
        data.add(ContentLayoutAdapter.LayType("     如果转换在某些元素上产生 null 值"))
        data.add(ContentLayoutAdapter.LayType("     _则可以通过调用 mapNotNull() 函数取代 map() 或 mapIndexedNotNull() 取代 mapIndexed() 来从结果集中过滤掉 null 值。"))
        data.add(ContentLayoutAdapter.LayType("     映射转换时，有两个选择：转换键，使值保持不变，反之亦然。 "))
        data.add(ContentLayoutAdapter.LayType("     _要将指定转换应用于键，请使用 mapKeys()；反过来，mapValues() 转换值。"))

        data.add(ContentLayoutAdapter.LayType("♦️  双路合并"))
        data.add(ContentLayoutAdapter.LayType("     要将指定转换应用于键，请使用 mapKeys()；反过来，mapValues() 转换值。"))
        data.add(ContentLayoutAdapter.LayType("♦️  接口中的属性"))
        data.add(ContentLayoutAdapter.LayType("     一个类或者对象可以实现一个或多个接口。"))
        data.add(ContentLayoutAdapter.LayType("♦️  接口继承"))
        data.add(ContentLayoutAdapter.LayType("♦️  解决覆盖冲突"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = setOf(1, 2, 3)
        //map()对元素进行操作
        println(numbers.map { it * 3 })
        //mapIndexed() 对元素和位置进行操作
        println(numbers.mapIndexed { idx, value -> value * idx })

        //对null值对处理
        println(numbers.mapNotNull { if ( it == 2) null else it * 3 })
        println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

        //转换键
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        println(numbersMap.mapKeys { it.key.toUpperCase() })
        println(numbersMap.mapValues { it.value + it.key.length })
    }
}