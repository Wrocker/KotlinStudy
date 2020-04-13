package com.rocker.kotlinstudy.ui.adapter

import android.content.Context
import android.view.ViewGroup
import com.rocker.kotlinstudy.base.adapter.BaseRecAdapter
import com.rocker.kotlinstudy.databinding.ItemImgBinding
import com.rocker.kotlinstudy.databinding.ItemTextBinding

/**
 * 文本编辑界面
 */
class ContentLayoutAdapter(context: Context) : BaseRecAdapter<ContentLayoutAdapter.LayType>(context){

    companion object {
        private const val TYPE_IMG = 0x111
        private const val TYPE_TEXT = 0x222
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VBViewHolder {
        return when(viewType){
            TYPE_IMG -> ImgHolder(ItemImgBinding.inflate(inflater))
            else -> TextHolder(ItemTextBinding.inflate(inflater))
        }
    }

    override fun onBindViewHolder(holder: VBViewHolder, position: Int) {
        val temp = data?.get(position)
        when(getItemViewType(position)){
            TYPE_IMG -> {
                val imgHolder = holder as ImgHolder
                temp?.url?.let { imgHolder.imgBinding.imgShow.setImageResource(it) }
            }
            else -> {
                val textHolder = holder as TextHolder
                textHolder.textBinding.tvText.text = temp?.content
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data?.get(position)?.type?:0
    }

    inner class ImgHolder(val imgBinding: ItemImgBinding) : VBViewHolder(imgBinding)

    inner class TextHolder(val textBinding: ItemTextBinding) : VBViewHolder(textBinding)

    class LayType(val type: Int,val url: Int,val content: String?){
        constructor(url: Int): this(TYPE_IMG, url, null)
        constructor(content: String): this(TYPE_TEXT, 0, content)
    }
}