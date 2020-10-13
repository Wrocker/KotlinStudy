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
        data.add(ContentLayoutAdapter.LayType("♦️  GlobalScope.launch"))
        data.add(ContentLayoutAdapter.LayType("     新协程的生命周期只受整个应用程序的生命周期限制"))
        data.add(ContentLayoutAdapter.LayType("♦️  delay"))
        data.add(ContentLayoutAdapter.LayType("     只能在协程中使用"))
        data.add(ContentLayoutAdapter.LayType("     挂起函数,不会造成线程阻塞,但是会 挂起 协程"))
        data.add(ContentLayoutAdapter.LayType("♦️  runBlocking<T>"))
        data.add(ContentLayoutAdapter.LayType("     <T>表示协程返回的值"))
        data.add(ContentLayoutAdapter.LayType("     T默认为Unit，Unit时可不写 "))
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
            println("current Thread is ${Thread.currentThread().name}") //current Thread is DefaultDispatcher-worker-5
            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒） //非阻塞不占用线程
            println("delay current Thread is ${Thread.currentThread().name}") //delay current Thread is DefaultDispatcher-worker-6
            println("World!") // 在延迟后打印输出
        }
        println("main Thread is ${Thread.currentThread().name}") //main Thread is main
        println("Hello,") // 协程已在等待时主线程还在继续
//        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
        //Thread来写
        Thread { // 在后台启动一个新的协程并继续
            println("1 current Thread is ${Thread.currentThread().name}") //1 current Thread is Thread-381
            Thread.sleep(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            println("sleep 1 current Thread is ${Thread.currentThread().name}") //sleep 1 current Thread is Thread-381
            println("World!") // 在延迟后打印输出
        }.start()
        println("Hello,") // 协程已在等待时主线程还在继续
//        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活

        //代替Thread.sleep(2000L)
        runBlocking<Unit> {     // 但是这个表达式阻塞了主线程
            println("2 current Thread is ${Thread.currentThread().name}") //2 current Thread is main
            delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
            println("delay 2 current Thread is ${Thread.currentThread().name}") //delay 2 current Thread is main
        }

        //runBlock协程返回String
        println("look at me, say ${sayHi()}")
    }

    fun sayHi() = runBlocking<String> {
        println("listen")
        delay(2000)
        "hi"
    }
}