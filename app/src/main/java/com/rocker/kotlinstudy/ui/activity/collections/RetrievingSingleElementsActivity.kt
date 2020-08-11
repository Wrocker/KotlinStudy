package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 集合 取单个元素
 */
class RetrievingSingleElementsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.retrievingSingleElements
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  按位置取 elementAt()"))
        data.add(ContentLayoutAdapter.LayType("     elementAt():第一个元素的位置是 0，最后一个元素的位置是 (size - 1)"))
        data.add(ContentLayoutAdapter.LayType("     elementAt() 对于不提供索引访问或非静态已知提供索引访问的集合很有用。"))
        data.add(ContentLayoutAdapter.LayType("     检索集合的第一个和最后一个元素：first() 和 last()"))
        data.add(ContentLayoutAdapter.LayType("     elementAt() 避免在检索位置不存在的元素时出现异常"))
        data.add(ContentLayoutAdapter.LayType("     - 当指定位置超出集合范围时，elementAtOrNull() 返回 null"))
        data.add(ContentLayoutAdapter.LayType("     - elementAtOrElse() 还接受一个 lambda 表达式，该表达式能将一个 Int 参数映射为一个集合元素类型的实例。 "))
        data.add(ContentLayoutAdapter.LayType("♦️  按条件取 first()/last()"))
        data.add(ContentLayoutAdapter.LayType("     first() 和 last() 还可以让你在集合中搜索与给定谓词匹配的元素"))
        data.add(ContentLayoutAdapter.LayType("     当你使用测试集合元素的谓词调用 first() 时，你会得到对其调用谓词产生 true 的第一个元素"))
        data.add(ContentLayoutAdapter.LayType("     如果没有元素与谓词匹配，两个函数都会抛异常"))
        data.add(ContentLayoutAdapter.LayType("     firstOrNull() 和 lastOrNull()：如果找不到匹配的元素，它们将返回 null。"))
        data.add(ContentLayoutAdapter.LayType("     find()/findLast()代替first()/last() "))
        data.add(ContentLayoutAdapter.LayType("♦️  随机取元素 random() "))
        data.add(ContentLayoutAdapter.LayType("♦️  检测存在与否 contains()"))
        data.add(ContentLayoutAdapter.LayType("     如果存在一个集合元素等于（equals()）函数参数，那么它返回 true"))
        data.add(ContentLayoutAdapter.LayType("     你可以使用 in 关键字以操作符的形式调用 contains()"))
        data.add(ContentLayoutAdapter.LayType("     containsAll() : 检查多个实例的存在"))
        data.add(ContentLayoutAdapter.LayType("     isEmpty() 和 isNotEmpty() 来检查集合中是否存在元素"))
        data.add(ContentLayoutAdapter.LayType("♦️  检测存在与否"))
        data.add(ContentLayoutAdapter.LayType("       containsAll()"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = linkedSetOf("one", "two", "three", "four", "five")
        println(numbers.elementAt(3))

        val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
        println(numbersSortedSet.elementAt(0)) // 元素以升序存储

        //异常处理
        println(numbers.elementAtOrNull(5))
        println(numbers.elementAtOrElse(5) { index -> "The value for index $index is undefined"})

        println(numbers.first()) //第一个
        println(numbers.last()) //最后一个
        //first/last谓词 条件 ,没有满足条件的会抛异常
        println(numbers.first { it.length > 3 })
        println(numbers.last { it.startsWith("f") })
        //异常返回null
        println(numbers.firstOrNull { it.length > 6 })

        //find代替first/last
        println(numbers.find { it.length > 3 })
        println(numbers.findLast { it.length > 6 })

        //随即取值
        println(numbers.random())

        //是否包含某元素
        println(numbers.contains("four"))
        println("zero" in numbers)
        //是否包含多个元素
        println(numbers.containsAll(listOf("four", "two")))
        println(numbers.containsAll(listOf("one", "zero")))

        //检查是否存在元素
        println(numbers.isEmpty())
        println(numbers.isNotEmpty())

        val empty = emptyList<String>()
        println(empty.isEmpty())
        println(empty.isNotEmpty())
    }
}