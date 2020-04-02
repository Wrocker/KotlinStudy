package com.rocker.kotlinstudy.ui.adapter

import android.content.Context
import android.view.ViewGroup
import com.rocker.kotlinstudy.base.BaseRecAdapter
import com.rocker.kotlinstudy.base.VBViewHolder
import com.rocker.kotlinstudy.databinding.ItemOptionBinding

/**
 * 选项adapter
 */
class OptionItemAdapter(context: Context) : BaseRecAdapter<String>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionHolder {
        return OptionHolder(ItemOptionBinding.inflate(inflater, parent, false))
    }

    class OptionHolder(var optionBinding : ItemOptionBinding) : VBViewHolder(optionBinding){

    }

    override fun onBindViewHolder(holder: VBViewHolder, position: Int) {
        val optionHolder = holder as OptionHolder
        optionHolder.optionBinding.tvOption.text = "balablaba"
    }
}