package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 迭代器activity
 */
class IteratorsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.iterators
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  Iterable<T> 迭代器"))
        data.add(ContentLayoutAdapter.LayType("     迭代器 的常用机制——对象可按顺序提供对元素的访问权限，而不会暴露集合的底层结构。"))
        data.add(ContentLayoutAdapter.LayType("     Iterable<T> 接口的继承者（包括 Set 与 List）可以通过调用 iterator() 函数获得迭代器。"))
        data.add(ContentLayoutAdapter.LayType("     一旦迭代器通过了最后一个元素，它就不能再用于检索元素；也无法重新指向到以前的任何位置。"))
        data.add(ContentLayoutAdapter.LayType("♦️  for 循环"))
        data.add(ContentLayoutAdapter.LayType("     Iterable 集合的另一种方法是众所周知的 for 循环"))
        data.add(ContentLayoutAdapter.LayType("     forEach() 函数，可自动迭代集合并为每个元素执行给定的代码"))
        data.add(ContentLayoutAdapter.LayType("♦️  List 迭代器"))
        data.add(ContentLayoutAdapter.LayType("     双向迭代：ListIterator "))
        data.add(ContentLayoutAdapter.LayType("     具有双向迭代的能力意味着 ListIterator 在到达最后一个元素后仍可以使用。"))
        data.add(ContentLayoutAdapter.LayType("♦️  可变迭代器"))
        data.add(ContentLayoutAdapter.LayType("      MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()"))
        data.add(ContentLayoutAdapter.LayType("      MutableListIterator 还可以在迭代列表时插入和替换元素。"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = listOf("one", "two", "three", "four")
        val numbersIterator = numbers.iterator()
        while (numbersIterator.hasNext()) {
            println(numbersIterator.next())
        }
//        println(numbersIterator.next()) //java.util.NoSuchElementException 迭代器遍历完之后，不能再用于遍历集合
        //for 循环
        for (item in numbers) {
            println(item)
        }
        numbers.forEach {
            println(it)
        }
        //List 迭代器 双向迭代
        val listIterator = numbers.listIterator()
        while (listIterator.hasNext()) listIterator.next() //正向迭代
        println("Iterating backwards:")
        while (listIterator.hasPrevious()) {//反向迭代
            print("Index: ${listIterator.previousIndex()}") //获取索引
            println(", value: ${listIterator.previous()}")
        }
        //可变迭代器
        val mutableNumbers = mutableListOf<String>("one", "two", "three", "four")
        val mutableIterator = mutableNumbers.iterator()
        mutableIterator.next()
        mutableIterator.remove() //删除
        println("After removal: $mutableNumbers")
        //可插入/替换/删除的迭代器
        val mutableListNumbers = mutableListOf("one", "four", "four")
        val mutableListIterator = mutableListNumbers.listIterator()
        mutableListIterator.next()
        mutableListIterator.add("two")
        mutableListIterator.next()
        mutableListIterator.set("three")
        mutableListIterator.next()
        mutableListIterator.remove()
        println(mutableListNumbers)
    }
}