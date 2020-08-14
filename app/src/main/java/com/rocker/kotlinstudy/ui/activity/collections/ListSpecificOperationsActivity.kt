package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import kotlin.math.sign

/**
 * list相关操作
 */
class ListSpecificOperationsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.listSpecificOperations
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  按索引取元素"))
        data.add(ContentLayoutAdapter.LayType("     List 支持按索引取元素的所有常用操作：elementAt() 、 first() 、 last() 与取单个元素中列出的其他操作。"))
        data.add(ContentLayoutAdapter.LayType("     通过 get() 函数或简写语法 [index] 来传递索引参数完成的。"))
        data.add(ContentLayoutAdapter.LayType("     如果 List 长度小于指定的索引，则抛出异常。 另外，还有两个函数能避免此类异常："))
        data.add(ContentLayoutAdapter.LayType("     - getOrElse() 提供用于计算默认值的函数，如果集合中不存在索引，则返回默认值。"))
        data.add(ContentLayoutAdapter.LayType("     - getOrNull() 返回 null 作为默认值。"))
        data.add(ContentLayoutAdapter.LayType("♦️  取列表的一部分"))
        data.add(ContentLayoutAdapter.LayType("     subList() 该函数将指定元素范围(左闭右开)的视图作为列表返回"))

        data.add(ContentLayoutAdapter.LayType("♦️  查找元素位置"))
        data.add(ContentLayoutAdapter.LayType("♦️  线性查找"))
        data.add(ContentLayoutAdapter.LayType("     在任何列表中，都可以使用 indexOf() 或 lastIndexOf() 函数找到元素的位置"))
        data.add(ContentLayoutAdapter.LayType("     它们返回与列表中给定参数相等的元素的第一个或最后一个位置。 如果没有这样的元素，则两个函数均返回 -1"))
        data.add(ContentLayoutAdapter.LayType("     接受谓词并搜索与之匹配的元素："))
        data.add(ContentLayoutAdapter.LayType("     - indexOfFirst() 返回与谓词匹配的第一个元素的索引，如果没有此类元素，则返回 -1"))
        data.add(ContentLayoutAdapter.LayType("     - indexOfLast() 返回与谓词匹配的最后一个元素的索引，如果没有此类元素，则返回 -1"))
        data.add(ContentLayoutAdapter.LayType("♦️  在有序列表(Comparable)中二分查找 binarySearch() "))
        data.add(ContentLayoutAdapter.LayType("     要求该列表按照一定的顺序（自然排序或函数参数中提供的另一种排序）按升序排序过。"))
        data.add(ContentLayoutAdapter.LayType("     如果存在这样的元素，则函数返回其索引；否则，将返回 (-insertionPoint - 1)"))
        data.add(ContentLayoutAdapter.LayType("     insertionPoint 为应插入此元素的索引，以便列表保持排序。 如果有多个具有给定值的元素，搜索则可以返回其任何索引"))
        data.add(ContentLayoutAdapter.LayType("♦️  Comparator 二分搜索"))

        data.add(ContentLayoutAdapter.LayType("♦️  比较函数二分搜索"))
        data.add(ContentLayoutAdapter.LayType("     使用 比较 函数的二分搜索无需提供明确的搜索值即可查找元素"))
        data.add(ContentLayoutAdapter.LayType("     它使用一个比较函数将元素映射到 Int 值，并搜索函数返回 0 的元素。"))
        data.add(ContentLayoutAdapter.LayType("     该列表必须根据提供的函数以升序排序；换句话说，比较的返回值必须从一个列表元素增长到下一个列表元素"))

        data.add(ContentLayoutAdapter.LayType("♦️  List 写操作"))
        data.add(ContentLayoutAdapter.LayType("♦️  添加"))
        data.add(ContentLayoutAdapter.LayType("      add() 或 addAll() 并提供元素插入的位置作为附加参数"))
        data.add(ContentLayoutAdapter.LayType("♦️  更新"))
        data.add(ContentLayoutAdapter.LayType("      set() 及其操作符形式 []。set() 不会更改其他元素的索引"))
        data.add(ContentLayoutAdapter.LayType("      fill() 简单地将所有集合元素的值替换为指定值"))
        data.add(ContentLayoutAdapter.LayType("♦️  删除"))
        data.add(ContentLayoutAdapter.LayType("      removeAt() 从列表中删除指定位置的元素"))
        data.add(ContentLayoutAdapter.LayType("♦️  排序"))
        data.add(ContentLayoutAdapter.LayType("      就地排序函数的名称与应用于只读列表的函数的名称相似，但没有 ed/d 后缀"))
        data.add(ContentLayoutAdapter.LayType("      - sort* 在所有排序函数的名称中代替 sorted*：sort()、sortDescending()、sortBy() 等等"))
        data.add(ContentLayoutAdapter.LayType("      - shuffle() 代替 shuffled()"))
        data.add(ContentLayoutAdapter.LayType("      - reverse() 代替 reversed()"))
        data.add(ContentLayoutAdapter.LayType("      asReversed() 在可变列表上调用会返回另一个可变列表，该列表是原始列表的反向视图。在该视图中的更改将反映在原始列表中。"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
        simpleWrite()
    }

    private fun simpleWrite() {
        val numbers = mutableListOf("one", "five", "six")
        //添加
        numbers.add(1, "two")
        numbers.addAll(2, listOf("three", "four"))
        println(numbers)
        //更新
        numbers[1] =  "two"
        println(numbers)
        numbers.fill("three")
        println(numbers)
        //删除
        numbers.removeAt(1)
        println(numbers)
        //todo 排序
        numbers.sort()
        println("Sort into ascending: $numbers")
        numbers.sortDescending()
        println("Sort into descending: $numbers")

        numbers.sortBy { it.length }
        println("Sort into ascending by length: $numbers")
        numbers.sortByDescending { it.last() }
        println("Sort into descending by the last letter: $numbers")

        numbers.sortWith(compareBy<String> { it.length }.thenBy { it })
        println("Sort by Comparator: $numbers")

        numbers.shuffle()
        println("Shuffle: $numbers")

        numbers.reverse()
        println("Reverse: $numbers")
    }

    private fun simple() {
        val numbers = listOf(1, 2, 3, 4)
        println(numbers.get(0))
        println(numbers[0])
        //numbers.get(5)                         // exception!
        println(numbers.getOrNull(5))             // null
        println(numbers.getOrElse(5){it * 2})

        //将指定范围元素返回
        println(numbers.subList(1, 3))//范围不能超出大小  左闭右开区间
        //indexOf返回元素的位置
        println(numbers.indexOf(2))
        println(numbers.lastIndexOf(2))
        println(numbers.indexOf(5))//未找到返回-1
        //查找满足条件的第一个/最后一个元素的索引
        println(numbers.indexOfFirst { it > 2})
        println(numbers.indexOfLast { it % 2 == 1})

        //二分查找 binarySearch()
        val stringNumbers = mutableListOf("one", "two", "three", "four")
        stringNumbers.sort()
        println(stringNumbers)
        println(stringNumbers.binarySearch("two"))  // 3
        println(stringNumbers.binarySearch("z")) // -5
        println(stringNumbers.binarySearch("two", 0, 2))  // -3

        //Comparator 二分查找
        val productList = listOf(
            Product("WebStorm", 49.0),
            Product("AppCode", 99.0),
            Product("DotTrace", 129.0),
            Product("ReSharper", 149.0))

        println(productList.binarySearch(Product("AppCode", 99.0), compareBy<Product> { it.price }.thenBy { it.name }))
        println(stringNumbers.binarySearch("RED", String.CASE_INSENSITIVE_ORDER))
        //todo 比较 函数的二分搜索
        println(productList.binarySearch { priceComparison(it, 99.0) })
    }

    class Product(val name: String, val price: Double)
    fun priceComparison(product: Product, price: Double) = sign(product.price - price).toInt()

}