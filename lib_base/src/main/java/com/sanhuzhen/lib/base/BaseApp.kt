package com.sanhuzhen.lib.base

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/14 10:41
 */
open class BaseApp: Application() {
    private val isDug = true

    companion object {
        lateinit var appContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        if (isDug) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        appContext = this
    }
}