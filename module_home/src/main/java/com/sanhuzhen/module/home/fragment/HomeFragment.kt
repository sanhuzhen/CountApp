package com.sanhuzhen.module.home.fragment

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.sanhuzhen.lib.base.BaseFragment
import com.sanhuzhen.module.home.R
import com.sanhuzhen.module.home.adapter.HomeAdapter
import com.sanhuzhen.module.home.bean.Numbers
import com.sanhuzhen.module.home.databinding.FragmentHomeBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/11 19:49
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mBinding.vp2HomeContent.isSaveEnabled = false
        val fragments = ArrayList<Fragment>()
        fragments.add(MathFragment("比"))
        fragments.add(MathFragment("加"))
        fragments.add(MathFragment("减"))
        fragments.add(MathFragment("乘"))
        fragments.add(MathFragment("除"))
        mBinding.vp2HomeContent.adapter = HomeAdapter(fragments, childFragmentManager, lifecycle)
        TabLayoutMediator(mBinding.tabHome, mBinding.vp2HomeContent) { tab, position ->
            tab.text = when (position) {
                0 -> "比大小练习"
                1 -> "加法练习"
                2 -> "减法练习"
                3 -> "乘法练习"
                4 -> "除法练习"
                else -> error("迷路了QAQ")
            }
        }.attach()
    }
}