package com.sanhuzhen.module.mine.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sanhuzhen.module.mine.R
import com.sanhuzhen.module.mine.bean.Award

/**
 * description:
 * author: sanhuzhen
 * date: 2024/10/16 13:44
 */
class StoreAdapter(val awardList: List<Award>):
    RecyclerView.Adapter<StoreAdapter.TheViewHolder>() {
    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        val item = awardList[position]
        holder.image.setImageResource(item.imageView)
        holder.awardName.text = item.name
        holder.price.text = item.price
        holder.bt.setOnClickListener {
            val sanSharedPreferences: SharedPreferences = holder.itemView.context.getSharedPreferences("point", Context.MODE_PRIVATE)
            val editor = sanSharedPreferences.edit()
            if (sanSharedPreferences.getInt("point", 0) >= item.price.toInt()){
                editor.putInt("point", sanSharedPreferences.getInt("point", 0) - item.price.toInt())
                editor.apply()
            }else{
                Toast.makeText(holder.itemView.context, "积分不足", Toast.LENGTH_SHORT).show()
            }

        }
    }
    inner class TheViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv_point)
        val awardName: TextView = itemView.findViewById(R.id.tv_point_name)
        val price: TextView = itemView.findViewById(R.id.tv_point)
        val bt: Button = itemView.findViewById(R.id.bt_exchange)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.point,parent,false)
        return TheViewHolder(view)
    }
    override fun getItemCount(): Int {
        return awardList.size
    }

}