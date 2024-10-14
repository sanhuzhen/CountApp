package com.sanhuzhen.module.mine.activity

import android.os.Bundle
import android.widget.Toast
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.mine.databinding.ActivityEvaluateBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/14 12:05
 */
class EvaluateActivity: BaseActivity<ActivityEvaluateBinding>() {
    override fun getViewBinding(): ActivityEvaluateBinding {
        return ActivityEvaluateBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        binding.apply {
            toolbarBack.setOnClickListener { finish() }
            btSubmit.setOnClickListener {
                Toast.makeText(this@EvaluateActivity, "提交成功", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

}