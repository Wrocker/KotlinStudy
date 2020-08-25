package com.rocker.kotlinstudy.ui.activity.coroutine

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 协程基础activity
 */
class CoroutinesBasicsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.coroutinesBasics
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  简单协程程序"))
        data.add(ContentLayoutAdapter.LayType("     GlobalScope 新协程的生命周期只受整个应用程序的生命周期限制"))
        data.add(ContentLayoutAdapter.LayType("♦️  桥接阻塞与非阻塞的世界"))
        data.add(ContentLayoutAdapter.LayType("     Iterable 集合的另一种方法是众所周知的 for 循环"))
        data.add(ContentLayoutAdapter.LayType("     forEach() 函数，可自动迭代集合并为每个元素执行给定的代码"))
        data.add(ContentLayoutAdapter.LayType("♦️  等待一个作业"))
        data.add(ContentLayoutAdapter.LayType("     双向迭代：ListIterator "))
        data.add(ContentLayoutAdapter.LayType("     具有双向迭代的能力意味着 ListIterator 在到达最后一个元素后仍可以使用。"))
        data.add(ContentLayoutAdapter.LayType("♦️  结构化的并发"))
        data.add(ContentLayoutAdapter.LayType("      MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()"))
        data.add(ContentLayoutAdapter.LayType("      MutableListIterator 还可以在迭代列表时插入和替换元素。"))
        data.add(ContentLayoutAdapter.LayType("♦️  作用域构建器"))
        data.add(ContentLayoutAdapter.LayType("      MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()"))
        data.add(ContentLayoutAdapter.LayType("      MutableListIterator 还可以在迭代列表时插入和替换元素。"))
        data.add(ContentLayoutAdapter.LayType("♦️  提取函数重构"))
        data.add(ContentLayoutAdapter.LayType("      MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()"))
        data.add(ContentLayoutAdapter.LayType("      MutableListIterator 还可以在迭代列表时插入和替换元素。"))
        data.add(ContentLayoutAdapter.LayType("♦️  协程很轻量"))
        data.add(ContentLayoutAdapter.LayType("      MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()"))
        data.add(ContentLayoutAdapter.LayType("      MutableListIterator 还可以在迭代列表时插入和替换元素。"))
        data.add(ContentLayoutAdapter.LayType("♦️  全局协程像守护线程"))
        data.add(ContentLayoutAdapter.LayType("      MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()"))
        data.add(ContentLayoutAdapter.LayType("      MutableListIterator 还可以在迭代列表时插入和替换元素。"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //sleep挂起，处理器让给其他进程
        //delay不挂起，不让出处理器
        //第一个协程程序
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            println("World!") // 在延迟后打印输出
        }
        println("Hello,") // 协程已在等待时主线程还在继续
//        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
        //Thread来写
        Thread { // 在后台启动一个新的协程并继续
            Thread.sleep(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            println("World!") // 在延迟后打印输出
        }.start()
        println("Hello,") // 协程已在等待时主线程还在继续
//        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活

        //代替Thread.sleep(2000L)
        runBlocking {     // 但是这个表达式阻塞了主线程
            delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
        }
    }
}