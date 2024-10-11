package com.sanhuzhen.module.home.fragment

import android.os.Bundle
import android.view.View
import com.sanhuzhen.lib.base.BaseFragment
import com.sanhuzhen.module.home.databinding.FragmentHomeBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/11 19:49
 */
class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}