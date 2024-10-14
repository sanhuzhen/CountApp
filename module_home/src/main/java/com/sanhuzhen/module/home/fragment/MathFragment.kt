package com.sanhuzhen.module.home.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sanhuzhen.lib.base.BaseFragment
import com.sanhuzhen.module.home.databinding.FragmentMathBinding
import com.sanhuzhen.module.practice.PracticeActivity

/**
 * author : QTwawa
 * date : 2024/10/12 09:05
 */
class MathFragment(type:String) : BaseFragment<FragmentMathBinding>() {
    constructor(): this("")
    private val type=type
    override fun getViewBinding(): FragmentMathBinding {
        return FragmentMathBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {
        mBinding.tvHomeTen.setOnClickListener {
           val intent= Intent(context, PracticeActivity::class.java)
           intent.putExtra("type",type)
           intent.putExtra("numbers", 10)
           startActivity(intent)
        }
        mBinding.tvHomeHundred.setOnClickListener {
            val intent= Intent(context, PracticeActivity::class.java)
            intent.putExtra("type",type)
            intent.putExtra("numbers", 100)
            startActivity(intent)
        }
        mBinding.tvHomeThousand.setOnClickListener {
            val intent= Intent(context, PracticeActivity::class.java)
            intent.putExtra("type",type)
            intent.putExtra("numbers", 1000)
            startActivity(intent)
        }
    }
}