package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * plus与minus操作符
 */
class PlusAndMinusOperatorsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.plusAndMinusOperators
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  为集合定义了 plus (+) 和 minus (-) 操作符。"))
        data.add(ContentLayoutAdapter.LayType("     它们把一个集合作为第一个操作数；第二个操作数可以是一个元素或者是另一个集合。 返回值是一个新的只读集合"))
        data.add(ContentLayoutAdapter.LayType("     - plus 的结果包含原始集合 和 第二个操作数中的元素。"))
        data.add(ContentLayoutAdapter.LayType("     - minus 的结果包含原始集合中的元素，但第二个操作数中的元素 除外。如果第二个操作数是一个元素，那么 minus 移除其在原始集合中的 第一次 出现；如果是一个集合，那么移除其元素在原始集合中的 所有 出现。"))
        data.add(ContentLayoutAdapter.LayType("♦️  集合定义了广义赋值操作符 plusAssign (+=) 和 minusAssign (-=)"))
        data.add(ContentLayoutAdapter.LayType("     对于只读集合，它们实际上使用 plus 或者 minus 操作符并尝试将结果赋值给同一变量"))
        data.add(ContentLayoutAdapter.LayType("     它们仅在由 var 声明的只读集合中可用"))
        data.add(ContentLayoutAdapter.LayType("     对于可变集合，如果它是一个 val，那么它们会修改集合。"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = listOf("one", "two", "three", "four", "five", "five")

        val plusList = numbers + "five"
        val plusSetList = numbers + listOf("five", "six")
        val minusList = numbers - "five" //删除第一个five
        val minusSetList = numbers - listOf("five", "six") //删除所有five
        println(plusList)
        println(plusSetList)
        println(minusList)
        println(minusSetList)

        var muteNumbers = listOf("one", "two", "three", "four", "five", "five")
        muteNumbers -= "five"
        println(muteNumbers)

//        var muteNumbers = mutableListOf("one", "two", "three", "four", "five", "five")
//        muteNumbers -= "five" //报错
//        println(muteNumbers)
    }
}