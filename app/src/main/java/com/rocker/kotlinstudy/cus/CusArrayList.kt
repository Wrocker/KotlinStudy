package com.rocker.kotlinstudy.cus

/**
 * 自定义ArrayList
 */
class CusArrayList<E>() : CusAbstractList<E>() {

    val ELEMENT_SIZE_DEFAULT = 10
    var elementSize: Int = ELEMENT_SIZE_DEFAULT

    val ELEMENT_EXPAND_RATE = 0.5

    var elements: Array<Any?>

    constructor(elementSize: Int) : this(){
        this.elementSize = if(elementSize >= 5) elementSize else DEFAULT_BUFFER_SIZE
    }

    init {
        elements = arrayOfNulls(elementSize)
    }

    override fun contains(element: E?): Boolean {
        for(i in 0 until size){
            if(elements[i] == element)
                return true
        }
        return false
    }

    override fun add(element: E?) {
        expandArray(size + 1)
        elements[size] = element
        size ++
    }

    override fun add(index: Int, element: E?) {
        rangeCheck(index)
        expandArray(size + 1)
        for(i in size downTo index){
            if(i == index)
                elements[i] = element
            else
                elements[i] = elements[i - 1]

        }
        size ++
    }

    override fun remove(index: Int): E {
        rangeCheck(index)
        val temp = elements[index]
        for(i in index until size)
            elements[i] = elements[i + 1]
        size --
        return temp as E
    }

    override fun get(index: Int): E {
        rangeCheck(index)
        return elements[index] as E
    }

    override fun set(index: Int, element: E): E {
        rangeCheck(index)
        val last = elements[index]
        elements[index] = element
        return last as E
    }

    override fun indexOf(element: E?): Int {
        for(i in 0 until size){
            if(elements[i] == element)
                return i
        }
        return ELEMENT_NOT_FOUND
    }

    /**
     * 扩容
     */
    private fun expandArray(newSize: Int){
        if(newSize == elements.size){
            val temp = arrayOfNulls<Any>((elementSize * ELEMENT_EXPAND_RATE).toInt())
            elements.mapIndexed { index, any -> temp[index] = any }
            elements = temp
        }
    }

}