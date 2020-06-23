package com.rocker.kotlinstudy.ui.activity.objects

import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.ui.activity.BaseLoadListActivity
import com.rocker.kotlinstudy.ui.adapter.ContentLayoutAdapter

/**
 * 类与继承
 */
class ClassesAndInheritanceActivity : BaseLoadListActivity() {
    override fun initTitle(): Int {
        return R.string.classesAndInheritance
    }

    override fun initContent() {
        val data = ArrayList<ContentLayoutAdapter.LayType>()
        data.add(ContentLayoutAdapter.LayType("♦️ 类"))
        data.add(ContentLayoutAdapter.LayType("     Kotlin中用class申明类"))
        data.add(ContentLayoutAdapter.LayType("     类声明由类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成。"))
        data.add(ContentLayoutAdapter.LayType("     若没有类体，可省略花括号"))
        data.add(ContentLayoutAdapter.LayType("♦️ 包含"))
        data.add(ContentLayoutAdapter.LayType("     构造函数与初始化块"))
        data.add(ContentLayoutAdapter.LayType("     函数"))
        data.add(ContentLayoutAdapter.LayType("     属性"))
        data.add(ContentLayoutAdapter.LayType("     嵌套类与内部类"))
        data.add(ContentLayoutAdapter.LayType("     对象声明"))//todo 这是啥
        data.add(ContentLayoutAdapter.LayType("♦️ 主构造函数"))
        data.add(ContentLayoutAdapter.LayType("      "))
        data.add(ContentLayoutAdapter.LayType("♦️ 次构造函数"))


        data.add(ContentLayoutAdapter.LayType("♦️ 继承"))
        data.add(ContentLayoutAdapter.LayType("      kotlin中所有类都有一个超类Any 可不写"))
        data.add(ContentLayoutAdapter.LayType("      Any 有三个方法：equals()、 hashCode() 与 toString()"))
        data.add(ContentLayoutAdapter.LayType("      默认情况下kotlin中的类被final修饰，无法被继承。需要被继承，则要用open关键字标记"))

        adapter.data = data
        adapter.notifyDataSetChanged()

        //创建类的实例 kotlin没有new关键字
        Student("Li")
        Customer("Lu", Customer("Hei"))
        Animal()

        Derived("史密斯", "威廉")
    }

    class Empty

    //主构造函数 constructor修饰
    class People constructor(firstName: String){}
    //如果主构造函数没有任何注解或者可见性修饰符 constructor可省略（主构造函数的参数,在初始化器中都能使用，但在方法中不能使用）
    class Student (firstName: String){//参数/init 初始化顺序由代码位置前后决定
        //todo also{}的用法
        val first = "first is $firstName".also { println(it) }
        //todo also（）的用法
        val second = "second is $firstName".also (::println)

        init {
            //主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
            println("third $firstName")
        }

        init {
            //主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
            println("fourth $firstName")
        }
    }

    //声明属性以及从主构造函数初始化属性
    class Teacher (val firstName: String)

    //如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面
    class Professor public constructor(name: String)//todo 可见性修饰符怎么放


    //此构造函数有constructor申明
    class Customer(name: String) {
        val theatre: MutableList<Customer> = arrayListOf()

        init {//初始化代码块/初始化变量 语句包含在主构造中，因此先执行
            println("is First $name")
        }

        constructor(name: String, customer: Customer): this(name){//可这样委托到主构造函数/其他构造函数
            customer.theatre.add(this)
            println("add")
        }
    }

    //如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的主构造函数。构造函数的可见性是 public。
    // 如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数：
    class DontCreateMe private constructor ()

    //在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，它将使用默认值。
    class Animal(val name: String = "")



    //_______________________________________继承
    open class OpenDemo//表示开放继承

    open class Fruit(name: String)//超类型/基类
    //冒号表示继承
    class Apple(name: String) : Fruit(name) //派生类 （若派生类有主构造函数，其基类必须用派生类主构造函数中的参数来初始化）

