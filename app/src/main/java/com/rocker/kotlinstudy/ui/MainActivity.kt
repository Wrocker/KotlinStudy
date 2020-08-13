package com.rocker.kotlinstudy.ui

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rocker.kotlinstudy.R
import com.rocker.kotlinstudy.base.adapter.BaseRecAdapter
import com.rocker.kotlinstudy.base.ui.BaseActivity
import com.rocker.kotlinstudy.databinding.ActivityMainBinding
import com.rocker.kotlinstudy.ui.activity.basic.BasicTypesActivity
import com.rocker.kotlinstudy.ui.activity.basic.ControlFlowActivity
import com.rocker.kotlinstudy.ui.activity.basic.PackageImportActivity
import com.rocker.kotlinstudy.ui.activity.basic.ReturnAndJumpActivity
import com.rocker.kotlinstudy.ui.activity.collections.*
import com.rocker.kotlinstudy.ui.activity.function.FunctionsActivity
import com.rocker.kotlinstudy.ui.activity.function.InlineFunctionsActivity
import com.rocker.kotlinstudy.ui.activity.function.LambdasActivity
import com.rocker.kotlinstudy.ui.activity.objects.*
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

        data.add(getString(R.string.basicTypes))
        data.add(getString(R.string.packageImport))
        data.add(getString(R.string.controlFlow))
        data.add(getString(R.string.returnAndJump))

        data.add(getString(R.string.classesAndInheritance))
        data.add(getString(R.string.propertiesAndFields))
        data.add(getString(R.string.interfaces))
        data.add(getString(R.string.visibilityModifiers))
        data.add(getString(R.string.extensions))
        data.add(getString(R.string.dataClasses))
        data.add(getString(R.string.sealedClasses))
        data.add(getString(R.string.generics))
        data.add(getString(R.string.nestedAndInnerClasses))
        data.add(getString(R.string.enumClasses))
        data.add(getString(R.string.objects))
        data.add(getString(R.string.typeAliases))
        data.add(getString(R.string.inlineClasses))
        data.add(getString(R.string.delegation))
        data.add(getString(R.string.delegatedProperties))

        data.add(getString(R.string.functions))
        data.add(getString(R.string.lambdas))
        data.add(getString(R.string.inlineFunctions))

        data.add(getString(R.string.collectionsOverview))
        data.add(getString(R.string.constructingCollections))
        data.add(getString(R.string.iterators))
        data.add(getString(R.string.rangesAndProgressions))
        data.add(getString(R.string.sequences))
        data.add(getString(R.string.operationsOverview))
        data.add(getString(R.string.transformations))
        data.add(getString(R.string.filtering))
        data.add(getString(R.string.plusAndMinusOperators))
        data.add(getString(R.string.grouping))
        data.add(getString(R.string.retrievingCollectionParts))
        data.add(getString(R.string.retrievingSingleElements))
        data.add(getString(R.string.ordering))
        data.add(getString(R.string.aggregateOperations))
        data.add(getString(R.string.writeOperations))
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
                    3 -> {
                        startActivity(Intent(this@MainActivity, PackageImportActivity::class.java))
                    }
                    4 -> {
                        startActivity(Intent(this@MainActivity, ControlFlowActivity::class.java))
                    }
                    5 -> {
                        startActivity(Intent(this@MainActivity, ReturnAndJumpActivity::class.java))
                    }
                    6 -> {
                        startActivity(Intent(this@MainActivity, ClassesAndInheritanceActivity::class.java))
                    }
                    7 -> {
                        startActivity(Intent(this@MainActivity, PropertiesAndFieldsActivity::class.java))
                    }
                    8 -> {
                        startActivity(Intent(this@MainActivity, InterfacesActivity::class.java))
                    }
                    9 -> {
                        startActivity(Intent(this@MainActivity, VisibilityModifiersActivity::class.java))
                    }
                    10 -> {
                        startActivity(Intent(this@MainActivity, ExtensionsActivity::class.java))
                    }
                    11 -> {
                        startActivity(Intent(this@MainActivity, DataClassesActivity::class.java))
                    }
                    12 -> {
                        startActivity(Intent(this@MainActivity, SealedClassesActivity::class.java))
                    }
                    13 -> {
                        startActivity(Intent(this@MainActivity, GenericsActivity::class.java))
                    }
                    14 -> {
                        startActivity(Intent(this@MainActivity, NestedAndInnerClassesActivity::class.java))
                    }
                    15 -> {
                        startActivity(Intent(this@MainActivity, EnumClassesActivity::class.java))
                    }
                    16 -> {
                        startActivity(Intent(this@MainActivity, ObjectsActivity::class.java))
                    }
                    17 -> {
                        startActivity(Intent(this@MainActivity, TypeAliasesActivity::class.java))
                    }
                    18 -> {
                        startActivity(Intent(this@MainActivity, InlineClassesActivity::class.java))
                    }
                    19 -> {
                        startActivity(Intent(this@MainActivity, DelegationActivity::class.java))
                    }
                    20 -> {
                        startActivity(Intent(this@MainActivity, DelegatedPropertiesActivity::class.java))
                    }
                    21 -> {
                        startActivity(Intent(this@MainActivity, FunctionsActivity::class.java))
                    }
                    22 -> {
                        startActivity(Intent(this@MainActivity, LambdasActivity::class.java))
                    }
                    23 -> {
                        startActivity(Intent(this@MainActivity, InlineFunctionsActivity::class.java))
                    }
                    24 -> {
                        startActivity(Intent(this@MainActivity, CollectionsOverviewActivity::class.java))
                    }
                    25 -> {
                        startActivity(Intent(this@MainActivity, ConstructingCollectionsActivity::class.java))
                    }
                    26 -> {
                        startActivity(Intent(this@MainActivity, IteratorsActivity::class.java))
                    }
                    27 -> {
                        startActivity(Intent(this@MainActivity, RangesAndProgressionsActivity::class.java))
                    }
                    28 -> {
                        startActivity(Intent(this@MainActivity, SequencesActivity::class.java))
                    }
                    29 -> {
                        startActivity(Intent(this@MainActivity, OperationsOverviewActivity::class.java))
                    }
                    30 -> {
                        startActivity(Intent(this@MainActivity, TransformationsActivity::class.java))
                    }
                    31 -> {
                        startActivity(Intent(this@MainActivity, FilteringActivity::class.java))
                    }
                    32 -> {
                        startActivity(Intent(this@MainActivity, PlusAndMinusOperatorsActivity::class.java))
                    }
                    33 -> {
                        startActivity(Intent(this@MainActivity, GroupingActivity::class.java))
                    }
                    34 -> {
                        startActivity(Intent(this@MainActivity, RetrievingCollectionPartsActivity::class.java))
                    }
                    35 -> {
                        startActivity(Intent(this@MainActivity, RetrievingSingleElementsActivity::class.java))
                    }
                    36 -> {
                        startActivity(Intent(this@MainActivity, OrderingActivity::class.java))
                    }
                    37 -> {
                        startActivity(Intent(this@MainActivity, AggregateOperationsActivity::class.java))
                    }
                    38 -> {
                        startActivity(Intent(this@MainActivity, WriteOperationsActivity::class.java))
                    }
                }
            }
        }
        rootBinding.rvList.adapter = adapter
    }

}
