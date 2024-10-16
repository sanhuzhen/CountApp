package com.sanhuzhen.module.mine.activity

import android.os.Bundle
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.mine.databinding.ActivityErrorBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/15 0:11
 */
class ErrorActivity: BaseActivity<ActivityErrorBinding>() {
    override fun getViewBinding(): ActivityErrorBinding {
        return ActivityErrorBinding.inflate(layoutInflater)
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