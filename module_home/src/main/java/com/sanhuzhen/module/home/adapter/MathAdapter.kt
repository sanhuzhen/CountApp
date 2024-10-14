package com.sanhuzhen.module.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sanhuzhen.module.home.R
import com.sanhuzhen.module.home.bean.Numbers

/**
 * author : QTwawa
 * date : 2024/10/13 16:24
 */
class MathAdapter(list: List<String>): RecyclerView.Adapter<MathAdapter.MathViewHolder>()
{
    private val numbersData=list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MathAdapter.MathViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_math,parent,false)
        return MathViewHolder(view)
    }

    override fun getItemCount(): Int {
        return numbersData.size
    }
    fun interface OnClickedListener {
        fun onClicked(view: View)
    }

    private var listener: OnClickedListener? = null
    fun setOnClickedListener(listener: OnClickedListener) {
        this.listener = listener
    }


    override fun onBindViewHolder(holder: MathAdapter.MathViewHolder, position: Int) {
        val data=numbersData[position]
        holder.bind(data)
    }
    inner class MathViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val numbers:TextView =itemView.findViewById(R.id.item_tv_number)
        fun bind(data: String){
            numbers.text=data
            itemView.setOnClickListener {
                listener?.onClicked(itemView)
            }
        }
    }
}