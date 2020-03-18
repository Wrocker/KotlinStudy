package com.rocker.kotlinstudy.base

import android.view.View
import androidx.viewbinding.ViewBinding
import com.rocker.kotlinstudy.databinding.LayoutBaseloadBinding

/**
 * viewstub
 */
abstract class BaseLoadActivity<L : ViewBinding> : BaseActivity<LayoutBaseloadBinding>() {

    lateinit var loadBinding : L

    override fun initLayout(): LayoutBaseloadBinding {
        return LayoutBaseloadBinding.inflate(layoutInflater)
    }

    override fun initView() {
        rootBinding.tvTitle.text = "标题"
        Thread(
            Runnable {
                for ( i in 1..4 step 1){
                    Thread.sleep(1000)
                    runOnUiThread {
                        rootBinding.tvSub.text = i.toString()
                        if(i == 4){
                            rootBinding.vsContent.layoutResource = initLoadLayout()
                            loadBinding = initLoadBinding(rootBinding.vsContent.inflate())
                            initLoad()
                        }
                    }
                }
            }
        )
            .start()
    }

    abstract fun initLoadLayout() : Int

    abstract fun initLoadBinding(inflate: View): L

    abstract fun initLoad()
}