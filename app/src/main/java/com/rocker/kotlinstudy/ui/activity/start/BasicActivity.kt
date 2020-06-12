package com.rocker.kotlinstudy.ui.activity.start

import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import com.rocker.kotlinstudy.util.ToastUtil
import kotlin.properties.Delegates

/**
 * 基本语法
 */
class BasicActivity : BaseLoadListActivity() {

    override fun initTitle(): Int {
        return R.string.basicSyntax
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
     * 进程主入口Program entry point
     */
    fun main() {
        ToastUtil.showToast("this is main")
    }

    //________________________________________函数Functions
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

    //________________________________________变量Variables
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

    //________________________________________注释Comments
    /**
     * 注释
     */

    /*
    这是一个多行的
   块注释。
     */

    /*
    注释从这里开始
    /* 包含嵌套的注释 */
    并且在这里结束。
     */

    //________________________________________字符串模板String templates
    fun stringTemplates(){
        //""中$跟变量名，则直接显示变量
        var size = 1
        val trans1 = "size is $size "

        //""中$跟变量名，则运行方法
        size = 2
        val trans2 =
            "${trans1.replace("is", "was")}, but now is $size"
    }


    //________________________________________条件表达式Conditional expressions

    /**
     * kotlin 中可以同java一样 使用if else
     */
    fun minOf(a: Int, b: Int): Int {
        if(a < b)
            return a
        else
            return b
    }

    /**
     * kotlin中 if else 语句能直接返回数值
     */
    fun minOf1(a: Int, b: Int): Int {
        return if(a < b) a else b
    }

    /**
     * 简写
     */
    fun minOf2(a: Int, b: Int) = if(a < b) a else b

    //________________________________________空值与 null 检测Nullable values and null checks
    /**
     * string?的意思是传入值可为null
     * str?表示 if(str == null) return null
     * Int? 表示返回值可为null
     */
    fun parseInt(str: String?): Int?{
        return str?.toInt()
    }

    /**
     * ?:为kotlin语法糖 为null则执行右边
     * a?:0 表示 if(a == null) a = 0
     */
    fun printParse(str1: String, str2: String){
        val a = parseInt(str1)
        val b = parseInt(str2)
        println(a?:0 + (b?:0))
    }

    //________________________________________类型检测与自动类型转换Type checks and automatic casts
    /**
     * kotlin中 is 相当于 instance of
     */
    fun getStringLength(any: Any): Int?{
        if(any is String)
            return any.length //any自动转换为String
        else
            return null
    }
    /**
     * kotlin中 is 前可以加！表示相反
     */
    fun getStringLength1(any: Any): Int?{
        if(any !is String)
            return null
        else
            return any.length //any自动转换为String
    }
    /**
     * 搭配&&使用
     */
    fun getStringLength2(obj: Any): Int? {
        // `obj` 在 `&&` 右边自动转换成 `String` 类型
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }

    //________________________________________for 循环for loop
    fun forDemo(){
        val items = listOf("apple", "banana", "kiwifruit")
        // for语句，in直接遍历所有
        for (item in items) {
            println(items)
        }
        //可以方便的遍历角标   .indices返回的是0到items大小的角标的int范围
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }
    //________________________________________while 循环while loop
    /**
     * while写法与java相同
     */
    fun whileDemo(){
        val items = listOf("apple", "banana", "kiwifruit")
        var index = 0
        while (index < items.size){
            //items[index]相当于 items.get(index)
            println("item at $index is ${items[index]}")
            index ++
        }
    }

    //________________________________________when 表达式when expression
    /**
     * when 相当于switch 但是更强大，支持更多类型，
     * 且支持不同类型
     * 及判断方式
     */
    fun describe(obj: Any):String{
        return when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }
    }

    //________________________________________使用区间 Ranges
    fun inSimple(){
        if(3 in 2..8)//2..8表示2到8的区间
            println("3 is in range")
        //in可以搭配！表示否定
        if(3 !in 2..8)
            println("3 is not in range")
        //区间迭代
        for (x in 1..5) {
            print(x)
        }
        //数列迭代
        for (x in 1..10 step 2) {//step表示间隔2
            print(x)
        }
        println()
        for (x in 9 downTo 0 step 3) {//downto表示降序 step表示间隔
            print(x)
        }
    }


    //________________________________________集合Collections
    fun collectionsSimple(){
        //集合迭代
        val items = listOf("banana", "avocado",
            "apple", "kiwifruit")
        for (item in items) {
            println(item)
        }
        //通过in判断包含关系
        if("apple" in items)
            println("apple is in items")
        //使用 lambda 表达式来过滤（filter）与映射（map）集合
        //其中 it表示其中的item
        items
            .filter { it.startsWith("a") }//筛选a开头的
            .sortedBy { it }//排序
            .map { it.toUpperCase() }//大写
            .forEach { println(it) }//打印
    }

    //________________________________________创建基本类及其实例Creating basic classes and their instances
    fun createEntity(){
        val adapter0: ContentLayoutAdapter
                = ContentLayoutAdapter(this)
        //自动判断类型
        val adapter1 = ContentLayoutAdapter(this)
    }
}