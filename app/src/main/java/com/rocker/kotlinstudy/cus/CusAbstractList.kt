package com.rocker.kotlinstudy.cus

/**
 * 公共方法
 */
abstract class CusAbstractList<E> : CusList<E> {
    val ELEMENT_NOT_FOUND = -1

    var size = 0

    override fun clear() {
        size = 0
    }

    override fun size(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }


    fun outOfBounds(index: Int) {
        throw IndexOutOfBoundsException("Index:$index, Size:$size");
    }

    fun rangeCheck(index: Int) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

}