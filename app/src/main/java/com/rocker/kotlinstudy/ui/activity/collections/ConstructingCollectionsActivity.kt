package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

/**
 * 构造集合
 */
class ConstructingCollectionsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.constructingCollections
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  由元素构造"))
        data.add(ContentLayoutAdapter.LayType("     - Collection<T>"))
        data.add(ContentLayoutAdapter.LayType("     创建集合的最常用方法是使用标准库函数 listOf<T>()、setOf<T>()、mutableListOf<T>()、mutableSetOf<T>()。 "))
        data.add(ContentLayoutAdapter.LayType("     如果以逗号分隔的集合元素列表作为参数，编译器会自动检测元素类型。创建空集合时，须明确指定类型"))
        data.add(ContentLayoutAdapter.LayType("     - Map<K, V>"))
        data.add(ContentLayoutAdapter.LayType("     Map 也有这样的函数 mapOf() 与 mutableMapOf()。映射的键和值作为 Pair 对象传递（通常使用中缀函数 to 创建）"))
        data.add(ContentLayoutAdapter.LayType("     to 符号创建了一个短时存活的 Pair 对象，因此建议仅在性能不重要时才使用它。 为避免过多的内存使用，请使用其他方法。"))
        data.add(ContentLayoutAdapter.LayType("     例如，可以创建可写 Map 并使用写入操作填充它。 apply() 函数可以帮助保持初始化流畅。"))
        data.add(ContentLayoutAdapter.LayType("♦️  空集合"))
        data.add(ContentLayoutAdapter.LayType("     用于创建没有任何元素的集合的函数：emptyList()、emptySet() 与 emptyMap()。"))
        data.add(ContentLayoutAdapter.LayType("     创建空集合时，应指定集合将包含的元素类型。"))
        data.add(ContentLayoutAdapter.LayType("♦️  list 的初始化函数"))
        data.add(ContentLayoutAdapter.LayType("     对于 List，有一个接受 List 的大小与初始化函数的构造函数，该初始化函数根据索引定义元素的值。"))
        data.add(ContentLayoutAdapter.LayType("♦️  具体类型构造函数"))
        data.add(ContentLayoutAdapter.LayType("     要创建具体类型的集合，例如 ArrayList 或 LinkedList，可以使用这些类型的构造函数。"))
        data.add(ContentLayoutAdapter.LayType("     类似的构造函数对于 Set 与 Map 的各实现中均有提供。"))
        data.add(ContentLayoutAdapter.LayType("♦️  复制"))
        data.add(ContentLayoutAdapter.LayType("     标准库中的集合复制操作创建了具有相同元素引用的 浅 复制集合。 因此，对集合元素所做的更改会反映在其所有副本中。"))
        data.add(ContentLayoutAdapter.LayType("     在特定时刻通过集合复制函数，例如toList()、toMutableList()、toSet() 等等。创建了集合的快照。 结果是创建了一个具有相同元素的新集合 如果在源集合中添加或删除元素，则不会影响副本。副本也可以独立于源集合进行更改。"))
        data.add(ContentLayoutAdapter.LayType("     集合的初始化可用于限制其可变性。"))
        data.add(ContentLayoutAdapter.LayType("♦️  调用其他集合的函数"))
        data.add(ContentLayoutAdapter.LayType("     可以通过其他集合各种操作的结果来创建集合。"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //由元素构成集合
        val numbersSet = setOf("one", "two", "three", "four")
        val emptySet = mutableSetOf<String>()
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
        val mutableNumbersMap = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }//todo 好处都有啥
        //空集合
        val empty = emptyList<String>()
        //list 定义大小及初始化
        val doubled = MutableList(3, { it * 2 })//参数it为角标
        // 如果你想操作这个集合，应使用 MutableList
        doubled.add(3)
        println(doubled)
        //具体类型的构造函数
        val linkedList = LinkedList<String>(listOf("one", "two", "three"))
        val presizedSet = HashSet<Int>(32)
        //复制
        val copyList = doubled.toMutableList() //复制为可变集合
        val readOnlyCopyList = doubled.toList() //复制为不可变集合
        val copySet = doubled.toMutableSet() //list构建为set集合
        //引用
        val sourceList = mutableListOf(1, 2, 3)
        val referenceList = sourceList
        referenceList.add(4)
        println("Source size: ${sourceList.size}")
        //通过引用限制操作
        val references: List<Int> = sourceList
        //references.add(4)            // 编译错误,限制操作
        sourceList.add(4)
        println(references) // 显示 sourceList 当前状态

        //其他操作
        //过滤
        val numbers = listOf("one", "two", "three", "four")
        val longerThan3 = numbers.filter { it.length > 3 }
        println(longerThan3)
        //映射
        val numberSet = setOf(1, 2, 3)
        println(numberSet.map { it * 3 })
        println(numberSet.mapIndexed { idx, value -> value * idx })
        //关联生成map
        println(numbers.associateWith { it.length })
    }
}