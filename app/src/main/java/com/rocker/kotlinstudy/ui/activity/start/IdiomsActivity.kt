package com.rocker.kotlinstudy.ui.activity.start

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseLoadActivity
import com.rocker.kotlinstudy.databinding.LayoutListBinding
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter
import com.rocker.kotlinstudy.ui.adapter.OptionItemAdapter
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths
import javax.xml.transform.TransformerException
import kotlin.math.PI

/**
 * 常用方法
 */
class IdiomsActivity : BaseLoadActivity<LayoutListBinding>() {

    override fun initLoadLayout(): Int {
        return R.layout.layout_list
    }

    override fun initLoadBinding(inflate: View): LayoutListBinding {
        return LayoutListBinding.bind(inflate)
    }

    override fun initView() {
        super.initView()
        rootBinding.tvTitle.text = getString(R.string.idioms)
    }

    override fun initLoad() {
        loadBinding.rvContent.layoutManager = LinearLayoutManager(this)
        val adapter = ContentLayoutAdapter(this)
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️ 创建 DTOs（POJOs/POCOs）"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_import))
        data.add(ContentLayoutAdapter.LayType("♦️ java中的程序入口"))
        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_main))
        data.add(ContentLayoutAdapter.LayType("♦️ 方法"))
        adapter.data = data
        loadBinding.rvContent.adapter = adapter
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

    /**
     * 扩展函数
     */
    private fun String.getThird(): String{
        return get(3).toString()
    }

    fun getThirdChar(){
        println("the third is ${"Three".getThird()}")
    }

    /**
     * 单例
     */
    object Option{
        val OPTION_EXIT = 2003
    }

    /**
     * null判断
     */
    fun nullExemple(data: List<String>?){
        //判断不能为null
        println("${data?.size}")
        //If not null and else 缩写
        println("${data?.size ?: 0}")
        //if null 执行一个语句
        data?.get(0) ?: println("data is null")
        //在可能会空的集合中取第一元素
        println(data?.firstOrNull() ?: "")
        //if not null 执行代码
        data?.let {
            println("data is not null ${it.size}")
        }
        //映射可空值（如果非空的话）
        println(data?.let {println(it[0]) } ?: "default")

        //使用可空布尔
        val b: Boolean? = data == null
        if (b == true) {
            println("data is not null")
        } else {
            println("data is null")
        }
        //交换两个变量
        var x = 1
        var y = 2
        x = y.also { y = x }
    }

    /**
     * 返回 when 表达式
     */
    fun transColor2Sex(color: String): Int{
        return when (color){
            "white" -> 0xFFFFFF
            "black" -> 0x000000
            else -> throw TransformerException("出错")
        }
    }

    /**
     * “try/catch”表达式
     */
    fun tryCatchSimple(){
        val result = try {
            transColor2Sex("")
        }catch (e: Exception){
            println("trans Fail")
        }
    }

    /**
     * “if”表达式
     */
    fun ifSimple(string: String): String{
        return if(string.startsWith("a")) "a start" else "another"
    }

    /**
     * 返回类型为 Unit 的方法的 Builder 风格用法
     */
    fun arrayOfMinusOnes(size: Int): IntArray{
        return IntArray(size).apply { fill(1) }
    }

    /**
     * 单表达式函数
     */
    fun getAnswer(x: Int) = PI * x * x

    /**
     * 对一个对象实例调用多个方法 （with）
     */
    fun withSimple(){
        val temp = OptionItemAdapter(this)
        with(temp){
            data = arrayListOf("1", "2")

        }
    }

    /**
     * 配置对象的属性（apply）
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun applySimple(){
        val temp = OptionItemAdapter(this).apply {
            data = arrayListOf("1", "2")
        }

        val stream = Files.newInputStream(Paths.get("/some/file.txt"))
        stream.buffered().reader().use { reader ->
            println(reader.readText())
        }
    }

    /**
     * todo 没懂
     * 对于需要泛型信息的泛型函数的适宜形式
     */
    //  public final class Gson {
//     ……
//     public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
//     ……
    inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

    /**
     * 将代码标记为不完整
     */
    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")
}