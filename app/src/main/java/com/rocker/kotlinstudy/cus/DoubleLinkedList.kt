package com.rocker.kotlinstudy.cus

import com.rocker.kotlinstudy.util.LogUtil

/**
 * 双向链表
 */
class DoubleLinkedList<E> : CusAbstractList<E>() {
    private var first: Node<E>? = null
    private var end: Node<E>? = null

    private class Node<E>(var element: E?, var prev: Node<E>?, var next: Node<E>?){
        override fun toString(): String {
            return "|prev:${prev?.element} -> $element -> next:${next?.element}|"
        }
    }

    override fun clear() {
        size = 0
        first = null
        end = null
    }

    override fun contains(element: E?): Boolean {
        if(size == 0)
            return false
        var temp: Node<E>? = first
        for(i in 0 until size){
            if(temp!!.element == element)
                return true
            temp = temp.next
        }
        return false
    }

    override fun add(element: E?) {
        if(size == 0){
            first = Node(element, null, null)
            end = first
            size ++
            return
        }
        val temp = end
        end = Node(element, temp, null)
        temp!!.next = end
        size ++
    }

    override fun get(index: Int): E? {
        rangeCheck(index)
        return nodeOf(index)?.element
    }

    override fun set(index: Int, element: E): E? {
        rangeCheck(index)
        val current = nodeOf(index)
        val temp = current!!.element
        current.element = element
        return temp
    }

    override fun add(index: Int, element: E?) {
        rangeCheck(index)
        val current = nodeOf(index)
        val prev = current!!.prev
        val temp = Node(element, prev, current)
        current.prev = temp
        size ++
    }

    override fun remove(index: Int): E? {
        rangeCheck(index)
        val remove: Node<E> = nodeOf(index) ?: return null
        val prev = remove.prev
        val next = remove.next
        if(prev == null){
            first = next
            next?.prev = null
        } else{
            prev.next = next
            next?.prev = prev
        }
        if(end == remove)
            end = prev?.next
        size --
        return remove.element
    }

    override fun indexOf(element: E?): Int {
        var temp: Node<E>? = first
        for(i in 0 until size){
            if(temp!!.element == element)
                return i
            else
                temp = temp.next
        }
        return ELEMENT_NOT_FOUND
    }

    private fun nodeOf(index: Int): Node<E>? {
        var temp: Node<E>?
        if(index < size shr 1){
            temp = first
            for(i in 0 until index){
                temp = temp?.next
            }
        }else{
            temp = end
            LogUtil.e("::: $size")
            for(i in (size - 1) downTo index){
                LogUtil.e("index : $i + ${temp?.element}")
                if(i != index)
                    temp = temp?.prev
            }
        }
        return temp
    }

    override fun toString(): String {
        val value = StringBuilder("DoubleLinkedList value is [ ")
        var temp = first
        for(i in 0 until size){
            LogUtil.e("tostring $i")//todo 问题
            value.append(temp)
            temp = temp!!.next
        }
        value.append(" ]")
        value.append(first)
        value.append(end)
        return value.toString()
    }
}