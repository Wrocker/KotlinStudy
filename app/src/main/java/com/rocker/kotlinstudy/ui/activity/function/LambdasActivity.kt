package com.rocker.kotlinstudy.ui.activity.function

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

class LambdasActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.lambdas
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️  高阶函数与 lambda 表达式"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 函数都是头等的"))//理解为能像参数一样使用函数
        data.add(ContentLayoutAdapter.LayType("     可以存储在变量与数据结构中、作为参数传递给其他高阶函数以及从其他高阶函数返回"))

        data.add(ContentLayoutAdapter.LayType("♦️  高阶函数"))
        data.add(ContentLayoutAdapter.LayType("    高阶函数是将函数用作参数或返回值的函数。"))
        data.add(ContentLayoutAdapter.LayType("♦️  函数类型"))
        data.add(ContentLayoutAdapter.LayType("     使用类似 (Int) -> String 的一系列函数类型来处理函数的声明"))
        data.add(ContentLayoutAdapter.LayType("     函数类型表示法可以选择性地包含函数的参数名：(x: Int, y: Int) -> Point。 这些名称可用于表明参数的含义。"))
        data.add(ContentLayoutAdapter.LayType("     - 所有函数类型都有一个圆括号括起来的参数类型列表以及一个返回类型：(A, B) -> C 表示接受类型分别为 A 与 B 两个参数并返回一个 C 类型值的函数类型。 参数类型列表可以为空，如 () -> A。Unit 返回类型不可省略。"))
        data.add(ContentLayoutAdapter.LayType("     - 函数类型可以有一个额外的接收者类型，它在表示法中的点之前指定： 类型 A.(B) -> C 表示可以在 A 的接收者对象上以一个 B 类型参数来调用并返回一个 C 类型值的函数。"))
        data.add(ContentLayoutAdapter.LayType("     - 挂起函数属于特殊种类的函数类型，它的表示法中有一个 suspend 修饰符 ，例如 suspend () -> Unit 或者 suspend A.(B) -> C。"))
        data.add(ContentLayoutAdapter.LayType("     函数类型表示法可以选择性地包含函数的参数名：(x: Int, y: Int) -> Point。 这些名称可用于表明参数的含义。"))
        data.add(ContentLayoutAdapter.LayType("     - 如需将函数类型指定为可空，请使用圆括号：((Int, Int) -> Int)?"))
        data.add(ContentLayoutAdapter.LayType("     - 函数类型可以使用圆括号进行接合：(Int) -> ((Int) -> Unit)"))
        data.add(ContentLayoutAdapter.LayType("     - 箭头表示法是右结合的，(Int) -> (Int) -> Unit 与前述示例等价，但不等于 ((Int) -> (Int)) -> Unit。"))
        data.add(ContentLayoutAdapter.LayType("     可以通过使用类型别名给函数类型起一个别称"))
        data.add(ContentLayoutAdapter.LayType("♦️  函数类型实例化"))
        data.add(ContentLayoutAdapter.LayType("     有几种方法可以获得函数类型的实例"))
        data.add(ContentLayoutAdapter.LayType("     - 使用函数字面值的代码块，采用以下形式之一"))
        data.add(ContentLayoutAdapter.LayType("         _lambda 表达式: { a, b -> a + b }"))
        data.add(ContentLayoutAdapter.LayType("         _匿名函数: fun(s: String): Int { return s.toIntOrNull() ?: 0 }"))
        data.add(ContentLayoutAdapter.LayType("         _带有接收者的函数字面值可用作带有接收者的函数类型的值"))
        data.add(ContentLayoutAdapter.LayType("     - 使用已有声明的可调用引用"))
        data.add(ContentLayoutAdapter.LayType("         _顶层、局部、成员、扩展函数：::isOdd、 String::toInt"))
        data.add(ContentLayoutAdapter.LayType("         _顶层、成员、扩展属性：List<Int>::size"))
        data.add(ContentLayoutAdapter.LayType("         _构造函数：::Regex"))
        data.add(ContentLayoutAdapter.LayType("         这包括指向特定实例成员的绑定的可调用引用：foo::toString"))
        data.add(ContentLayoutAdapter.LayType("     - 使用实现函数类型接口的自定义类的实例"))
        data.add(ContentLayoutAdapter.LayType("     有足够信息，编译器可以推断变量的函数类型"))
        data.add(ContentLayoutAdapter.LayType("     带与不带接收者的函数类型非字面值可以互换，其中接收者可以替代第一个参数，反之亦然。"))
        data.add(ContentLayoutAdapter.LayType("♦️  函数类型实例调用"))
        data.add(ContentLayoutAdapter.LayType("     函数类型的值可以通过其 invoke(……) 操作符调用：f.invoke(x) 或者直接 f(x)。"))
        data.add(ContentLayoutAdapter.LayType("     如果该值具有接收者类型，那么应该将接收者对象作为第一个参数传递"))
        data.add(ContentLayoutAdapter.LayType("     调用带有接收者的函数类型值的另一个方式是在其前面加上接收者对象， 就好比该值是一个扩展函数：1.foo(2)"))
        data.add(ContentLayoutAdapter.LayType("♦️  内联函数"))

        data.add(ContentLayoutAdapter.LayType("♦️  Lambda 表达式与匿名函数"))
        data.add(ContentLayoutAdapter.LayType("     lambda 表达式与匿名函数是“函数字面值”，即未声明的函数， 但立即做为表达式传递"))
        data.add(ContentLayoutAdapter.LayType("♦️  Lambda 表达式语法"))
        data.add(ContentLayoutAdapter.LayType("     Lambda 表达式的完整语法形式如下"))
        data.add(ContentLayoutAdapter.LayType("     val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }"))
        data.add(ContentLayoutAdapter.LayType("     lambda 表达式总是括在花括号中， 完整语法形式的参数声明放在花括号内，并有可选的类型标注， 函数体跟在一个 -> 符号之后。"))
        data.add(ContentLayoutAdapter.LayType("     如果推断出的该 lambda 的返回类型不是 Unit，那么该 lambda 主体中的最后一个（或可能是单个） 表达式会视为返回值。"))
        data.add(ContentLayoutAdapter.LayType("     如果我们把所有可选标注都留下，看起来如下"))
        data.add(ContentLayoutAdapter.LayType("     val sum = { x: Int, y: Int -> x + y }"))
        data.add(ContentLayoutAdapter.LayType("♦️  传递末尾的 lambda 表达式"))
        data.add(ContentLayoutAdapter.LayType("     拖尾 lambda 表达式：如果函数的最后一个参数是函数，那么作为相应参数传入的 lambda 表达式可以放在圆括号之外"))
        data.add(ContentLayoutAdapter.LayType("     如果该 lambda 表达式是调用时唯一的参数，那么圆括号可以完全省略"))
        data.add(ContentLayoutAdapter.LayType("♦️  it：单个参数的隐式名称"))
        data.add(ContentLayoutAdapter.LayType("     如果编译器自己可以识别出签名，也可以不用声明唯一的参数并忽略 ->。 该参数会隐式声明为 it"))
        data.add(ContentLayoutAdapter.LayType("♦️  从 lambda 表达式中返回一个值"))
        data.add(ContentLayoutAdapter.LayType("     我们可以使用限定的返回语法从 lambda 显式返回一个值。 否则，将隐式返回最后一个表达式的值。"))
        data.add(ContentLayoutAdapter.LayType("♦️  下划线用于未使用的变量（自 1.1 起）"))
        data.add(ContentLayoutAdapter.LayType("     map.forEach { _, value -> println(value!) }"))
        data.add(ContentLayoutAdapter.LayType("♦️  在 lambda 表达式中解构（自 1.1 起）"))//结构声明

        data.add(ContentLayoutAdapter.LayType("♦️  匿名函数"))
        data.add(ContentLayoutAdapter.LayType("     lambda 表达式语法缺少的一个东西是指定函数的返回类型的能力,在大多数情况下,返回类型可以自动推断出来"))
        data.add(ContentLayoutAdapter.LayType("     如果确实需要显式指定，可以使用另一种语法： 匿名函数"))
        data.add(ContentLayoutAdapter.LayType("     匿名函数参数总是在括号内传递。"))
        data.add(ContentLayoutAdapter.LayType("     Lambda表达式与匿名函数之间的另一个区别是非局部返回的行为"))

        data.add(ContentLayoutAdapter.LayType("♦️  闭包"))
        data.add(ContentLayoutAdapter.LayType("     Lambda 表达式或者匿名函数（以及局部函数和对象表达式） 可以访问其 闭包 ，即在外部作用域中声明的变量。"))
        data.add(ContentLayoutAdapter.LayType("     在 lambda 表达式中可以修改闭包中捕获的变量"))

        data.add(ContentLayoutAdapter.LayType("♦️  带有接收者的函数字面值"))
        data.add(ContentLayoutAdapter.LayType("     带有接收者的函数类型，例如 A.(B) -> C，可以用特殊形式的函数字面值实例化—— 带有接收者的函数字面值。"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin 提供了调用带有接收者（提供接收者对象）的函数类型实例的能力。"))
        //在这样的函数字面值内部，传给调用的接收者对象成为隐式的this，以便访问接收者对象的成员而无需任何额外的限定符，亦可使用 this 表达式 访问接收者对象。
        //理解为A.(B) -> C中C可以调用A的其他方法
        data.add(ContentLayoutAdapter.LayType("     当接收者类型可以从上下文推断时，lambda 表达式可以用作带接收者的函数字面值。"))

        //
        adapter.data = data
        adapter.notifyDataSetChanged()

        //调用方法内方法
        val simpleSum: Int.(Int) -> Int = { other -> plus(other) }
        //匿名函数语法允许你直接指定函数字面值的接收者类型。 如果你需要使用带接收者的函数类型声明一个变量，并在之后使用它，这将非常有用。
        val simpleSum2 = fun Int.(other: Int): Int = this + other
        //当接收者类型可以从上下文推断时，lambda 表达式可以用作带接收者的函数字面值。
//        class HTML {  todo 没懂
//            fun body() { …… }
//        }
//
//        fun html(init: HTML.() -> Unit): HTML {
//            val html = HTML()  // 创建接收者对象
//            html.init()        // 将该接收者对象传给该 lambda
//            return html
//        }
//
//        html {       // 带接收者的 lambda 由此开始
//            body()   // 调用该接收者对象的一个方法
//        }


        //匿名函数
        doSth("匿名函数", fun(string): String {
            println("打印$string")
            return "print $string"
        })
        //参数和返回类型的指定方式与常规函数相同，除了能够从上下文推断出的参数类型可以省略
        //ints.filter(fun(item) = item > 0)

        //拖尾 lambda 表达式
        doSth("haha"){
                string ->
            println("打印$string")
            "print $string"
        }

        //max(strings, { a, b -> a.length < b.length })
        //函数 max 是一个高阶函数，它接受一个函数作为第二个参数。 其第二个参数是一个表达式，它本身是一个函数，即函数字面值，它等价于以下具名函数：
        //fun compare(a: String, b: String): Boolean = a.length < b.length

        //实例的调用
        //stringPlus是该Lambda表达式的名称
        val stringPlus: (String, String) -> String = String::plus

        println(stringPlus.invoke("<-", "->"))//f.invoke(x)
        println(stringPlus("Hello, ", "world!"))//f(x)
        //如果该值具有接收者类型，那么应该将接收者对象作为第一个参数传递。 调用带有接收者的函数类型值的另一个方式是在其前面加上接收者对象， 就好比该值是一个扩展函数：1.foo(2)
        val intPlus: Int.(Int) -> Int = Int::plus
        println(intPlus.invoke(1, 1))
        println(intPlus(1, 2))
        println(2.intPlus(3)) // 类扩展调用

        //右结合法 todo 例子
//        doSth("右结合", {
//            string
//            -> println("打印$string")
//            "$string 1"
//            -> println("打印$string")
//            "$string 2"
//        })

        //高阶函数
        doSth("内容", {
            string ->
            println("打印$string")
            "print $string"
        })
        //高阶函数 官方的例子
        val items = listOf(1, 2, 3, 4, 5)
        // Lambdas 表达式是花括号括起来的代码块。
        items.fold(0, {
            // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
                acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i
            println("result = $result")
            // lambda 表达式中的最后一个表达式是返回值：
            result
        })
        // lambda 表达式的参数类型是可选的，如果能够推断出来的话：
        val joinedToString = items.fold("Elements:", { acc, i -> "$acc $i" })
        // 函数引用也可以用于高阶函数调用
        val product = items.fold(1, Int::times)//Int::times的意思是 3.times(2)表示3的几倍

        //Lambda表达式
        //it：单个参数的隐式名称
        items.filter { it > 0 } // 这个字面值是“(it: Int) -> Boolean”类型的
        //以使用限定的返回语法从 lambda 显式返回一个值。 否则，将隐式返回最后一个表达式的值。
        items.filter {
            val shouldFilter = it > 0
            shouldFilter
        }
        items.filter {
            val shouldFilter = it > 0
            return@filter shouldFilter
        }
        //可以使用限定的返回语法从 lambda 显式返回一个值。这一约定连同在圆括号外传递 lambda 表达式一起支持 LINQ-风格 的代码
        items.filter { it > 0 }.sortedBy { it }.map { it.plus(2) }

        //在 lambda 表达式中可以修改闭包中捕获的变量
        var sum = 0
        items.filter { it > 0 }.forEach {
            sum += it
        }
        print(sum)
    }

    //带与不带接收者的函数类型非字面值可以互换，其中接收者可以替代第一个参数，反之亦然。todo 没懂
    //例如，(A, B) -> C 类型的值可以传给或赋值给期待 A.(B) -> C 的地方，反之亦然
    //默认情况下推断出的是没有接收者的函数类型，即使变量是通过扩展函数引用来初始化的。 如需改变这点，请显式指定变量类型。
    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun // OK

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }

    val result = runTransformation(repeatFun) // OK

    //编译器可以推断变量的函数类型
    val simpleA = {i: Int -> i + 5}

    //使用实现函数类型接口的自定义类的实例
    val intFunction: (Int) -> Int = IntTransformer()

    class IntTransformer: (Int) -> Int {
        override operator fun invoke(x: Int): Int = x + 1000
    }

    //高阶函数
    fun doSth(string: String, action: (string: String) -> String){
        action(string)
    }
}

//类型别名给表达式起别称
typealias ClickHandler = (String, Int) -> Unit