package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 集合写操作
 */
class WriteOperationsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.writeOperations
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("  ️  MutableCollection可变集合支持更改集合内容的操作"))
        data.add(ContentLayoutAdapter.LayType("♦️  添加元素"))
        data.add(ContentLayoutAdapter.LayType("     add() 添加指定对象到集合的末尾"))
        data.add(ContentLayoutAdapter.LayType("     addAll() 将参数对象的每个元素添加到列表或集合中，参数可以是 Iterable、Sequence 或 Array"))
        data.add(ContentLayoutAdapter.LayType("     plusAssign (+=) 添加元素"))
        data.add(ContentLayoutAdapter.LayType("♦️  删除元素"))
        data.add(ContentLayoutAdapter.LayType("     remove() 接受元素值，并删除该值的一个匹配项"))
        data.add(ContentLayoutAdapter.LayType("     forEach() 函数，可自动迭代集合并为每个元素执行给定的代码"))
        data.add(ContentLayoutAdapter.LayType("     一次删除多个元素"))
        data.add(ContentLayoutAdapter.LayType("     - removeAll() 移除参数集合中存在的所有元素。 可以用谓词作为参数来调用它(true)"))
        data.add(ContentLayoutAdapter.LayType("     - retainAll() 与 removeAll() 相反：它移除除参数集合中的元素之外的所有元素。"))
        data.add(ContentLayoutAdapter.LayType("     - clear() 从列表中移除所有元素并将其置空。"))
        data.add(ContentLayoutAdapter.LayType("     minusAssign 运算符 -= "))
        data.add(ContentLayoutAdapter.LayType("♦️  List 迭代器"))
        data.add(ContentLayoutAdapter.LayType("     minusAssign "))
        data.add(ContentLayoutAdapter.LayType("     具有双向迭代的能力意味着 ListIterator 在到达最后一个元素后仍可以使用。"))
        data.add(ContentLayoutAdapter.LayType("♦️  可变迭代器"))
        data.add(ContentLayoutAdapter.LayType("      MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()"))
        data.add(ContentLayoutAdapter.LayType("      MutableListIterator 还可以在迭代列表时插入和替换元素。"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = mutableListOf(1, 2, 3, 4)
        //单个添加
        numbers.add(5)
        println(numbers)
        //批量添加
        numbers.addAll(arrayOf(7, 8))
        println(numbers)
        //指定位置批量添加
        numbers.addAll(2, setOf(3, 4))
        println(numbers)
        //+= 运算符
        val stringNumbers = mutableListOf("one", "two")
        stringNumbers += "three"
        println(stringNumbers)
        stringNumbers += listOf("four", "five")
        println(stringNumbers)

        //删除
        numbers.remove(3)                    // 删除了第一个 `3`
        println(numbers)
        numbers.remove(5)                    // 什么都没删除
        println(numbers)
        //批量删除
        numbers.removeAll { it <= 1 }
        println(numbers)
        numbers.retainAll { it >= 3 }
        println(numbers)

        val numbersSet = mutableSetOf("one", "two", "three", "three", "four")
        numbersSet.removeAll(setOf("one", "two"))
        println(numbersSet)
        //-=操作符
        numbersSet -= "three"
        println(numbers)
        numbersSet -= listOf("four", "five")
        //numbers -= listOf("four")    // 与上述相同
        println(numbers)

        //清空
        numbersSet.clear()
        println(numbersSet)
    }
}