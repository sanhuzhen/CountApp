package com.sanhuzhen.module.practice

import android.annotation.SuppressLint
import android.gesture.Gesture
import android.gesture.GestureLibraries
import android.gesture.GestureLibrary
import android.gesture.GestureOverlayView
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.sanhuzhen.lib.base.BaseActivity
import com.sanhuzhen.module.practice.databinding.ActivityPracticeBinding

@Route(path = "/practice/practiceActivity")
class PracticeActivity : BaseActivity<ActivityPracticeBinding>(), GestureOverlayView.OnGesturePerformedListener,
    GestureOverlayView.OnGesturingListener {

    private lateinit var gestureLibrary: GestureLibrary
    private var target = 0
    private val type by lazy { intent.getStringExtra("type").toString() }
    private val numbers by lazy { intent.getIntExtra("numbers", 0) }

    override fun getViewBinding(): ActivityPracticeBinding {
        return ActivityPracticeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        initGesture()
        binding.back.setOnClickListener { finish() }
        binding.skip.setOnClickListener {
            if (target >= 10) showAlertDialog()
            setTextNumber()
        }
    }

    private fun initGesture() {
        val fadeOffset = if (type == "比") 100L else 300L
        gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures)
        if (gestureLibrary.load()) {
            binding.gesture.addOnGesturePerformedListener(this)
        }
        binding.gesture.apply {
            gestureStrokeType = GestureOverlayView.GESTURE_STROKE_TYPE_MULTIPLE
            gestureColor = ContextCompat.getColor(this@PracticeActivity, R.color.black)
            uncertainGestureColor = ContextCompat.getColor(this@PracticeActivity, R.color.black)
            gestureStrokeWidth = 10f
            this.fadeOffset = fadeOffset
            addOnGesturingListener(this@PracticeActivity)
        }
        setTextNumber()
    }

    override fun onGesturePerformed(overlay: GestureOverlayView?, gesture: Gesture?) {
        gesture?.let {
            val result = gestureLibrary.recognize(gesture)
            if (result.isNotEmpty()) {
                val str = result[0].name
                if (type == "比") showCompare(str)
            }
        }
    }

    private fun showCompare(str: String) {
        val num1 = binding.num1.text.toString().toInt()
        val num2 = binding.num2.text.toString().toInt()
        val isCorrect = when {
            num1 < num2 && (str == "c" || str == "r") -> {
                binding.compare.text = "<"
                true
            }
            num1 > num2 && str != "c" && str != "r" -> {
                binding.compare.text = ">"
                true
            }
            else -> false
        }

        if (isCorrect) {
            Toast.makeText(this, "回答正确", Toast.LENGTH_SHORT).show()
            setTextNumber()
        } else {
            Toast.makeText(this, "回答错误", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onGesturingStarted(overlay: GestureOverlayView?) {}

    override fun onGesturingEnded(overlay: GestureOverlayView?) {
        if (target >= 10) showAlertDialog()
    }

    @SuppressLint("SetTextI18n")
    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("恭喜你，答对了10道题")
            .setMessage("是否再来一局？")
            .setPositiveButton("再来一局") { _, _ ->
                target = 0
                setTextNumber()
            }
            .setNegativeButton("退出") { _, _ -> finish() }
            .show()
    }

    @SuppressLint("SetTextI18n")
    private fun setTextNumber() {
        binding.num1.text = getRandomNumber().toString()
        binding.num2.text = getRandomNumber().toString()
        while (binding.num2.text == binding.num1.text) {
            binding.num2.text = getRandomNumber().toString()
        }
        binding.compare.text = ""
        target++
        binding.page.text = "$target/10"
    }

    private fun getRandomNumber(): Int = (0..numbers).random()
}