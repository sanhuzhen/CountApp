package com.sanhuzhen.countapp

import com.sanhuzhen.lib.base.BaseApp

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/11 19:42
 */
class App: BaseApp() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}