package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 集合排序
 */
class OrderingActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.ordering
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  集合排序"))
        data.add(ContentLayoutAdapter.LayType("     Comparable 接口的继承者定义：自然顺序"))
        data.add(ContentLayoutAdapter.LayType("     大多数内置类型是可比较的"))
        data.add(ContentLayoutAdapter.LayType("     - 数值类型使用传统的数值顺序：1 大于 0； -3.4f 大于 -5f，以此类推。"))
        data.add(ContentLayoutAdapter.LayType("     - Char 和 String 使用字典顺序： b 大于 a； world 大于 hello。"))
        data.add(ContentLayoutAdapter.LayType("     实现 compareTo() 函数定义自然顺序，compareTo() 必须将另一个具有相同类型的对象作为参数并返回一个整数值"))
        data.add(ContentLayoutAdapter.LayType("     - 正值表明接收者对象更大。"))
        data.add(ContentLayoutAdapter.LayType("     - 负值表明它小于参数。"))
        data.add(ContentLayoutAdapter.LayType("     - 0 说明对象相等。"))

        data.add(ContentLayoutAdapter.LayType("     Comparator 对任何类型实例进行排序：自定义 顺序"))
        data.add(ContentLayoutAdapter.LayType("     compareBy() 函数简化comparator的创建"))
        data.add(ContentLayoutAdapter.LayType("♦️  自然顺序"))
        data.add(ContentLayoutAdapter.LayType("     基本的函数 sorted() 和 sortedDescending() 返回集合的元素"))
        data.add(ContentLayoutAdapter.LayType("     这些函数适用于 Comparable 元素的集合。"))
        data.add(ContentLayoutAdapter.LayType("♦️  自定义顺序"))
        data.add(ContentLayoutAdapter.LayType("     按照自定义顺序排序或者对不可比较对象排序"))
        data.add(ContentLayoutAdapter.LayType("     - 可以使用函数 sortedBy() 和 sortedByDescending()"))
        data.add(ContentLayoutAdapter.LayType("       将集合元素映射为 Comparable 值的选择器函数，并以该值的自然顺序对集合排序"))
        data.add(ContentLayoutAdapter.LayType("     - 为集合排序定义自定义顺序，可以提供自己的 Comparator"))
        data.add(ContentLayoutAdapter.LayType("       调用传入 Comparator 的 sortedWith() 函数"))
        data.add(ContentLayoutAdapter.LayType("♦️  倒序"))
        data.add(ContentLayoutAdapter.LayType("     - reversed() 函数以相反的顺序检索集合，不影响原集合"))
        data.add(ContentLayoutAdapter.LayType("     - asReversed()——返回相同集合实例的一个反向视图"))
        data.add(ContentLayoutAdapter.LayType("       如果原始列表是可变的，那么其所有更改都会反映在其反向视图中，反之亦然"))
        data.add(ContentLayoutAdapter.LayType("♦️  随机顺序"))
        data.add(ContentLayoutAdapter.LayType("     shuffled() 函数返回一个包含了以随机顺序排序的集合元素的新的 List。"))
        data.add(ContentLayoutAdapter.LayType("     可以不带参数或者使用 Random 对象来调用它。"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //Comparable 比较
        println(Version(1, 2) > Version(1, 3))
        println(Version(2, 0) > Version(1, 5))
        //Comparator比较
        val numbers = listOf("one", "two", "three", "four")

        val lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }
        println(numbers.sortedWith(lengthComparator))
        println(numbers.sortedWith(compareBy { it.length }))

        //自然排序
        println("Sorted ascending: ${numbers.sorted()}")
        println("Sorted descending: ${numbers.sortedDescending()}")
        //自定义排序
        //依然以Comparable比较，根本是自然排序
        println(numbers.sortedBy { it.length })
        println(numbers.sortedByDescending { it.last() })
        //调用传入 Comparator
        println("Sorted by length ascending: ${numbers.sortedWith(compareBy { it.length })}")

        //倒序
        println(numbers.reversed())
        val reversedNumbers = numbers.asReversed()
        println(reversedNumbers)
        //随机
        println(reversedNumbers.shuffled())
        println(reversedNumbers)
        println(numbers)
    }

    class Version(private val major: Int,private val minor: Int): Comparable<Version> {
        override fun compareTo(other: Version): Int {
            return when {
                this.major != other.major -> {
                    this.major - other.major
                }
                this.minor != other.minor -> {
                    this.minor - other.minor
                }
                else -> 0
            }
        }
    }
}