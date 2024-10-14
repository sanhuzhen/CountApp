package com.sanhuzhen.lib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/11 19:38
 */
abstract class BaseFragment<VB: ViewBinding> : Fragment() {

    abstract fun getViewBinding(): VB

    private var _binding: VB? = null
    protected val mBinding: VB
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}