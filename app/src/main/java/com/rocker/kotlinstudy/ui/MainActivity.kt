package com.rocker.kotlinstudy.ui

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.base.BaseActivity
import com.rocker.kotlinstudy.databinding.ActivityMainBinding
import com.rocker.kotlinstudy.ui.adapter.OptionItemAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var adapter: OptionItemAdapter

    override fun initLayout(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        rootBinding.rvList.layoutManager = LinearLayoutManager(this)
        adapter = OptionItemAdapter(this)
        val data = ArrayList<String>(3)
        data.add("first")
        adapter.data = data
        rootBinding.rvList.adapter = adapter
        Log.e("____", "adapter : ${adapter.itemCount}")
    }

}
