package com.sanhuzhen.module.practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.practice.databinding.ActivityPracticeBinding

@Route(path = "/practice/practiceActivity")
class PracticeActivity : BaseActivity<ActivityPracticeBinding>() {
    override fun getViewBinding(): ActivityPracticeBinding {
        return ActivityPracticeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}