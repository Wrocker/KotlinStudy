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
}