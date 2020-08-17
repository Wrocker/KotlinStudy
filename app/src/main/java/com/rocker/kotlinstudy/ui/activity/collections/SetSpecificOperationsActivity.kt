package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * set相关操作
 */
class SetSpecificOperationsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.setSpecificOperations
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  union() 并集"))
        data.add(ContentLayoutAdapter.LayType("     对于有序集合，操作数的顺序很重要：在结果集合中，左侧操作数在前"))
        data.add(ContentLayoutAdapter.LayType("♦️  intersect() 交集"))
        data.add(ContentLayoutAdapter.LayType("♦️  subtract() 差集"))
        data.add(ContentLayoutAdapter.LayType("♦️  List 也支持 Set 操作。 但是，对 List 进行 Set 操作的结果仍然是 Set ，因此将删除所有重复的元素"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = setOf("one", "two", "three")

        println(numbers union setOf("four", "five"))
        println(setOf("four", "five") union numbers)

        println(numbers intersect setOf("two", "one"))
        println(numbers subtract setOf("three", "four"))
        println(numbers subtract setOf("four", "three")) // 相同的输出
    }
}