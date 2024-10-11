package com.sanhuzhen.countapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * description: viewPager2 适配器
 * author: sanhuzhen
 * date: 2024/10/11 19:30
 */
class ViewPagerAdapter private constructor(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    constructor(activity: FragmentActivity) : this(activity.supportFragmentManager, activity.lifecycle)

    private val mFragments = arrayListOf<() -> Fragment>()

    fun add(fragment: () -> Fragment): ViewPagerAdapter {
        mFragments.add(fragment)
        return this
    }

    override fun getItemCount(): Int = mFragments.size

    override fun createFragment(position: Int): Fragment = mFragments[position].invoke()
}