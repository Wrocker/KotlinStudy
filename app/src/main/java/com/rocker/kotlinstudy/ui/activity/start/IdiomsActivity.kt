package com.rocker.kotlinstudy.ui.activity.start

import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseActivity
import com.rocker.kotlinstudy.databinding.ActivityListBinding
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 常用方法
 */
class IdiomsActivity : BaseActivity<ActivityListBinding>() {
    override fun initLayout(): ActivityListBinding {
        return ActivityListBinding.inflate(layoutInflater)
    }

    override fun initView() {
        rootBinding.tvTitle.text = getString(R.string.idioms)
        rootBinding.rvContent.layoutManager = LinearLayoutManager(this)
        val adapter = ContentLayoutAdapter(this)
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️ 创建 DTOs（POJOs/POCOs）"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_import))
        data.add(ContentLayoutAdapter.LayType("♦️ java中的程序入口"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_main))
        data.add(ContentLayoutAdapter.LayType("♦️ 方法"))
        adapter.data = data
        rootBinding.rvContent.adapter = adapter

    }

    //创建 DTOs（POJOs/POCOs） 理解为bean类
    data class FruitBean(val name: String, val color: String)

    /**
     * Creating DTOs (POJOs/POCOs)
     * 展示bean拥有的方法
     */
    fun showFruit(){
        val fruit0 = FruitBean("香蕉", "黄色")
        println("${fruit0.name} 的颜色是 ${fruit0.color}")
        val fruit1 = fruit0.copy()
        println("equals: ${fruit0.equals(fruit1)} toString: ${fruit0.toString()}")
        defaultParam()
        defaultParam("西瓜")
        defaultParam(name = "苹果",color = "红色")
    }

    /**
     * 函数的默认参数
     * Default values for function parameters
     * 该功能相当于提供了不同的重载方法
     */
    fun defaultParam(name: String = "香蕉", color: String = "黄色"){
        val fruit0 = FruitBean("香蕉", "黄色")
        println("${fruit0.name} 的颜色是 ${fruit0.color}")
        val fruit1 = fruit0.copy()
        println("equals: ${fruit0.equals(fruit1)} toString: ${fruit0.toString()}")
    }

    //只读list
    val fruits = listOf<String>("西瓜", "苹果", "香蕉")

    /**
     * 过滤 list
     */
    fun filterSimple(){
        val filtered = fruits.filter { it -> it.startsWith("西") }
        val filtered0 = fruits.filter { it -> it.startsWith("西") }
        for(fruit in filtered)
            println("filtered fruit is $fruit")//字符串内插
        //检测元素是否存在于集合中
        if("苹果" in fruits)
            println("apple is in fruit")
    }

    /**
     * 类型判断Instance Checks
     */
    fun instanceCheck(x: Any){
        when(x){
            is String -> println("is String")
            is FruitBean -> println("is fruit bean")
            else -> println("other")
        }
    }

    /**
     * 遍历 map/pair型list
     *  Traversing a map/list of pairs
     */
    fun traversingMap(){
        //只读 map
        val map = mapOf<String, Int>("a" to 1, "b" to 2, "c" to 3)
        //访问 map
        println("map a value is ${map["a"]}")
        for((k, v) in map){
            println("key $k to value $v")
        }

        val steps = mapOf(Pair(1, "first"), Pair(2, "second"))
        for((k, v) in steps){
            println("key $k to value $v")
        }
    }

    /**
     * 使用区间Using ranges
     */
    fun rangeSimple(){
        for (i in 1..100) { print(i) }  // 闭区间：包含 100
        println()
        for (i in 1 until 100) { print(i) } // 半开区间：不包含 100
        println()
        for (x in 2..10 step 2) { print(x) }
        println()
        for (x in 10 downTo 1) { print(x) }
        println()
        if (2 in 1..10) { print("2 is in 1..10") }
    }

    //延迟属性
    val p: String by lazy { "excuse me?" }
}