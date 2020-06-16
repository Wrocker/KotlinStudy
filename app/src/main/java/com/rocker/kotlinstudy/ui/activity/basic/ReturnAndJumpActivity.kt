package com.rocker.kotlinstudy.ui.activity.basic

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 返回和跳转activity
 */
class ReturnAndJumpActivity: BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.returnAndJump
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦    有三种结构化跳转表达式"))
        data.add(ContentLayoutAdapter.LayType("     return 默认从最直接包围它的函数或者匿名函数返回。"))
        data.add(ContentLayoutAdapter.LayType("     break 终止最直接包围它的循环。"))
        data.add(ContentLayoutAdapter.LayType("     continue 继续下一次最直接包围它的循环。"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        returnSimple()
        returnSimple2()
    }

    fun demoSimple(url: String){
        //所有这些表达式都可以用作更大表达式的一部分
        val s = url ?: return
        println(s)
    }

    /**
     * Break 与 Continue 标签
     */
    fun labelSimple(){
        //标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。 continue 继续标签指定的循环的下一次迭代。
        abc@ for(x in 1..20){
            for(y in 1..10){
                if(y == 3)
                    break@abc
                else if(y == 5)
                    continue@abc
            }
        }
    }
    private fun returnSimple() {
        //return通过标签返回到指定循环  -- 类似于continue
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            println("this is label $it")
        }
        println(" done with explicit label 00")

        //return通过隐式返回到指定循环  -- 类似于continue
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            println("this is conceal $it")
        }
        println(" done with implicit label 11")

        //return通过匿名函数内部  -- 类似于continue
        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
            if (value == 3) return  // 局部返回到匿名函数的调用者，即 forEach 循环
            println("this is forEach function $value")
        })
        println(" done with anonymous function 22")

        //return通过匿名函数内部 -- 类似于break
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
                print(it)
            }
        }
        print(" done with nested loop")

        //返回方法
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // 非局部直接返回到 foo() 的调用者
            println("this is return $it")
        }
        println("this point is unreachable 33")

    }

    private fun returnSimple2(): Int{
        //当要返一个回值的时候，解析器优先选用标签限制的 return，即
        return@returnSimple2 1
        //意为“返回 1 到 @returnSimple2”，而不是“返回一个标签标注的表达式 (@returnSimple2 1)”。
    }
}