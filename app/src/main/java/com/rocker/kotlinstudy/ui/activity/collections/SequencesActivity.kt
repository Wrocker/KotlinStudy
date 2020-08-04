package com.rocker.kotlinstudy.ui.activity.collections

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 序列
 */
class SequencesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.sequences
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  序列（Sequence<T>）和 Iterable 区别"))
        data.add(ContentLayoutAdapter.LayType("     - 当 Iterable 的处理包含多个步骤时，它们会优先执行：每个处理步骤完成并返回其结果——中间集合。 在此集合上执行以下步骤。反过来，序列的多步处理在可能的情况下会延迟执行：仅当请求整个处理链的结果时才进行实际计算"))
        data.add(ContentLayoutAdapter.LayType("     - 操作执行的顺序也不同：Sequence 对每个元素逐个执行所有处理步骤。 反过来，Iterable 完成整个集合的每个步骤，然后进行下一步。"))
        data.add(ContentLayoutAdapter.LayType("     若没有类体，可省略花括号"))
        data.add(ContentLayoutAdapter.LayType("♦️  构造 - 由元素"))
        data.add(ContentLayoutAdapter.LayType("     调用 sequenceOf() 函数，列出元素作为其参数"))
        data.add(ContentLayoutAdapter.LayType("♦️  构造 - 由 Iterable"))
        data.add(ContentLayoutAdapter.LayType("     已经有一个 Iterable 对象（例如 List 或 Set），则可以通过调用 asSequence() 从而创建一个序列。"))
        data.add(ContentLayoutAdapter.LayType("♦️  构造 - 由函数"))
        data.add(ContentLayoutAdapter.LayType("     通过使用计算其元素的函数来构建序列"))
        data.add(ContentLayoutAdapter.LayType("     要基于函数构建序列，请以该函数作为参数调用 generateSequence()"))
        data.add(ContentLayoutAdapter.LayType("     (可选）可以将第一个元素指定为显式值或函数调用的结果。 当提供的函数返回 null 时，序列生成停止。"))
        data.add(ContentLayoutAdapter.LayType("♦️  构造 - 由组块"))
        data.add(ContentLayoutAdapter.LayType("     有一个函数可以逐个或按任意大小的组块生成序列元素——sequence() 函数。 "))
        data.add(ContentLayoutAdapter.LayType("     此函数采用一个 lambda 表达式，其中包含 yield() 与 yieldAll() 函数的调用。"))
        data.add(ContentLayoutAdapter.LayType("     将一个元素返回给序列使用者，并暂停 sequence() 的执行，直到使用者请求下一个元素。"))
        data.add(ContentLayoutAdapter.LayType("     - yield() 使用单个元素作为参数；yieldAll() 中可以采用 Iterable 对象、Iterable 或其他 Sequence。"))
        data.add(ContentLayoutAdapter.LayType("     - yieldAll() 的 Sequence 参数可以是无限的。 当然，这样的调用必须是最后一个：之后的所有调用都永远不会执行。"))

        data.add(ContentLayoutAdapter.LayType("♦️  序列操作"))
        data.add(ContentLayoutAdapter.LayType("     - 无状态 操作不需要状态，并且可以独立处理每个元素，例如 map() 或 filter()。"))
        data.add(ContentLayoutAdapter.LayType("       无状态操作还可能需要少量常数个状态来处理元素，例如 take() 与 drop()。"))
        data.add(ContentLayoutAdapter.LayType("     - 有状态 操作需要大量状态，通常与序列中元素的数量成比例。"))
        data.add(ContentLayoutAdapter.LayType("     如果序列操作返回延迟生成的另一个序列，则称为 中间序列。 否则，该操作为 末端 操作。 末端操作的示例为 toList() 或 sum()。只能通过末端操作才能检索序列元素。 "))
        data.add(ContentLayoutAdapter.LayType("     序列可以多次迭代；但是，某些序列实现可能会约束自己仅迭代一次"))

        data.add(ContentLayoutAdapter.LayType("♦️  序列处理示例"))
        data.add(ContentLayoutAdapter.LayType("     Iterable 与 Sequence 之间的区别"))
        data.add(ContentLayoutAdapter.LayType("     个人理解（看官方示例）"))
        data.add(ContentLayoutAdapter.LayType("     - Iterable一次操作，重新组合成一种集合；Sequence最后toList时，再进行所有操作"))
        data.add(ContentLayoutAdapter.LayType("     - Iterable一次操作，处理一次所有元素；Sequence一个元素处理一次"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        simple()
    }

    private fun simple() {
        //由元素
        val numbersSequence = sequenceOf("four", "three", "two", "one")
        //由 Iterable
        val numbers = listOf("one", "two", "three", "four")
        val numbersListSequence = numbers.asSequence()

        //由函数
        //无限
        val oddNumbers = generateSequence(1) { it + 2 } // `it` 是上一个元素
        println(oddNumbers.take(5).toList())
        //println(oddNumbers.count())     // 错误：此序列是无限的。
        //有限
        val oddNumbersLessThan10 = generateSequence(1) { if (it < 10) it + 2 else null }
        println(oddNumbersLessThan10.count())

        //由组块
        val oddBlockNumbers = sequence {
            yield(1)
            yieldAll(listOf(3, 5))
            yieldAll(generateSequence(7) { it + 2 })
        }
        println(oddBlockNumbers.take(5).toList())

        //序列处理示例
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
        val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)

        println("Lengths of first 4 words longer than 3 chars:")
        println(lengthsList)

        // 将列表转换为序列
        val wordsSequence = words.asSequence()

        val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)

        println("Lengths of first 4 words longer than 3 chars")
        // 末端操作：以列表形式获取结果。
        println(lengthsSequence.toList())
    }
}