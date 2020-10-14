package com.rocker.kotlinstudy.cus

/**
 * 列表应该有的方法
 */
interface CusList<E> {

    /**
     * 清除所有元素
     */
    fun clear()

    /**
     * 元素的数量
     * @return
     */
    fun size(): Int

    /**
     * 是否为空
     * @return
     */
    fun isEmpty(): Boolean

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    fun contains(element: E?): Boolean

    /**
     * 添加元素到尾部
     * @param element
     */
    fun add(element: E?)

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    fun get(index: Int): E?

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    fun set(index: Int,element: E): E?

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    fun add(index: Int,element: E?)

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    fun remove(index: Int): E?

    /**
     * 查看元素的索引
     * @param element 元素
     * @return 索引
     */
    fun indexOf(element: E?): Int
}