    //在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数：
    class Banana : Fruit{
        //若派生类没有主构造函数，则此构造函数必须用super关键字初始化基类，或委托另一个构造函数做到这点
        constructor(name: String) : super(name)

        constructor(name: String, address: String) : this(name){
            //方法
        }
    }

    //_______________________________________继承 覆盖方法
    //基类的方法，若需要重写，必须加open
    open class Shape {
        //Kotlin 对于可覆盖的成员（我们称之为开放）以及覆盖后的成员需要显式修饰符：
        open fun draw() { /*……*/ }
        fun fill() { /*……*/ }
    }

    class Circle() : Shape() {
        //必须加上 override 修饰符，override修饰的函数，默认为open的
        override fun draw() { /*……*/ }
        //未加open则编译报错
//        fun fill() { /*……*/ }
    }

    open class Rectangle() : Shape() {
        //添加final修饰，静止其派生类重写该方法
        final override fun draw() { /*……*/ }
    }

    //_______________________________________继承 覆盖属性
    open class Phone{
        open val brand: String = "品牌"
    }
    class Samsung : Phone(){
        //在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型。 每个声明的属性可以由具有初始化器的属性或者具有 get 方法的属性覆盖
        override val brand = "三星"
    }

    class CusPhone : Phone(){
        //可以用var覆盖val(因为val有get方法，var相对于get添加了set方法)，反之则不行
        override var brand = "哇哈哈"
    }

    //你可以在主构造函数中使用 override 关键字作为属性声明的一部分。
    open class Iphone(override val brand: String = "苹果") : Phone()

    class IphoneSe : Iphone(){
        override val brand: String
            get() = super.brand
    }

    //_______________________________________继承 派生类初始化顺序
    open class Base(val name: String) {
        init { println("Initializing Base") }//2

        open val size: Int =
            name.length.also { println("Initializing size in Base: $it") }//3
    }

    //在构造派生类的新实例的过程中，第一步完成其基类的初始化（在之前只有对基类构造函数参数的求值），因此发生在派生类的初始化逻辑运行之前。
    //顺序已标出
    //这意味着，基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
    // 如果在基类初始化逻辑中（直接或通过另一个覆盖的 open 成员的实现间接）使用了任何一个这种属性，那么都可能导致不正确的行为或运行时故障。设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
    class Derived(
        name: String,
        val lastName: String
    ) : Base(name.capitalize().also { println("Argument for Base: $it") }) {//1

        init { println("Initializing Derived") }//4

        override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in Derived: $it") }//5
    }

    //_______________________________________继承 调用超类实现
    //派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现：
    open class Desk {
        open fun draw() { println("Drawing a desk") }
        val borderColor: String get() = "black"
    }

    class ComputerDesk : Desk() {
        override fun draw() {
            super.draw()
            println("desk to computer desk")
        }

        val fillColor: String get() = super.borderColor
    }

    //在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
    class BookDesk: Desk() {

        inner class Filler {
            fun fill() { /* …… */ }
            fun drawAndFill() {
                super@BookDesk.draw() // 调用 Rectangle 的 draw() 实现
                fill()
                println("Drawn a filled rectangle with color ${super@BookDesk.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
            }
        }
    }

    //_______________________________________继承 覆盖规则
    //如果一个类从它的直接超类继承相同成员的多个实现， 它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。
    // 为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super，如 super<Base>：
    interface PhoebeZhennan{//接口默认是open的
        fun draw() {}
    }

    class diningDesk : Desk(), PhoebeZhennan{
        override fun draw() {
            super<Desk>.draw() // 调用 Rectangle.draw()
            super<PhoebeZhennan>.draw()
        }
    }

    //_______________________________________抽象类
    //抽象成员在本类中可以不用实现。 需要注意的是，我们并不需要用 open 标注
    abstract class CusDesk : Desk() {
        abstract override fun draw()
    }

    //_______________________________________伴生对象 todo
}