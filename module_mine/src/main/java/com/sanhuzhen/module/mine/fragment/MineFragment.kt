package com.sanhuzhen.module.mine.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.sanhuzhen.lib.base.BaseApp.Companion.appContext
import com.sanhuzhen.lib.base.BaseFragment
import com.sanhuzhen.module.mine.activity.EvaluateActivity
import com.sanhuzhen.module.mine.databinding.FragmentMineBinding

class MineFragment : BaseFragment<FragmentMineBinding>() {

    private val sp by lazy { appContext.getSharedPreferences("user", Context.MODE_PRIVATE) }

    //持久化图片
    private val requestDataLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            result?.data?.data?.let { uri ->
                sp.saveString("img", uri.toString())
                loadImage(uri)
            }
        }

    override fun getViewBinding(): FragmentMineBinding {
        return FragmentMineBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserInfo()
    }

    private fun initUserInfo() {
        with(mBinding) {
            userImg.apply {
                setOnClickListener { openImagePicker() }
                sp.getString("img")?.let { loadImage(Uri.parse(it)) }
            }
            userName.apply {
                setEditableField("username", "请输入昵称", "昵称")
            }
            userDes.apply {
                setEditableField("userdes", "请输入签名", "个人签名")
            }
            llWeek.apply {

            }
            llStore.apply {}
            llError.apply {}
            llXunzhang.apply {  }
            rlWe.apply {
                setOnClickListener { Toast.makeText(requireContext(), "功能暂未开放", Toast.LENGTH_SHORT).show() }

            }
            rlShare.apply {
                setOnClickListener { share() }
            }
            rlPingjia.apply {
                setOnClickListener {
                    startActivity(Intent(requireContext(), EvaluateActivity::class.java))
                }
            }
        }
    }

    private fun share() {
        val title = "分享\n 一款算数App"
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, title)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, title)
        startActivity(shareIntent)
    }

    private fun View.setEditableField(spKey: String, hint: String, title: String) {
        setOnClickListener { showEditTextDialog(hint, title) }
        sp.getString(spKey)?.let { (this as? TextView)?.text = it }
    }

    private fun showEditTextDialog(hint: String, title: String) {
        val editText = EditText(requireContext()).apply { this.hint = hint }
        AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setView(editText)
            .setPositiveButton("确定") { dialog, _ ->
                val inputText = editText.text.toString()
                when (title) {
                    "昵称" -> updateField("username", inputText, mBinding.userName)
                    "个人签名" -> updateField("userdes", inputText, mBinding.userDes)
                }
                dialog.dismiss()
            }
            .setNegativeButton("取消") { dialog, _ -> dialog.dismiss() }
            .create().apply { showCentered() }
    }

    private fun updateField(key: String, value: String, textView: TextView) {
        sp.saveString(key, value)
        textView.text = value
    }

    private fun loadImage(uri: Uri) {
        Glide.with(this).load(uri).into(mBinding.userImg)
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
        }
        requestDataLauncher.launch(intent)
    }

    private fun AlertDialog.showCentered() {
        show()
        window?.let { window ->
            window.attributes = window.attributes.apply { gravity = Gravity.CENTER }
        }
    }

    // SharedPreferences 扩展函数
    private fun SharedPreferences.saveString(key: String, value: String) {
        edit().putString(key, value).apply()
    }

    private fun SharedPreferences.getString(key: String): String? {
        return getString(key, null)
    }
}