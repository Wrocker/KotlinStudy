package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * map相关操作
 */
class MapSpecificOperationsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.mapSpecificOperations
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  取键与值"))
        data.add(ContentLayoutAdapter.LayType("     get(key) 或者 [key]语法，如果找不到给定的键，则返回 null "))
        data.add(ContentLayoutAdapter.LayType("     getValue(key) 如果找不到给定的键，则抛异常"))
        data.add(ContentLayoutAdapter.LayType("     getOrElse() 对于不存在的键，其值由给定的 lambda 表达式返回"))
        data.add(ContentLayoutAdapter.LayType("     getOrDefault() 如果找不到键，则返回指定的默认值"))
        data.add(ContentLayoutAdapter.LayType("     keys 和 values 检索 所有键或所有值"))
        data.add(ContentLayoutAdapter.LayType("♦️  过滤"))
        data.add(ContentLayoutAdapter.LayType("     filter() 函数来过滤 "))
        data.add(ContentLayoutAdapter.LayType("     filterKeys() 按键过滤"))
        data.add(ContentLayoutAdapter.LayType("     filterValues() 按值过滤"))
        data.add(ContentLayoutAdapter.LayType("♦️  plus 与 minus 操作"))
        data.add(ContentLayoutAdapter.LayType("     plus 返回包含两个操作数元素的 Map : 左侧的 Map 与右侧的 Pair 或另一个 Map "))
        data.add(ContentLayoutAdapter.LayType("     minus 将根据左侧 Map 条目创建一个新 Map ，右侧操作数带有键的条目将被剔除"))
        data.add(ContentLayoutAdapter.LayType("     plusAssign（+=）与 minusAssign（-=）运算符"))

        data.add(ContentLayoutAdapter.LayType("♦️  Map 写操作"))
        data.add(ContentLayoutAdapter.LayType("     Map 写操作的一些规则："))
        data.add(ContentLayoutAdapter.LayType("     - 值可以更新。 反过来，键也永远不会改变：添加条目后，键是不变的。"))
        data.add(ContentLayoutAdapter.LayType("     - 每个键都有一个与之关联的值。也可以添加和删除整个条目。"))
        data.add(ContentLayoutAdapter.LayType("♦️  添加与更新条目put"))
        data.add(ContentLayoutAdapter.LayType("     put() 将新的键值对添加到可变 Map "))
        data.add(ContentLayoutAdapter.LayType("     putAll() 参数可以是 Map 或一组 Pair ： Iterable 、 Sequence 或 Array 。"))
        data.add(ContentLayoutAdapter.LayType("     给定键已存在于 Map 中，则 put() 与 putAll() 都将覆盖值"))
        data.add(ContentLayoutAdapter.LayType("     快速操作符将新条目添加到 Map "))
        data.add(ContentLayoutAdapter.LayType("     - plusAssign （+=） 操作符"))
        data.add(ContentLayoutAdapter.LayType("     - [] 操作符为 put() 的别名"))
        data.add(ContentLayoutAdapter.LayType("♦️  删除条目remove"))
        data.add(ContentLayoutAdapter.LayType("     可以传递键或整个键值对"))
        data.add(ContentLayoutAdapter.LayType("     如果同时指定键和值，则仅当键值都匹配时，才会删除此的元素。"))
        data.add(ContentLayoutAdapter.LayType("     给定键已存在于 Map 中，则 put() 与 putAll() 都将覆盖值"))

        data.add(ContentLayoutAdapter.LayType("     .keys 或 .values 中调用 remove() 并提供键或值来删除条目"))
        data.add(ContentLayoutAdapter.LayType("     在 .values 中调用时， remove() 仅删除给定值匹配到的的第一个条目"))
        data.add(ContentLayoutAdapter.LayType("     minusAssign （-=） 操作符也可用于可变 Map"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //取键与值
        val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
        println(numbersMap.get("one"))
        println(numbersMap["one"])
//        println(numbersMap.getOrDefault("four", 10)) //API level 24
        println(numbersMap.getOrElse("four"){ 10 })
        println(numbersMap["five"])               // null
        //numbersMap.getValue("six")      // exception!

        println(numbersMap.keys)
        println(numbersMap.values)

        //过滤
        println(numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10})
        println(numbersMap.filterKeys { it.endsWith("1") })
        println(numbersMap.filterValues { it < 10 })

        //plus
        println(numbersMap + Pair("four", 4))
        println(numbersMap + Pair("one", 10)) //当右侧操作数中有左侧 Map 中已存在的键时，该条目将使用右侧的值。
        println(numbersMap + mapOf("five" to 5, "one" to 11))
        //minus
        println(numbersMap - "one")
        println(numbersMap - listOf("two", "four"))

        //写操作
        val muteNumbersMap = mutableMapOf("one" to 1, "two" to 2)
        //添加单个条目
        muteNumbersMap.put("three", 3)
        println(muteNumbersMap)
        //添加多个条目
        muteNumbersMap.putAll(setOf("four" to 4, "five" to 5))
        println(muteNumbersMap)
        //给定键已存在于 Map 中，则 put() 与 putAll() 都将覆盖值
        muteNumbersMap.put("one", 11)
        println()
        //快速操作符
        muteNumbersMap["three"] = 3     // 调用 numbersMap.put("three", 3)
        muteNumbersMap += mapOf("four" to 4, "five" to 5)
        println(muteNumbersMap)
        //删除
        muteNumbersMap.remove("one")
        println(muteNumbersMap)
        //同时指定键和值，则仅当键值都匹配时，才会删除此的元素
//        muteNumbersMap.remove("three", 4) //API level 24
        println(muteNumbersMap)
        //.key/.value删除
        muteNumbersMap.keys.remove("one")
        println(muteNumbersMap)
        muteNumbersMap.values.remove(3)//remove() 仅删除给定值匹配到的的第一个条目
        println(muteNumbersMap)
        //minusAssign
        muteNumbersMap -= "two"
        println(muteNumbersMap)
        muteNumbersMap -= "five"
        println(muteNumbersMap)
    }
}