package com.rocker.kotlinstudy.ui.activity.basic

import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 基本类型
 */
class BasicTypesActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.basicTypes
    }

    override fun initLoad() {
        loadBinding.rvContent.layoutManager = LinearLayoutManager(this)
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
        loadBinding.rvContent.adapter = adapter

//        noConvertExample(int) //不能进行隐式类型转换
        boxSimple()
        stringSimple()
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
    fun boxSimple(){
        //在 Java 平台数字是物理存储为 JVM 的原生类型
        val b: Int = 13
        println("a: ${b === b}")
        val boxA: Int = b
        val boxB: Int = b
        println("boxA === boxB = ${boxA === boxB}")
        //列外：除非我们需要一个可空的引用（如 Int?）或泛型
        val a: Int = 10000
        println("a: ${a === a}")
        val boxC: Int? = a
        val boxD: Int? = a
        println("boxC === boxD = ${boxC === boxD}") //测试，当a = 13时，为true, 为10000时，为false
        //它保留了相等性
        println("boxC == boxD = ${boxC == boxD}")
    }

    //________________________________________显示转换
    //每个数字类型支持如下的转换:
    //toByte(): Byte
    //toShort(): Short
    //toInt(): Int
    //toLong(): Long
    //toFloat(): Float
    //toDouble(): Double
    //toChar(): Char
    fun explicitConversion(){
        // 假想的代码，实际上并不能编译：
        val a: Int = 1 // 一个装箱的 Int (java.lang.Integer)
//        val b: Long? = a // kotlin精确，不能进行这样的转换

        val c: Long = a.toLong() // 显示转换类型
    }

    //________________________________________运算
    /**
     * 运算
     * + - * / %
     */
    fun operation(){
        println(5 / 2 == 2) // 整数间的除法总是返回整数
        println(5L / 2 == 2L) // 整数间的除法总是返回整数
        println((5 / 2).toDouble())//需要浮点型，则需要显示转换
    }

    //________________________________________位运算
    /**
     * 位运算
        shl(bits) – 有符号左移
        shr(bits) – 有符号右移
        ushr(bits) – 无符号右移
        and(bits) – 位与
        or(bits) – 位或
        xor(bits) – 位异或
        inv() – 位非
     */
    fun bitWise(){
        println((1 shr 2 ) and 0x000FF000)
    }

    //________________________________________浮点数比较
    //相等性检测：a == b 与 a != b
    //比较操作符：a < b、 a > b、 a <= b、 a >= b
    //区间实例以及区间检测：a..b、 x in a..b、 x !in a..b
    //当其中的操作数 a 与 b 都是静态已知的 Float 或 Double 或者它们对应的可空类型（声明为该类型，或者推断为该类型，或者智能类型转换的结果是该类型），两数字所形成的操作或者区间遵循 IEEE 754 浮点运算标准。
    //
    //然而，为了支持泛型场景并提供全序支持，当这些操作数并非静态类型为浮点数（例如是 Any、 Comparable<……>、 类型参数）时，这些操作使用为 Float 与 Double 实现的不符合标准的 equals 与 compareTo，这会出现：
    //
    //认为 NaN 与其自身相等
    //认为 NaN 比包括正无穷大（POSITIVE_INFINITY）在内的任何其他元素都大
    //认为 -0.0 小于 0.0

    //________________________________________字符
    //字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 与 \$。 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。

    //________________________________________布尔
    //布尔用 Boolean 类型表示，它有两个值：true 与 false。
    //
    //若需要可空引用布尔会被装箱。
    //
    //内置的布尔运算有：
    //
    //|| – 短路逻辑或
    //&& – 短路逻辑与
    //! - 逻辑非


    //________________________________________数组
    fun arraySimple(){
        //创建并赋值
        val a = arrayOf(1, 2, 3)
        //创建，不赋值，可指定大小
        val b = arrayOfNulls<Int>(3)

        // 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
        val asc = Array(5) { i -> (i * i).toString() }
        asc.forEach { println(it) }
        //todo 不懂
        //Kotlin 中数组是不型变的（invariant）。
        // 这意味着 Kotlin 不让我们把 Array<String> 赋值给 Array<Any>，以防止可能的运行时失败
        // （但是你可以使用 Array<out Any>, 参见类型投影）

        //原生类型数组
        // 大小为 5、值为 [0, 0, 0, 0, 0] 的整型数组
        val arr0 = IntArray(5)
        // 例如：用常量初始化数组中的值
        // 大小为 5、值为 [42, 42, 42, 42, 42] 的整型数组
        val arr1 = IntArray(5) { 42 }
        // 例如：使用 lambda 表达式初始化数组中的值
        // 大小为 5、值为 [0, 1, 2, 3, 4] 的整型数组（值初始化为其索引值）
        var arr2 = IntArray(5) { it * 1 }
    }


    //________________________________________无符号整型
    //________________________________________特化的类
    //________________________________________字面值
    fun unSignedSimple(){
        val b: UByte = 1u  // UByte，已提供预期类型
        val s: UShort = 1u // UShort，已提供预期类型
        val l: ULong = 1u  // ULong，已提供预期类型

        val a1 = 42u // UInt：未提供预期类型，常量适于 UInt
        val a2 = 0xFFFF_FFFF_FFFFu // ULong：未提供预期类型，常量不适于 UInt
    }
    //________________________________________无符号整型的实验性状态


    //________________________________________字符串
    fun stringSimple(){
        val string: String = "12345"
        println(string[0])//索引
        for(i in string) //遍历
            println(i)
        //用+来连接字符串
        val s = "abc" + 1
        println(s + "def")

        //转义字符串
        val a = "Hello, world!\n"
        print(a)
        //原始字符串 使用三个引号（"""）分界符括起来，内部没有转义并且可以包含换行以及任何其他字符:
        val text = """
            for (c in "foo")
                print(c)\n
            """
        println(text)
        //你可以通过 trimMargin() 函数去除前导空格：
        //默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")
        val text0 = """
            |Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            |(Benjamin Franklin)
            """.trimMargin()
        println(text0)
        //原始字符串与转义字符串内部都支持模板。 如果你需要在原始字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
        val price = """
            ${'$'}9.99
            """
        println(price)
    }
}