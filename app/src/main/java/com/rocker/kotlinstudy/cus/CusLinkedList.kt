package com.rocker.kotlinstudy.cus

class CusLinkedList<E> : CusAbstractList<E>() {
    var first: Node<E>? = null

    class Node<E>(var element: E?, var next: Node<E>? = null)

    override fun clear() {
        size = 0
        first = null
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
            first = Node(element)
            return
        }
        var temp: Node<E>? = first
        for(i in 0 until size){
            if(i == size - 1){
                temp!!.next = Node(element)
                break
            } else
                temp = temp!!.next
        }
        size ++
    }

    override fun get(index: Int): E? {
        rangeCheck(index)
        var temp: Node<E>? = first
        for(i in 0 until size){
            if(i == index)
                return temp!!.element
            else
                temp = temp!!.next
        }
        return null
    }

    override fun set(index: Int, element: E): E? {
        rangeCheck(index)
        var temp: Node<E>? = first
        for(i in 0 until size){
            if(i == index){
                val last: E? = temp!!.element
                temp.element = element
                return last
            } else
                temp = temp!!.next
        }
        return null
    }

    override fun add(index: Int, element: E?) {
        rangeCheck(index)
        var temp: Node<E>? = first
        for(i in 0 until size){
            if(i == index){
                val last: E? = temp!!.element
                temp.element = element
                temp.next = Node(last, temp.next)
            } else
                temp = temp!!.next
        }
        size ++
    }

    override fun remove(index: Int): E? {//todo element有问题
        rangeCheck(index)
        size --
        var temp: Node<E>? = first
        if(index == 0){
            first = if(size > 1)
                first!!.next
            else
                null
            return temp!!.element
        }
        for(i in 0 until size){
            if(i == index){
                if(i == size - 1){
                    temp!!.next = temp.next!!.next
                    return temp.element
                }else{
                    temp!!.next = null
                    return temp.element
                }
            } else
                temp = temp!!.next
        }
        return null
    }

    override fun indexOf(element: E?): Int {
        var temp: Node<E>? = first
        for(i in 0 until size){
            if(temp!!.element == element){
                return i
            } else
                temp = temp.next
        }
        return ELEMENT_NOT_FOUND
    }


}