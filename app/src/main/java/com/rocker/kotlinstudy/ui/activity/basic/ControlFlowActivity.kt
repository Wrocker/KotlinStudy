package com.rocker.kotlinstudy.ui.activity.basic

import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 控制流
 */
class ControlFlowActivity: BaseLoadListActivity() {

    override fun initTitle(): Int {
        return R.string.controlFlow
    }

    override fun initLoad() {
        loadBinding.rvContent.layoutManager = LinearLayoutManager(this)
        val adapter = ContentLayoutAdapter(this)
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦    if表达式"))
        data.add(ContentLayoutAdapter.LayType("     if为表达式，因此可以代替三元运算符，直接返回数值"))
        data.add(ContentLayoutAdapter.LayType("     if表达式还支持代码块"))
        data.add(ContentLayoutAdapter.LayType("♦    when表达式"))
        data.add(ContentLayoutAdapter.LayType("     when取代了switch"))
        data.add(ContentLayoutAdapter.LayType("     if表达式还支持代码块"))
        data.add(ContentLayoutAdapter.LayType("♦    for循环"))
        data.add(ContentLayoutAdapter.LayType("♦    while表达式"))

        adapter.data = data
        loadBinding.rvContent.adapter = adapter
    }

    fun whileSimple(temp: Any){
        var x = temp
        if(x is Int)
            while (x > 0) {
                x--
            }
        //do while即先执行一遍再判断是否循环
        do {
            val y = temp
        } while (y != null) // y 在此处可见
    }

    fun forSimple(list: List<String>){
        //正常轮询
        for(x in list){
            println(" value is x")
        }
        //简介写法
        for(x in list) println(" value is x")
        //区间表达
        for(i in 1..6)
            println("$i")
        for (i in 6 downTo 0 step 2) {
            println(i)
        }
        //支持索引的
        for(i in list.indices)
            println("$i is ${list[i]}")
        //库函数
        for ((index, value) in list.withIndex()) {
            println("the element at $index is $value")
        }
    }

    fun whenSimple(x: Any, y: Any){
        when (x){
            1 -> println("x is 1")
            2 -> println("x is 2")
            else -> println("x is neither 1 nor 2")
        }
        //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
        when (x){
            2,3 -> println("x is 2 or 3")
            else -> println("x is neither 1 nor 2")
        }
        //条件可以不是常量
        when (x){
            2,3 -> println("x is 2 or 3")
            hashCode() -> println("x is hashCode")
            else -> println("x is neither 1 nor 2")
        }
        //when语句还能检查值是否在/不在某一范围内
        when (x){
            in 1..3 -> println("x is in 1 to 3")
            !in 4..6 -> println("x is in 1 to 3")
            else -> println("x is neither 1 nor 2")
        }
        //支持is条件,支持自动类型转换
        when (x){
            is Int -> println("x is Int ${x.plus(1)}")
            !is String -> println("x is not String")
            else -> println("x is neither 1 nor 2")
        }
        //可以代替if else if else链条,分支条件为true则执行该条件，否则向下
        when {
            x is Int -> println("x is Int")
            y is Int -> println("y is Int")
            else -> println("neither x nor y is not Int")
        }
        //自 Kotlin 1.3 起，主语句可以进行运算
        when (x.hashCode()){
            1 -> println("x is 1")
            2 -> println("x is 2")
            else -> println("x is neither 1 nor 2")
        }
    }

    fun ifSimple(a: Int, b: Int){
        //传统1
        var max = b
        if(a > b)
            max = a
        //传统2
        var max0: Int
        if(a > b)
            max0 = a
        else
            max0 = b
        //kotlin中
        var max1 = if(a > b) a else b
        //同时支持代码块
        var max2 = if(a > b){
            println("yeah, a is the biggest")
            a
        }else{
            println("yeah, b is the biggest")
            b
        }
    }
}