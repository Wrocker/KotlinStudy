package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 集合操作概述
 */
class OperationsOverviewActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.operationsOverview
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  扩展与成员函数"))
        data.add(ContentLayoutAdapter.LayType("     集合操作在标准库中以两种方式声明：集合接口的成员函数和扩展函数。"))
        data.add(ContentLayoutAdapter.LayType("     - 成员函数定义了对于集合类型是必不可少的操作。"))
        data.add(ContentLayoutAdapter.LayType("       创建自己的集合接口实现时，必须实现其成员函数。 "))
        data.add(ContentLayoutAdapter.LayType("       为了使新实现的创建更加容易，请使用标准库中集合接口的框架实现：AbstractCollection、AbstractList、AbstractSet、AbstractMap 及其相应可变抽象类。"))
        data.add(ContentLayoutAdapter.LayType("     - 其他集合操作被声明为扩展函数。这些是过滤、转换、排序和其他集合处理功能。"))
        data.add(ContentLayoutAdapter.LayType("♦️  公共操作"))
        data.add(ContentLayoutAdapter.LayType("     公共操作可用于只读集合与可变集合。 常见操作:"))
        data.add(ContentLayoutAdapter.LayType("     - 集合转换"))
        data.add(ContentLayoutAdapter.LayType("     - 集合过滤"))
        data.add(ContentLayoutAdapter.LayType("     - plus 与 minus 操作符"))
        data.add(ContentLayoutAdapter.LayType("     - 分组"))
        data.add(ContentLayoutAdapter.LayType("     - 取集合的一部分"))
        data.add(ContentLayoutAdapter.LayType("     - 取单个元素"))
        data.add(ContentLayoutAdapter.LayType("     - 集合排序"))
        data.add(ContentLayoutAdapter.LayType("     - 集合聚合操作"))
        data.add(ContentLayoutAdapter.LayType("     这些页面中描述的操作将返回其结果，而不会影响原始集合。"))

        data.add(ContentLayoutAdapter.LayType("     对于某些集合操作，有一个选项可以指定 目标 对象"))
        data.add(ContentLayoutAdapter.LayType("     对于执行带有目标的操作，有单独的函数，其名称中带有 To 后缀，例如，用 filterTo() 代替 filter() 以及用 associateTo() 代替 associate()。"))
        data.add(ContentLayoutAdapter.LayType("     目标是一个可变集合，该函数将其结果项附加到该可变对象中，而不是在新对象中返回它们。 "))
        data.add(ContentLayoutAdapter.LayType("     为了方便起见，这些函数将目标集合返回了，因此您可以在函数调用的相应参数中直接创建它 "))
        data.add(ContentLayoutAdapter.LayType("♦️  写操作"))
        data.add(ContentLayoutAdapter.LayType("     对于可变集合，还存在可更改集合状态的 写操作 "))
        data.add(ContentLayoutAdapter.LayType("     对于某些操作，有成对的函数可以执行相同的操作：一个函数就地应用该操作，另一个函数将结果作为单独的集合返回。 "))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //操作将返回其结果，而不会影响原始集合。
        val numbers = listOf("one", "two", "three", "four")
        numbers.filter { it.length > 3 }  // `numbers` 没有任何改变，结果丢失
        println("numbers are still $numbers")
        val longerThan3 = numbers.filter { it.length > 3 } // 结果存储在 `longerThan3` 中
        println("numbers longer than 3 chars are $longerThan3")
        //将对象放在目标中
        val filterResults = mutableListOf<String>()  // 目标对象
        numbers.filterTo(filterResults) { it.length > 3 }
        numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
        println(filterResults) // 包含两个操作的结果
        //返回了目标
        val result = numbers.mapTo(HashSet()) { it.length }

        //成对的写操作
        val mutableNumbers = mutableListOf("one", "two", "three", "four")
        val sortedNumbers = mutableNumbers.sorted()
        println(mutableNumbers == sortedNumbers)  // false
        mutableNumbers.sort()
        println(mutableNumbers == sortedNumbers)  // true
    }
}