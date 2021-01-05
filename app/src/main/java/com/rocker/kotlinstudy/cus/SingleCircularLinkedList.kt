package com.rocker.kotlinstudy.cus

/**
 * 单向循环链表
 */
class SingleCircularLinkedList<E> : SingleLinkedList<E>() {
    private var end: Node<E>? = null

    override fun clear() {
        size = 0
        first = null
        end = null
    }

    @Override
    override fun add(element: E?) {
        if(size == 0){
            first = Node(element, null)
            end = first
            first!!.next = end
            size ++
            return
        }
        val temp: Node<E>? = end
        end = Node(element, first)
        temp!!.next = end
        size ++
    }

    @Override
    override fun add(index: Int, element: E?) {
        if(index == size){
            add(element)
            return
        }
        rangeCheck(index)
        var temp = first
        if(index == 0){
            first = Node(element, temp)
            return
        }
        for(i in 0 until size){
            if(i == index){
                val last: E? = temp!!.element
                temp.element = element
                temp.next = Node(last, temp.next)
                break
            } else
                temp = temp!!.next
        }
        size ++
    }

    @Override
    override fun remove(index: Int): E? {
        rangeCheck(index)
        var temp = first
        if(index == 0){
            if(size > 1){
                first = temp!!.next
                end?.next = first
            } else{
                first = null
                end = null
            }
            size --
            return temp!!.element
        }
        for(i in 0 until size){
            if(i == index - 1){
                val delete = temp!!.next
                size --
                return if(i != size - 1){
                    temp.next = delete!!.next
                    delete.element
                }else{
                    temp.next = null
                    end = temp
                    delete!!.element
                }
            } else
                temp = temp!!.next
        }
        return null
    }
}