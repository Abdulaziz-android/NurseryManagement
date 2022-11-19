package com.yakubjonov.nurserymanagement.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yakubjonov.nurserymanagement.databinding.ItemMealTimeBinding

class MealTimeAdapter(private val listener: OnMealTimeClickListener) : RecyclerView.Adapter<MealTimeAdapter.MTVH>() {

    val list = arrayListOf(
        "Ertalabki Nonushta",
        "Ikkinchi Nonushta",
        "Tushlik",
        "Ikkinchi Tushlik"
    )

    inner class MTVH(private val itemBinding:ItemMealTimeBinding):RecyclerView.ViewHolder(itemBinding.root){

        fun onBind(mealTime: String){
            itemBinding.apply {
                nameTv.text = mealTime

                root.setOnClickListener {
                    listener.onMealTimeClicked(mealTime)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MTVH {
        return MTVH(ItemMealTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MTVH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    interface OnMealTimeClickListener{
        fun onMealTimeClicked(mealTime: String)
    }

}