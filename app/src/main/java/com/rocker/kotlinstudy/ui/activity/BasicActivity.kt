package com.rocker.kotlinstudy.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseLoadActivity
import com.rocker.kotlinstudy.databinding.ActivityBasicBinding
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import com.rocker.kotlinstudy.util.ToastUtil
import kotlin.properties.Delegates

/**
 * 基本语法
 */
class BasicActivity : BaseLoadActivity<ActivityBasicBinding>() {

    override fun initLoadLayout(): Int {
        return R.layout.activity_basic
    }

    override fun initLoadBinding(inflate: View): ActivityBasicBinding {
        return ActivityBasicBinding.bind(inflate)
    }

    override fun initLoad() {
        loadBinding.rvContent.layoutManager = LinearLayoutManager(this)
        val adapter = ContentLayoutAdapter(this)
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️ kotlin 导包同java"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_import))
        data.add(ContentLayoutAdapter.LayType("♦️ java中的程序入口"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_main))
        data.add(ContentLayoutAdapter.LayType("♦️ 方法"))
        adapter.data = data
        loadBinding.rvContent.adapter = adapter
    }

    /**
     * 进程主入口
     */
    fun main() {
        ToastUtil.showToast("this is main")
    }

    //________________________________________函数
    /**
     * 有返回值的方法，:后面跟返回对象
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 简写，自动判断类型
     */
    fun sum0(a: Int, b: Int) = a + b

    /**
     * 无返回值的方法，用Unit表示
     */
    fun printSum(a: Int, b: Int): Unit{
        println("$a plus $b is equal to ${sum(a, b)}")
    }

    /**
     * Unit可省略
     */
    fun printSum0(a: Int, b: Int){
        println("$a plus $b is equal to ${sum(a, b)}")
    }

    //________________________________________变量
    /**
     * 局部变量
     */
    fun printval(){
        //不可重新赋值
        val a: Int = 1 //立即赋值
        val b = 2 // 自动判断Int类型
        val c: Int
        //可重新赋值
        var x = 1
        x = 3
    }

    /**
     * 属性变量
     */
    val PI = 3.14
    var x = 0
    var y: Int by Delegates.notNull<Int>()
//    var count: Int by lazy

    fun incrementX() {
        x += 1
        y = 3
    }

}