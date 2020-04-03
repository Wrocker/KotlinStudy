package com.rocker.kotlinstudy.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.*

/**
 * 可添加头部局/足布局的adapter
 */
abstract class BaseJRecAdapter<VH : ViewHolder, T>(context: Context?) :
    RecyclerView.Adapter<ViewHolder>(), View.OnClickListener {
    var header: View? = null
    private var footer: View? = null
    private var empty: View? = null
    private var isEmpty = false
    private var isShowEmpty = false
    protected var inflater: LayoutInflater
    protected var onItemClickListener: OnItemClickListener? =
        null
    protected var data: MutableList<T>? = null

    /**
     * 设置数据
     */
    fun setjData(data: MutableList<T>?) {
        this.data = data
        if (isShowEmpty) isEmpty = data == null || data.size == 0
    }

    fun setShowEmpty(showEmpty: Boolean) {
        isShowEmpty = showEmpty
    }

    /**
     * 添加数据
     */
    fun addData(data: List<T>?) {
        if (data == null || data.size == 0)
            return
        if (this.data == null)
            this.data = ArrayList()
        this.data!!.addAll(data)
    }

    /**
     * 点击事件
     */
    override fun onClick(v: View) {
        if (onItemClickListener != null) onItemClickListener!!.onItemClick(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            HEADER -> Holder(
                header!!
            )
            FOOTER -> Holder(
                footer!!
            )
            EMPTY -> Holder(
                getEmpty(parent)!!
            )
            else -> onCreateCusViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var position = position
        when (getItemViewType(position)) {
            HEADER, FOOTER, EMPTY -> {
            }
            else -> {
                if (header != null) position--
                onBindCusViewHolder(holder, position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        var position = position
        return if (isEmpty && position == 0) EMPTY else if (header != null && position == 0) HEADER else if (footer != null && position == itemCount - 1) FOOTER else {
            if (header != null) position--
            getCusItemViewType(position)
        }
    }

    override fun getItemCount(): Int {
        if (isEmpty) return 1
        return if (header != null && footer != null) cusItemCount + 2 else if (header != null) cusItemCount + 1 else if (footer != null) cusItemCount + 1 else cusItemCount
    }

    private fun getEmpty(parent: ViewGroup): View? {
//        if(empty == null)
//            empty = inflater.inflate(R.layout.layout_rec_empty, parent, false);
        return empty
    }

    /**
     * 设置空白显示的view
     */
    fun setEmpty(empty: View?) {
        this.empty = empty
    }

    /**
     * 添加单个数据
     */
    fun addItem(t: T) {
        if (data == null)
            data = ArrayList()
        data!!.add(t)
        notifyCusItemRangeChanged(if (header == null) data!!.size - 1 else data!!.size, 1)
    }

    /**
     * 移除数据
     */
    fun removeItem(deletePositon: Int) {
        data!!.removeAt(deletePositon)
        notifyCusItemRemoved(deletePositon)
        if (deletePositon < data!!.size) notifyCusItemRangeChanged(
            deletePositon,
            data!!.size - deletePositon
        )
    }

    /**
     * 刷新角标
     * @param positionStart 变更位置的角标
     * @param itemCount 数量
     */
    protected fun notifyCusItemRangeChanged(positionStart: Int, itemCount: Int) {
        if (footer != null) notifyItemRangeChanged(
            positionStart,
            itemCount + 1
        ) else notifyItemRangeChanged(positionStart, itemCount)
    }

    /**
     * 删除单个view,盘
     * @param position 位置
     */
    protected fun notifyCusItemRemoved(position: Int) {
        if (header != null) notifyItemRemoved(position + 1) else notifyItemRemoved(position)
    }

    /**
     * 更新单个item
     * @param position 位置
     */
    fun notifyCusItemChanged(position: Int) {
        if (header != null) notifyItemChanged(position + 1) else notifyItemChanged(position)
    }

    /**
     * 创建viewholder
     */
    abstract fun onCreateCusViewHolder(parent: ViewGroup, viewType: Int): VH

    /**
     * 绑定viewholder
     */
    abstract fun onBindCusViewHolder(viewHolder: ViewHolder, position: Int)

    /**
     * 获取类型
     */
    fun getCusItemViewType(position: Int): Int {
        return 0
    }

    /**
     * 返回list数量
     */
    val cusItemCount: Int
        get() = if (data == null) 0 else data!!.size

    fun setFooter(footer: View?) {
        this.footer = footer
    }

    private inner class Holder internal constructor(itemView: View) :
        ViewHolder(itemView)

    interface OnItemClickListener {
        fun onItemClick(view: View?)
    }

    companion object {
        private const val HEADER = -1
        private const val FOOTER = -2
        private const val EMPTY = -3
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}