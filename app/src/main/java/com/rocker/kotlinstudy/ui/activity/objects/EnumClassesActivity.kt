package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter


/**
 * 枚举类
 */
class EnumClassesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.enumClasses
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  枚举类的最基本的用法是实现类型安全的枚举："))
        data.add(ContentLayoutAdapter.LayType("     每个枚举常量都是一个对象。枚举常量用逗号分隔"))

        data.add(ContentLayoutAdapter.LayType("♦️  初始化"))
        data.add(ContentLayoutAdapter.LayType("     每一个枚举都是枚举类的实例"))

        data.add(ContentLayoutAdapter.LayType("♦️  匿名类"))
        data.add(ContentLayoutAdapter.LayType("     如果枚举类定义任何成员，那么使用分号将成员定义中的枚举常量定义分隔开。"))

        data.add(ContentLayoutAdapter.LayType("♦️  在枚举类中实现接口"))
        data.add(ContentLayoutAdapter.LayType("     一个枚举类可以实现接口（但不能从类继承），可以为所有条目提供统一的接口成员实现，也可以在相应匿名类中为每个条目提供各自的实现。只需将接口添加到枚举类声明中即可"))

        data.add(ContentLayoutAdapter.LayType("♦️  使用枚举常量"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        //列出枚举常量 EnumClass为枚举类名
//        EnumClass.valueOf(value: String): EnumClass
//        EnumClass.values(): Array<EnumClass>
        println("value is ${Color.valueOf("RED")}") //RED 若为black会报错BLACK is not a constant in com.rocker.kotlinstudy.ui.activity.objects.EnumClassesActivity$Color
        for(color in Color.values())
            println("color is ${color.rgb}")
    }

    enum class Direction {
        NORTH, SOUTH, WEST, EAST
    }

    enum class Color(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF)
    }

    //枚举常量还可以声明其带有相应方法以及覆盖了基类方法的匿名类。
    enum class ProtocolState {
        WAITING {
            override fun signal() = TALKING
        },

        TALKING {
            override fun signal() = WAITING
        };

        abstract fun signal(): ProtocolState
    }

//    enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
//        PLUS {
//            override fun apply(t: Int, u: Int): Int = t + u
//        },
//        TIMES {
//            override fun apply(t: Int, u: Int): Int = t * u
//        };
//
//        override fun applyAsInt(t: Int, u: Int) = apply(t, u)
//    }


}