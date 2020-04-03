package com.rocker.kotlinstudy.ui.adapter

import android.content.Context
import android.view.ViewGroup
import com.rocker.kotlinstudy.base.adapter.BaseRecAdapter
import com.rocker.kotlinstudy.databinding.ItemOptionBinding

/**
 * 选项adapter
 */
class OptionItemAdapter(context: Context) : BaseRecAdapter<String>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionHolder {
        return OptionHolder(ItemOptionBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: VBViewHolder, position: Int) {
        val optionHolder = holder as OptionHolder
        optionHolder.optionBinding.tvOption.text = data?.get(position)
        optionHolder.optionBinding.root.tag = position
    }

    inner class OptionHolder(var optionBinding : ItemOptionBinding) : VBViewHolder(optionBinding){
        init {
            optionBinding.root.setOnClickListener(this@OptionItemAdapter)
        }
    }
}