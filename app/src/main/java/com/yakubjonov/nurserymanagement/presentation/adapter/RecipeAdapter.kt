package com.yakubjonov.nurserymanagement.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.yakubjonov.domain.model.Food
import com.yakubjonov.domain.model.Recipe
import com.yakubjonov.nurserymanagement.databinding.ItemRecipeBinding

class RecipeAdapter(private var count:Int) : RecyclerView.Adapter<RecipeAdapter.RVH>() {

    inner class RVH(private val itemBinding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun onBind(position: Int) {
            itemBinding.apply {
                val recipe = getList(position)
                val adapter = FoodAdapter(recipe.list, count)
                textTv.text = recipe.name
                rv.adapter = adapter
                if (rv.itemDecorationCount == 0) {
                    rv.addItemDecoration(DividerItemDecoration(itemBinding.root.context, DividerItemDecoration.VERTICAL))
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVH {
        return RVH(ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RVH, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = if (count > 0) 3 else 0

    private fun getList(position: Int): Recipe {
        return when (position) {
            0 -> Recipe(
                "Manniy Bo'tqasi", listOf(
                    Food(
                        "Manniy yormasi",
                        "15",
                        "15",
                        "1.54",
                        "0.15",
                        "10.18",
                        "49.20"
                    ),
                    Food("Sut", "150", "150", "4.2", "4.8", "7.05", "87"),
                    Food(
                        "Sariyog'",
                        "4.7",
                        "4.7",
                        "0.02",
                        "3.85",
                        "0.04",
                        "34.91"
                    ),
                    Food("Shakar", "4.7", "4.7", "0", "0", "4.66", "17.69"),
                    Food("Tuz", "0.8", "0.8", "0", "0", "0", "0")
                )
            )
            1 -> Recipe(
                "Sutli kakao",
                listOf(
                    Food(
                        "Kakao-kukuni",
                        "2",
                        "2",
                        "0.48",
                        "0.35",
                        "0.6",
                        "7.6"
                    ),
                    Food("Sut", "84", "84", "2.35", "2.69", "3.9", "48.76"),
                    Food("Shakar", "7", "7", "0", "0", "7", "26.53"),
                )
            )
            2 -> Recipe(
                "Saryog'li buterbrod",
                listOf(
                    Food("Saryog'", "5", "5", "0.02", "4.12", "0", "37.4"),
                    Food(
                        "Bug'doy noni",
                        "40",
                        "40",
                        "3.08",
                        "1.2",
                        "19.9",
                        "105"
                    ),
                )
            )

            else ->
                Recipe("", listOf())
        }
    }
}