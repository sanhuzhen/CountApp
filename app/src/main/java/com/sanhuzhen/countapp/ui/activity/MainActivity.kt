package com.sanhuzhen.countapp.ui.activity

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.sanhuzhen.countapp.R
import com.sanhuzhen.countapp.adapter.ViewPagerAdapter
import com.sanhuzhen.countapp.databinding.ActivityMainBinding
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.home.fragment.HomeFragment
import com.sanhuzhen.module.mine.fragment.MineFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewPagerAdapter by lazy { ViewPagerAdapter(this) }
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        // 添加fragment
        viewPagerAdapter.apply {
            add { HomeFragment() }
            add { MineFragment() }
        }

        //BottomNav
        binding.bottomNavigationView.apply {
            setOnItemSelectedListener { item ->
                if (binding.mainViewpager2.scrollState != ViewPager2.SCROLL_STATE_IDLE) return@setOnItemSelectedListener false
                when (item.itemId) {
                    R.id.action_home -> binding.mainViewpager2.currentItem = 0
                    R.id.action_mine -> binding.mainViewpager2.currentItem = 1
                }
                return@setOnItemSelectedListener true
            }
        }

        //viewPager
        binding.mainViewpager2.apply {
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationView.menu.getItem(position).isChecked = true
                }
            })
            isUserInputEnabled = false
        }
    }
}