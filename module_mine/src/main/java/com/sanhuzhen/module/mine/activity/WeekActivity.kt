package com.sanhuzhen.module.mine.activity

import android.os.Bundle
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.mine.databinding.ActivityWeekBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/15 0:08
 */
class WeekActivity: BaseActivity<ActivityWeekBinding>() {
    override fun getViewBinding(): ActivityWeekBinding {
        return ActivityWeekBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }
    private fun initView() {
        binding.apply {
            toolbarBack.setOnClickListener {
                finish()
            }
        }
    }
}