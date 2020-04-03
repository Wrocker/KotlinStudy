package com.rocker.kotlinstudy.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * 基础适配器
 */
abstract class BaseRecAdapter<T> constructor(context: Context) : RecyclerView.Adapter<BaseRecAdapter.VBViewHolder>(), View.OnClickListener {
    val inflater : LayoutInflater = LayoutInflater.from(context)
    var data : List<T>? = null
    lateinit var onItemClickListener: OnItemClickListener

    override fun getItemCount() : Int = data?.size?: 0

    override fun onClick(p0: View?) {
        onItemClickListener.onItemClick(p0)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View?)
    }

    abstract class VBViewHolder(binding : ViewBinding) : RecyclerView.ViewHolder(binding.root)
}