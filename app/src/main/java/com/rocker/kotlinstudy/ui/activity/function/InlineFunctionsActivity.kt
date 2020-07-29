package com.rocker.kotlinstudy.ui.activity.function

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.ui.BaseActivity
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 内联函数
 */
class InlineFunctionsActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.inlineFunctions
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("     在许多情况下通过内联化 lambda 表达式可以消除这类的开销(使用高阶函数会带来一些运行时的效率损失)"))
        data.add(ContentLayoutAdapter.LayType("     inline 修饰符影响函数本身和传给它的 lambda 表达式：所有这些都将内联到调用处"))
        data.add(ContentLayoutAdapter.LayType("     内联可能导致生成的代码增加；不过如果我们使用得当（即避免内联过大函数），性能上会有所提升，尤其是在循环中的“超多态（megamorphic）”调用处。"))
        data.add(ContentLayoutAdapter.LayType("♦️  禁用内联"))
        data.add(ContentLayoutAdapter.LayType("     希望只内联一部分传给内联函数的 lambda 表达式参数，那么可以用 noinline 修饰符标记不希望内联的函数参数"))
        data.add(ContentLayoutAdapter.LayType("     内联的 lambda 表达式只能在内联函数内部调用或者作为可内联的参数传递， 但是 noinline 的可以以任何我们喜欢的方式操作：存储在字段中、传送它等等"))
        data.add(ContentLayoutAdapter.LayType("     一个内联函数没有可内联的函数参数并且没有具体化的类型参数，编译器会产生一个警告，因为内联这样的函数很可能并无益处（如果你确认需要内联，则可以用 @Suppress(\"NOTHING_TO_INLINE\") 注解关掉该警告）"))
        data.add(ContentLayoutAdapter.LayType("♦️  非局部返回"))
        data.add(ContentLayoutAdapter.LayType("     只能对具名或匿名函数使用正常的、非限定的 return 来退出"))
        //即lambda表达式中不能单独用return返回，return后面要加@标签
        data.add(ContentLayoutAdapter.LayType("     退出一个 lambda 表达式，我们必须使用一个标签，并且在 lambda 表达式内部禁止使用裸 return，因为 lambda 表达式不能使包含它的函数返回"))
        data.add(ContentLayoutAdapter.LayType("     如果 lambda 表达式传给的函数是内联的，该 return 也可以内联，所以它是允许的"))
        data.add(ContentLayoutAdapter.LayType("     这种返回（位于 lambda 表达式中，但退出包含它的函数）称为非局部返回"))
        data.add(ContentLayoutAdapter.LayType("     一些内联函数可能调用传给它们的不是直接来自函数体、而是来自另一个执行上下文的 lambda 表达式参数，例如来自局部对象或嵌套函数。在这种情况下，该 lambda 表达式中也不允许非局部控制流。为了标识这种情况，该 lambda 表达式参数需要用 crossinline 修饰符标记"))
        data.add(ContentLayoutAdapter.LayType("     参数传给我们的一个类型"))
        data.add(ContentLayoutAdapter.LayType("♦️  具体化的类型参数"))
        data.add(ContentLayoutAdapter.LayType("     当方法传递的参数是一个类型时"))
        data.add(ContentLayoutAdapter.LayType("     普通的函数（未标记为内联函数的）不能有具体化参数。 不具有运行时表示的类型（例如非具体化的类型参数或者类似于Nothing的虚构类型） 不能用作具体化的类型参数的实参。"))
        data.add(ContentLayoutAdapter.LayType("♦️  内联属性（自 1.1 起）"))
        data.add(ContentLayoutAdapter.LayType("     inline 修饰符可用于没有幕后字段的属性的访问器"))
        data.add(ContentLayoutAdapter.LayType("     标注独立的属性访问器:inline get() = ... / inline set(v){}"))
        data.add(ContentLayoutAdapter.LayType("     标注整个属性:inline var bar: Bar"))

        data.add(ContentLayoutAdapter.LayType("♦️  公有 API 内联函数的限制"))
        data.add(ContentLayoutAdapter.LayType("     公有 API 内联函数体内不允许使用非公有声明，即，不允许使用 private 与 internal 声明以及其部件"))
        data.add(ContentLayoutAdapter.LayType("     一个 internal 声明可以由 @PublishedApi 标注，这会允许它在公有 API 内联函数中使用"))
        data.add(ContentLayoutAdapter.LayType("     当一个 internal 内联函数标记有 @PublishedApi 时，也会像公有函数一样检测其函数体"))


        adapter.data = data
        adapter.notifyDataSetChanged()

        findParentOfType(BaseActivity::class.java)
        findParentOfType<BaseLoadListActivity>()
    }

    //该方法参数是一个类型
    fun <T> findParentOfType(clazz: Class<T>): T? {
        var p = parent
        while (p != null && !clazz.isInstance(p)) {
            p = p.parent
        }
        @Suppress("UNCHECKED_CAST")
        return p as T?
    }
    //内联函数支持具体化的类型参数
    inline fun <reified T> findParentOfType(): T? {
        var p = parent
        while (p != null && p !is T) {
            p = p.parent
        }
        return p as T?
    }


    //crossinline的使用
    inline fun f(crossinline body: () -> Unit) {
        val f = object: Runnable {
            override fun run() = body()
        }
        // ……
    }

    //非局部返回
    fun hasZeros(ints: List<Int>): Boolean {
        ints.forEach {
            if (it == 0) return true // 从 hasZeros 返回
        }
        return false
    }

    //内联函数
    inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit){

    }

}