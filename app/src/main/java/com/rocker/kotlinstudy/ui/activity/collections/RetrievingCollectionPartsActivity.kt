package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 取集合的一部分
 */
class RetrievingCollectionPartsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.retrievingCollectionParts
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  Slice"))
        data.add(ContentLayoutAdapter.LayType("     slice() 返回具有给定索引的集合元素列表"))
        data.add(ContentLayoutAdapter.LayType("     索引既可以是作为区间传入的也可以是作为整数值的集合传入的"))
        data.add(ContentLayoutAdapter.LayType("♦️  Take 与 drop"))
        data.add(ContentLayoutAdapter.LayType("     take()从头获取指定数量的元素,takeLast()从尾"))
        data.add(ContentLayoutAdapter.LayType("     drop()从头去除指定数量的元素,dropLast()从尾"))
        data.add(ContentLayoutAdapter.LayType("     - 当调用的数字大于集合的大小时，两个函数都将返回整个集合。"))
        data.add(ContentLayoutAdapter.LayType("     - 还可以使用谓词来定义要获取或去除的元素的数量。"))
        data.add(ContentLayoutAdapter.LayType("       _takeWhile() 是带有谓词的 take()：它将不停获取元素直到排除与谓词匹配的首个元素。如果首个集合元素与谓词匹配，则结果为空。"))
        data.add(ContentLayoutAdapter.LayType("       _takeLastWhile() 与 takeLast() 类似：它从集合末尾获取与谓词匹配的元素区间。区间的首个元素是与谓词不匹配的最后一个元素右边的元素。如果最后一个集合元素与谓词匹配，则结果为空。"))
        data.add(ContentLayoutAdapter.LayType("       _dropWhile() 与具有相同谓词的 takeWhile() 相反：它将首个与谓词不匹配的元素返回到末尾。"))
        data.add(ContentLayoutAdapter.LayType("       _dropLastWhile() 与具有相同谓词的 takeLastWhile() 相反：它返回从开头到最后一个与谓词不匹配的元素。"))
        data.add(ContentLayoutAdapter.LayType("♦️  Chunked"))
        data.add(ContentLayoutAdapter.LayType("      将集合分解为给定大小的“块”"))
        data.add(ContentLayoutAdapter.LayType("      chunked() 采用一个参数（块的大小），并返回一个 List 其中包含给定大小的 List。"))
        data.add(ContentLayoutAdapter.LayType("      可以立即对返回的块应用(集合)转换"))
        data.add(ContentLayoutAdapter.LayType("♦️  Windowed"))
        data.add(ContentLayoutAdapter.LayType("     检索给定大小的集合元素中所有可能区间"))
        data.add(ContentLayoutAdapter.LayType("     windowed() 通过可选参数提供更大的灵活性"))
        data.add(ContentLayoutAdapter.LayType("     - step 定义两个相邻窗口的第一个元素之间的距离"))
        data.add(ContentLayoutAdapter.LayType("     - partialWindows 包含从集合末尾的元素开始的较小的窗口"))
        data.add(ContentLayoutAdapter.LayType("♦️ zipWithNext"))
        data.add(ContentLayoutAdapter.LayType("     创建接收器集合的相邻元素对"))
        data.add(ContentLayoutAdapter.LayType("     它为 每个 元素创建除最后一个元素外的对"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //slice 根据索引返回集合列表
        println("_______slice_______")
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.slice(1..3))
        println(numbers.slice(0..4 step 2))
        println(numbers.slice(setOf(3, 5, 0)))
        //take/drop
        println("_______take/drop_______")
        println(numbers.take(3))
        println(numbers.takeLast(3))
        println(numbers.drop(1))
        println(numbers.dropLast(5))
        println(numbers.dropLast(10))//返回整个集合
        //其他take/drop
        println("_______其他take/drop_______")
        println(numbers.takeWhile { !it.startsWith('f') }) //不停获取元素直到排除与谓词匹配的首个元素
        println(numbers.takeLastWhile { it != "three" })
        println(numbers.dropWhile { it.length == 3 })
        println(numbers.dropLastWhile { it.contains('i') })
        //chunked
        val listNumbers = (0..13).toList()
        println(listNumbers.chunked(3)) //分块
        println(listNumbers.chunked(3){ it.sum()}) //对每个块进行操作
        //windowed 检索给定大小的集合元素中所有可能区间
        println(numbers.windowed(3))

        println(listNumbers.windowed(3))
        println(listNumbers.windowed(3, step = 2, partialWindows = true)) //step表示两个块间隔为2 partialWindows表示显示末尾最小对集合
        println(listNumbers.windowed(3) { it.sum() })
        //zipWithNext 创建接收器集合的相邻元素对
        val zipNumbers = listOf("one", "two", "three", "four", "five")
        println(zipNumbers.zipWithNext())
        println(zipNumbers.zipWithNext() { s1, s2 -> s1.length > s2.length})
    }
}