package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 聚合操作
 */
class AggregateOperationsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.aggregateOperations
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  常用的 聚合操作"))
        data.add(ContentLayoutAdapter.LayType("     - min() 与 max() 分别返回最小和最大的元素"))
        data.add(ContentLayoutAdapter.LayType("     - average() 返回数字集合中元素的平均值"))
        data.add(ContentLayoutAdapter.LayType("     - sum() 返回数字集合中元素的总和"))
        data.add(ContentLayoutAdapter.LayType("     - count() 返回集合中元素的数量"))
        data.add(ContentLayoutAdapter.LayType("    一些通过某些选择器函数或自定义 Comparator 来检索最小和最大元素的函数"))
        data.add(ContentLayoutAdapter.LayType("     - maxBy()/minBy() 接受一个选择器函数并返回使选择器返回最大或最小值的元素"))
        data.add(ContentLayoutAdapter.LayType("     - maxWith()/minWith() 接受一个 Comparator 对象并且根据此 Comparator 对象返回最大或最小元素。"))
        data.add(ContentLayoutAdapter.LayType("    一些高级的求和函数"))
        data.add(ContentLayoutAdapter.LayType("     - sumBy() 使用对集合元素调用返回 Int 值的函数"))
        data.add(ContentLayoutAdapter.LayType("     - sumByDouble() 与返回 Double 的函数一起使用"))
        data.add(ContentLayoutAdapter.LayType("♦️  Fold 与 reduce"))
        data.add(ContentLayoutAdapter.LayType("     依次将所提供的操作应用于集合元素并返回累积的结果。 操作有两个参数：先前的累积值和集合元素"))
        data.add(ContentLayoutAdapter.LayType("     fold() 接受一个初始值并将其用作第一步的累积值"))
        data.add(ContentLayoutAdapter.LayType("     reduce() 的第一步则将第一个和第二个元素作为第一步的操作参数"))
        data.add(ContentLayoutAdapter.LayType("     reduceRight() 和 foldRight() 从右到左应用于集合元素"))
        data.add(ContentLayoutAdapter.LayType("     reduceIndexed() 和 foldIndexed()递元素索引作为操作的第一个参数 "))
        data.add(ContentLayoutAdapter.LayType("     reduceRightIndexed() 与 foldRightIndexed() 从右到左应用于集合元素"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        val numbers = listOf(6, 42, 10, 4)

        println("Count: ${numbers.count()}")
        println("Max: ${numbers.max()}")
        println("Min: ${numbers.min()}")
        println("Average: ${numbers.average()}")
        println("Sum: ${numbers.sum()}")

        //Comparator
        println(numbers.minBy { it % 3 })//%3最小的是
        val strings = listOf("one", "two", "three", "four")
        println(strings.maxWith(compareBy { it.length }))//长度最长的是
        //高级求和函数
        println(numbers.sumBy { it * 2 }) //最大值*2
        println(numbers.sumByDouble { it.toDouble() / 2 }) //最大值返回double/2

        //fold/reduce
        //sum是上一次操作后的值，element是下一个元素
        println(numbers.reduce { sum, element -> //从第一个数值开始进行操作
            println("sum is $sum and element is $element")
            sum + element
        })
        println(numbers.fold(0) { sum, element -> //从0开始操作
            println("sum is $sum and element is $element")
            sum + element * 2
        })
        //foldRight()/reduceRight()
        println(numbers.reduceRight { element, sum ->
            println("element is $element and sum is $sum")
            sum + element * 2
        })
        println(numbers.foldRight(0) { element, sum ->
            println("element is $element and sum is $sum")
            sum + element * 2
        })
        //foldIndexed()/reduceIndexed() 传递元素索引
        println(numbers.reduceIndexed { idx, sum, element ->
            println("index is $idx ; sum is $sum ; and element is $element")
            if (idx % 2 == 0) sum + element else sum
        })
        println(numbers.foldIndexed(0) { idx, sum, element ->
            println("index is $idx ; sum is $sum ; and element is $element")
            if (idx % 2 == 0) sum + element else sum
        })
        println(numbers.foldRightIndexed(0) { idx, element, sum ->
            println("index is $idx ; sum is $sum ; and element is $element")
            if (idx % 2 == 0) sum + element else sum
        })
        println(numbers.reduceRightIndexed { idx, element, sum ->
            println("index is $idx ; sum is $sum ; and element is $element")
            if (idx % 2 == 0) sum + element else sum
        })
    }
}