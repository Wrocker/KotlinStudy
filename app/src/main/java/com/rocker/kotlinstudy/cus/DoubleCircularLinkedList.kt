package com.rocker.kotlinstudy.cus

/**
 * 双向循环链表
 */
class DoubleCircularLinkedList<E> : DoubleLinkedList<E>() {

    override fun add(element: E?) {
        if(size == 0){
            first = Node(element, null, null)
            first!!.prev = first
            first!!.next = first
            end = first
            size ++
            return
        }
        val temp = end
        end = Node(element, temp, first)
        temp!!.next = end
        first!!.prev = end
        size ++
    }

    /**
     * 临界条件
     * 1、size = 0，index = 0的情况
     * 2、index = size的情况
     */
    override fun add(index: Int, element: E?) {
        if(index != size)
            rangeCheck(index)
        val current = nodeOf(index)
        val prev = current?.prev ?: end
        val temp = Node(element, prev, current ?: first)
        prev?.next = temp
        current?.prev = temp
        if(index == 0){
            first = temp
            end?.next = first
        }
        if(index == size){
            end = temp
            first?.prev = end
        }
        size ++
    }

    override fun remove(index: Int): E? {
        rangeCheck(index)
        val remove: Node<E> = nodeOf(index) ?: return null
        val prev = remove.prev
        val next = remove.next
        prev?.next = next
        next?.prev = prev
        if(first == remove)
            first = next
        if(end == remove)
            end = prev
        size --
        return remove.element
    }

}