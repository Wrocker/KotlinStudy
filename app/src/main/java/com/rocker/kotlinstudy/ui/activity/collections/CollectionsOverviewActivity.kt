package com.rocker.kotlinstudy.ui.activity.collections

import android.view.View
import android.widget.TextView
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 集合概述
 */
class CollectionsOverviewActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.collectionsOverview
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  Kotlin 相关的集合类型"))
        data.add(ContentLayoutAdapter.LayType("     - List 是一个有序集合，可通过索引（反映元素位置的整数）访问元素。元素可以在 list 中出现多次。"))
        data.add(ContentLayoutAdapter.LayType("     - Set 是唯一元素的集合。它反映了集合（set）的数学抽象：一组无重复的对象。"))
        data.add(ContentLayoutAdapter.LayType("     - Map（或者字典）是一组键值对。键是唯一的，每个键都刚好映射到一个值。值可以重复。"))
        data.add(ContentLayoutAdapter.LayType("♦️  集合类型"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 标准库提供了基本集合类型的实现： set、list 以及 map"))
        data.add(ContentLayoutAdapter.LayType("     一对接口代表每种集合类型:"))
        data.add(ContentLayoutAdapter.LayType("     - 一个 只读 接口，提供访问集合元素的操作。"))
        data.add(ContentLayoutAdapter.LayType("     - 一个 可变 接口，通过写操作扩展相应的只读接口：添加、删除和更新其元素"))
        data.add(ContentLayoutAdapter.LayType("     更改可变集合不需要它是以 var 定义的变量：写操作修改同一个可变集合对象，因此引用不会改变。 但是，如果尝试对 val 集合重新赋值，你将收到编译错误"))
        data.add(ContentLayoutAdapter.LayType("     只读集合类型是型变的。 集合类型与元素类型具有相同的子类型关系。 map 在值（value）类型上是型变的，但在键（key）类型上不是。"))
        data.add(ContentLayoutAdapter.LayType("     可变集合不是型变的；否则将导致运行时故障"))

        data.add(ContentLayoutAdapter.LayType("♦️  Collection"))
        data.add(ContentLayoutAdapter.LayType("     Collection<T> 是集合层次结构的根。"))
        data.add(ContentLayoutAdapter.LayType("     此接口表示一个只读集合的共同行为：检索大小、检测是否为成员等等"))
        data.add(ContentLayoutAdapter.LayType("     - Collection 继承自 Iterable <T> 接口，它定义了迭代元素的操作"))
        data.add(ContentLayoutAdapter.LayType("     MutableCollection 是一个具有写操作的 Collection 接口，例如 add 以及 remove"))
        data.add(ContentLayoutAdapter.LayType("♦️  List"))
        data.add(ContentLayoutAdapter.LayType("     List<T> 以指定的顺序存储元素，并提供使用索引访问元素的方法。"))
        data.add(ContentLayoutAdapter.LayType("     索引从 0 开始 – 第一个元素的索引 – 直到 最后一个元素的索引 即 (list.size - 1)"))
        data.add(ContentLayoutAdapter.LayType("     List 元素（包括空值）可以重复：List 可以包含任意数量的相同对象或单个对象的出现。 "))
        data.add(ContentLayoutAdapter.LayType("     如果两个 List 在相同的位置具有相同大小和相同结构的元素，则认为它们是相等的。"))
        data.add(ContentLayoutAdapter.LayType("     - MutableList<T> 是可以进行写操作的 List，例如用于在特定位置添加或删除元素。"))
        data.add(ContentLayoutAdapter.LayType("     List 的默认实现是 ArrayList，可以将其视为可调整大小的数组。"))
        data.add(ContentLayoutAdapter.LayType("♦️  Set"))
        data.add(ContentLayoutAdapter.LayType("     Set<T> 存储唯一的元素；它们的顺序通常是未定义的。"))
        data.add(ContentLayoutAdapter.LayType("     null 元素也是唯一的：一个 Set 只能包含一个 null。"))
        data.add(ContentLayoutAdapter.LayType("     当两个 set 具有相同的大小并且对于一个 set 中的每个元素都能在另一个 set 中存在相同元素，则两个 set 相等。"))
        data.add(ContentLayoutAdapter.LayType("     - MutableSet 是一个带有来自 MutableCollection 的写操作接口的 Set"))
        data.add(ContentLayoutAdapter.LayType("     Set的默认实现 - LinkedHashSet – 保留元素插入的顺序。"))
        data.add(ContentLayoutAdapter.LayType("     另一种实现方式 – HashSet – 不声明元素的顺序，所以在它上面调用这些函数会返回不可预测的结果。但是，HashSet 只需要较少的内存来存储相同数量的元素。"))
        data.add(ContentLayoutAdapter.LayType("♦️  Map"))
        data.add(ContentLayoutAdapter.LayType("     Map<K, V> 不是 Collection 接口的继承者"))
        data.add(ContentLayoutAdapter.LayType("     Map 存储 键-值 对（或 条目）；键是唯一的，但是不同的键可以与相同的值配对。"))
        data.add(ContentLayoutAdapter.LayType("     Map 接口提供特定的函数进行通过键访问值、搜索键和值等操作。"))
        data.add(ContentLayoutAdapter.LayType("     MutableMap 是一个具有写操作的 Map 接口，可以使用该接口添加一个新的键值对或更新给定键的值。"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    fun simple(){
        val numbers = mutableListOf("one", "two", "three", "four")
        numbers.add("five")   // 这是可以的
        //numbers = mutableListOf("six", "seven")      // 编译错误

        //只读集合类型是型变的
        val views = mutableListOf<View>(rootBinding.flBack)
        val textViews = mutableListOf<TextView>(rootBinding.tvTitle)
        views.addAll(textViews)

        //Collection 检索大小，迭代
        val stringList = listOf("one", "two", "one")

        //MutableCollection 有add和remove方法
        val words = "A long time ago in a galaxy far far away".split(" ")
        val shortWords = mutableListOf<String>()
        words.getShortWordsTo(shortWords, 3)
        println(shortWords)

        //List 索引
        val listNumbers = listOf("one", "two", "three", "four")
        println("Number of elements: ${listNumbers.size}")
        println("Third element: ${listNumbers.get(2)}")
        println("Fourth element: ${listNumbers[3]}")
        println("Index of element \"two\" ${listNumbers.indexOf("two")}")
        //List 相等
        val bob = Person("Bob", 31)
        val people = listOf(Person("Adam", 20), bob, bob)
        val people2 = listOf(Person("Adam", 20), Person("Bob", 31), bob)
        println(bob == Person("Bob", 31))
        println(people == people2) //比较了里面的元素是否相同
        bob.age = 32
        println(people == people2)

        //set
        val setNumbers = setOf(1, 2, 3, 4)
        println("Number of elements: ${setNumbers.size}")
        if (setNumbers.contains(1)) println("1 is in the set")
        //set相等
        val numbersBackwards = setOf(4, 3, 2, 1)
        println("The sets are equal: ${numbers == numbersBackwards}")

        //map
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
        println("All keys: ${numbersMap.keys}")
        println("All values: ${numbersMap.values}")
        if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
        if (1 in numbersMap.values) println("The value 1 is in the map")
        if (numbersMap.containsValue(1)) println("The value 1 is in the map")
        //map 相等
        val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)
        println("The maps are equal: ${numbersMap == anotherMap}")
    }

    fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
        this.filterTo(shortWords) { it.length <= maxLength }
        // throwing away the articles
        val articles = setOf("a", "A", "an", "An", "the", "The")
        shortWords -= articles //removeAll
    }

    inner class Person(val name: String, var age: Int){
        override fun equals(other: Any?): Boolean {
            return if(other is Person)
                other.name == name && other.age == age
            else super.equals(other)
        }
    }
}