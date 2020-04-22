package com.rocker.kotlinstudy.ui

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.adapter.BaseRecAdapter
import com.rocker.kotlinstudy.base.ui.BaseActivity
import com.rocker.kotlinstudy.databinding.ActivityMainBinding
import com.rocker.kotlinstudy.ui.activity.basic.BasicTypesActivity
import com.rocker.kotlinstudy.ui.activity.start.BasicActivity
import com.rocker.kotlinstudy.ui.activity.start.IdiomsActivity
import com.rocker.kotlinstudy.ui.adapter.OptionItemAdapter

/**
 * 主界面
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var adapter: OptionItemAdapter

    override fun initLayout(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        rootBinding.rvList.layoutManager = LinearLayoutManager(this)
        adapter = OptionItemAdapter(this)
        val data = ArrayList<String>(3)
        data.add(getString(R.string.basicSyntax))
        data.add(getString(R.string.idioms))
        adapter.data = data
        adapter.onItemClickListener = object : BaseRecAdapter.OnItemClickListener{
            override fun onItemClick(view: View?) {
                when(view?.tag){
                    0 -> {
                        startActivity(Intent(this@MainActivity, BasicActivity::class.java))
                    }
                    1 -> {
                        startActivity(Intent(this@MainActivity, IdiomsActivity::class.java))
                    }
                    2 -> {
                        startActivity(Intent(this@MainActivity, BasicTypesActivity::class.java))
                    }
                }
            }
        }
        rootBinding.rvList.adapter = adapter
    }

}
