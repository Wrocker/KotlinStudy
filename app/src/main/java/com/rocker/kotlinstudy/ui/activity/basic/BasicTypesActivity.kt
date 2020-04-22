package com.rocker.kotlinstudy.ui.activity.basic

import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseActivity
import com.rocker.kotlinstudy.databinding.ActivityListBinding
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 基本类型
 */
class BasicTypesActivity : BaseActivity<ActivityListBinding>() {
    override fun initLayout(): ActivityListBinding {
        return ActivityListBinding.inflate(layoutInflater)
    }

    override fun initView() {
        rootBinding.tvTitle.text = getString(R.string.basicTypes)
        rootBinding.rvContent.layoutManager = LinearLayoutManager(this)
        val adapter = ContentLayoutAdapter(this)
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️Kotlin提供4种整数类型"))
        data.add(ContentLayoutAdapter.LayType("     类型   大小   最小值     最大值 "))
        data.add(ContentLayoutAdapter.LayType("     Byte   8     -2^7       2^7-1 "))
        data.add(ContentLayoutAdapter.LayType("     Short  16    -2^15      2^15-1 "))
        data.add(ContentLayoutAdapter.LayType("     Int    32    -2^31      2^31-1 "))
        data.add(ContentLayoutAdapter.LayType("     Long   64    -2^63      2^63-1 "))

        data.add(ContentLayoutAdapter.LayType("♦️Kotlin提供2种浮点类型"))
        data.add(ContentLayoutAdapter.LayType("     类型    大小   有效数字比特数  指数比特数  十进制位数 "))
        data.add(ContentLayoutAdapter.LayType("     Float   32     24              8         6-7 "))
        data.add(ContentLayoutAdapter.LayType("     Double  64     53              11        15-16 "))
        data.add(ContentLayoutAdapter.LayType("♦️Kotlin中数字没有隐式拓宽转换"))

        data.add(ContentLayoutAdapter.LayType(R.drawable.ic_basic_import))

        adapter.data = data
        rootBinding.rvContent.adapter = adapter

//        noConvertExample(int) //不能进行隐式类型转换
    }

    //________________________________________整数类型
    val int = 123 //未超出Int类型范围,默认为Int
    val long = 123_456_789_101 //超出Int类型范围的,默认为Long
    val oneL = 1L //显示指定Long类型
    val oneLong: Long = 1 //显示指定Long类型
    val oneB: Byte = 1 //显示指定Byte类型
    val oneS: Short = 1 //显示指定Byte类型f
    //________________________________________浮点类型
    val e = 2.13 //带小数点的默认为Double类型
    val pi = 3.1415926535898 //带小数点的默认为Double类型
    val piF = 3.1415926535898F //F/f在末尾  显示指定Float类型,超过范围的值会舍入
//    val piFloat: Float = 3.1415926535898 //错误写法,报错提示超出范围

    fun noConvertExample(value: Long){
        println("value is $value")
    }
    //________________________________________字面常量
    val ten = 123 //十进制写法
    val sixteen = 0x0F //十六进制写法
    val two = 0b00001011 //二进制写法
    val double = 3.23 //Double写法
    val double0 = 3.23e1 //Double写法
    val float = 123.3f //Float写法
    //________________________________________使用下划线使数字常量更易读
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    //________________________________________表示方式
}