package com.rocker.kotlinstudy.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * 基础适配器
 */
abstract class BaseRecAdapter<T> constructor(context: Context) : RecyclerView.Adapter<VBViewHolder>() {
    val inflater : LayoutInflater = LayoutInflater.from(context)
    var data : List<T>? = null

    override fun getItemCount() : Int = data?.size?: 0
}