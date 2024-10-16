package com.sanhuzhen.module.mine.activity

import android.os.Bundle
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.mine.databinding.ActivityStoreBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/15 0:10
 */
class StoreActivity: BaseActivity<ActivityStoreBinding>() {
    override fun getViewBinding(): ActivityStoreBinding {
        return ActivityStoreBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}