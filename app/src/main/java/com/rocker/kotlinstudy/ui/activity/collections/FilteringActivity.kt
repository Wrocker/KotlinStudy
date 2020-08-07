package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 集合 - 过滤
 */
class FilteringActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.filtering
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  过滤条件由 谓词"))
        data.add(ContentLayoutAdapter.LayType("     — 接受一个集合元素并且返回布尔值的 lambda 表达式：true 说明给定元素与谓词匹配，false 则表示不匹配。"))
        data.add(ContentLayoutAdapter.LayType("♦️  按谓词过滤"))
        data.add(ContentLayoutAdapter.LayType("     基本的过滤函数是 filter()。"))
        data.add(ContentLayoutAdapter.LayType("     filter() 中的谓词只能检查元素的值"))
        data.add(ContentLayoutAdapter.LayType("     filterIndexed() 在过滤中使用元素在集合中的位置 "))
        data.add(ContentLayoutAdapter.LayType("     filterNot() 使用否定条件来过滤集合"))
        data.add(ContentLayoutAdapter.LayType("     filterIsInstance() 返回给定类型的集合元素 :在一个 List<Any> 上被调用时，filterIsInstance<T>() 返回一个 List<T>，从而让你能够在集合元素上调用 T 类型的函数"))
        data.add(ContentLayoutAdapter.LayType("     filterNotNull() 返回所有的非空元素 :在一个 List<T?> 上被调用时，filterNotNull() 返回一个 List<T: Any>，从而让你能够将所有元素视为非空对象"))
        data.add(ContentLayoutAdapter.LayType("♦️  划分"))
        data.add(ContentLayoutAdapter.LayType("      partition() – 通过一个谓词过滤集合并且将不匹配的元素存放在一个单独的列表中"))
        data.add(ContentLayoutAdapter.LayType("      得到一个 List 的 Pair 作为返回值：第一个列表包含与谓词匹配的元素并且第二个列表包含原始集合中的所有其他元素。"))
        data.add(ContentLayoutAdapter.LayType("♦️  检验谓词"))
        data.add(ContentLayoutAdapter.LayType("     有些函数只是针对集合元素简单地检测一个谓词"))
        data.add(ContentLayoutAdapter.LayType("     - 如果至少有一个元素匹配给定谓词，那么 any() 返回 true。"))
        data.add(ContentLayoutAdapter.LayType("     - 如果没有元素与给定谓词匹配，那么 none() 返回 true。"))
        data.add(ContentLayoutAdapter.LayType("     - 如果所有元素都匹配给定谓词，那么 all() 返回 true。注意，在一个空集合上使用任何有效的谓词去调用 all() 都会返回 true 。这种行为在逻辑上被称为 vacuous truth。"))
        data.add(ContentLayoutAdapter.LayType("     any() 和 none() 也可以不带谓词使用：在这种情况下它们只是用来检查集合是否为空。"))
        data.add(ContentLayoutAdapter.LayType("     如果集合中有元素，any() 返回 true，否则返回 false；none() 则相反。"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //filter()
        val numbers = listOf("one", "two", "three", "four")
        val longerThan3 = numbers.filter { it.length > 3 }
        println(longerThan3)

        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10}
        println(filteredMap)

        //filterIndexed()
        val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) && (s.length < 5)  }
        //filterNot()
        val filteredNot = numbers.filterNot { it.length <= 3 }

        println(filteredIdx)
        println(filteredNot)

        //filterIsInstance()
        val nullNumbers = listOf(null, 1, "two", 3.0, "four")
        println("All String elements in upper case:")
        nullNumbers.filterIsInstance<String>().forEach {
            println(it.toUpperCase())
        }
        //filterNotNull
        val stringNumbers = listOf(null, "one", "two", null)
        stringNumbers.filterNotNull().forEach {
            println(it.length)   // 对可空的 String 来说长度不可用
        }

        //partition() 得到一个 List 的 Pair 作为返回值：第一个列表包含与谓词匹配的元素并且第二个列表包含原始集合中的所有其他元素。
        val (match, rest) = numbers.partition { it.length > 3 }

        println(match)
        println(rest)

        //检验谓词
        println(numbers.any { it.endsWith("e") })
        println(numbers.none { it.endsWith("a") })
        println(numbers.all { it.endsWith("e") })

        println(emptyList<Int>().all { it > 5 })

        val empty = emptyList<String>()

        println(numbers.any())
        println(empty.any())

        println(numbers.none())
        println(empty.none())
    }
}