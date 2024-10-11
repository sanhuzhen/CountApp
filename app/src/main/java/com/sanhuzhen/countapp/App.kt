package com.sanhuzhen.countapp

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/11 19:42
 */
class App: Application() {

    private val isDug = true
    override fun onCreate() {
        super.onCreate()
        if (isDug) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}