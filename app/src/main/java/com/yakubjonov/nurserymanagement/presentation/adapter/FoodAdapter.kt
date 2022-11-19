package com.yakubjonov.nurserymanagement.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yakubjonov.domain.model.Food
import com.yakubjonov.nurserymanagement.databinding.ItemProductBinding

class FoodAdapter(private val list: List<Food>, private val countChildren:Int) : RecyclerView.Adapter<FoodAdapter.FVH>() {

    inner class FVH(private val itemBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun onBind(food: Food, position: Int) {
            itemBinding.apply {
                if (position==0) {
                    root.setBackgroundColor(Color.BLACK)
                    nameTv.text = food.name
                    withChiqitTv.text = food.withChikiq
                    withoutChiqitTv.text = food.withoutChikiq
                         proteinTv.text = food.protein
                         oilTv.text = food.oil
                         carbohydrateTv.text = food.carbohydrate
                         ccalTv.text = food.ccal
                } else {
                    nameTv.text = food.name
                    val chikitli = (food.withChikiq.toFloat() * countChildren).toString()
                    val chikitsiz = (food.withoutChikiq.toFloat() * countChildren).toString()
                    withChiqitTv.text =
                        chikitli.substringBefore(".")
                    withoutChiqitTv.text =
                        chikitsiz.substringBefore(".")
                     proteinTv.text = (food.protein.toFloat()*countChildren).toString()
                     oilTv.text = (food.oil.toFloat()*countChildren).toString()
                     carbohydrateTv.text = (food.carbohydrate.toFloat()*countChildren).toString()
                     ccalTv.text = (food.ccal.toFloat()*countChildren).toString()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FVH {
        return FVH(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FVH, position: Int) {
        if (position == 0) {
            holder.onBind(getStarted(), position)
        } else {
            holder.onBind(list[position - 1], position)
        }
    }

    override fun getItemCount(): Int = if (list.isEmpty()) 0 else list.size + 1

    private fun getStarted() = Food(
        name = "Maxsulot nomi",
        withChikiq = "Chiqitli (gr)",
        withoutChikiq = "Chiqitsiz (gr)",
        protein = "Oqsil",
        oil = "Yog'",
        carbohydrate = "Uglevod",
        ccal = "Kkal"
    )

 /*   private fun getValue(position: Int): Food {
        val s = listOf(
            Food("Manniy yormasi", "15", "15", "1.54", "0.15", "10.18", "49.20"),
            Food("Sut", "150", "150", "4.2", "4.8", "7.05", "87"),
            Food("Sariyog'", "4.7", "4.7", "0.02", "3.85", "0.04", "34.91"),
            Food("Shakar", "4.7", "4.7", "0", "0", "4.66", "17.69"),
            Food("Tuz", "0.8", "0.8", "0", "0", "0", "0")
        )
        return when (position) {
            else -> Food("Manniy yormasi", "15", "15", "1.54", "0.15", "10.18", "49.20")
        }
    }*/
}