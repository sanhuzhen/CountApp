package com.sanhuzhen.module.mine.activity

import android.os.Bundle
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.mine.databinding.ActivityHonorBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/15 0:12
 */
class HonorActivity: BaseActivity<ActivityHonorBinding>() {
    override fun getViewBinding(): ActivityHonorBinding {
        return ActivityHonorBinding.inflate(layoutInflater)
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