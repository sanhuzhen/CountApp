package com.sanhuzhen.module.mine.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.mine.R
import com.sanhuzhen.module.mine.adapter.StoreAdapter
import com.sanhuzhen.module.mine.bean.Award
import com.sanhuzhen.module.mine.databinding.ActivityStoreBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/15 0:10
 */
class StoreActivity: BaseActivity<ActivityStoreBinding>() {
    private val awardList = ArrayList<Award>()
    override fun getViewBinding(): ActivityStoreBinding {
        return ActivityStoreBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initEvent()
        addAware()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvAware.layoutManager = layoutManager
        val adapter = StoreAdapter(awardList)
        binding.rvAware.adapter = adapter
    }
    private fun initEvent() {
        val sanSharedPreferences: SharedPreferences = getSharedPreferences("point", Context.MODE_PRIVATE)
        val point: Int = sanSharedPreferences.getInt("point", 0)
        binding.tvPoint.text = point.toString()
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
    private fun addAware() {
        awardList.apply{
            add(Award(R.drawable.img_12,"橡皮擦","10"))
            add(Award(R.drawable.img_6,"圆珠笔","100"))
            add(Award(R.drawable.img_7,"笔记本","200"))
            add(Award(R.drawable.img_8,"卷笔刀","50"))
            add(Award(R.drawable.img_9,"笔盒","200"))
            add(Award(R.drawable.img_10,"笔筒","100"))
            add(Award(R.drawable.img_11,"蜡笔","500"))
        }
    }
}