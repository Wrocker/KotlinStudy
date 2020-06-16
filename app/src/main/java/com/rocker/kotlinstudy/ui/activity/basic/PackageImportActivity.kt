package com.rocker.kotlinstudy.ui.activity.basic

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 包和导入
 */
class PackageImportActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.packageImport
    }

    override fun initContent() {val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦    包"))
        data.add(ContentLayoutAdapter.LayType("     源文件通常以包声明开头:表明该文件的位置"))
        data.add(ContentLayoutAdapter.LayType("     若未指明包，则该文件内容属于无名字的默认包名"))

        data.add(ContentLayoutAdapter.LayType("♦    默认导入"))
        data.add(ContentLayoutAdapter.LayType("""       kotlin.*
                                                        |kotlin.annotation.*
                                                        |kotlin.collections.*
                                                        |kotlin.comparisons.* （自 1.1 起）
                                                        |kotlin.io.*
                                                        |kotlin.ranges.*
                                                        |kotlin.sequences.*
                                                        |kotlin.text.*
                                                        |根据目标平台还会导入额外的包：
                                                        
                                                        |JVM:
                                                        |java.lang.*
                                                        |kotlin.jvm.*
                                                        |JS:
                                                        |kotlin.js.*
                                                        """.trimMargin()))
        data.add(ContentLayoutAdapter.LayType("♦    导入"))
        data.add(ContentLayoutAdapter.LayType("     导入一个单独的名字"))
        data.add(ContentLayoutAdapter.LayType("         import org.example.Message"))
        data.add(ContentLayoutAdapter.LayType("     导入一个作用域下的所有内容"))
        data.add(ContentLayoutAdapter.LayType("         import org.example.*"))
        data.add(ContentLayoutAdapter.LayType("     名字冲突，可以使用 as 关键字在本地重命名冲突项来消歧义"))
        data.add(ContentLayoutAdapter.LayType("""       |import org.example.Message // Message 可访问
                "                                       |import org.test.Message as testMessage // testMessage 代表“org.test.Message”
                                                        """.trimMargin()))
        data.add(ContentLayoutAdapter.LayType("♦    关键字 import 并不仅限于导入类；也可用它来导入其他声明"))
        data.add(ContentLayoutAdapter.LayType("         顶层函数及属性"))
        data.add(ContentLayoutAdapter.LayType("         在对象声明中声明的函数和属性"))
        data.add(ContentLayoutAdapter.LayType("         枚举常量"))
        data.add(ContentLayoutAdapter.LayType("♦    顶层声明的可见性"))
        data.add(ContentLayoutAdapter.LayType("         如果顶层声明是 private 的，它是声明它的文件所私有的"))

        adapter.data = data
        adapter.notifyDataSetChanged()
    }
}