package com.yakubjonov.nurserymanagement.presentation.home

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yakubjonov.nurserymanagement.R
import com.yakubjonov.nurserymanagement.core.Constants
import com.yakubjonov.nurserymanagement.databinding.FragmentHomeBinding
import com.yakubjonov.nurserymanagement.databinding.ItemDialogChildCountBinding
import com.yakubjonov.nurserymanagement.presentation.adapter.MealTimeAdapter

class HomeFragment : Fragment(), MealTimeAdapter.OnMealTimeClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = MealTimeAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    override fun onMealTimeClicked(mealTime: String) {
        val dialog = AlertDialog.Builder(binding.root.context).create()
        val itemDialog = ItemDialogChildCountBinding.inflate(layoutInflater)
        dialog.setView(itemDialog.root)

        itemDialog.apply {
            upBtn.setOnClickListener {
                if (childCountTv.text.toString().toInt()<100) {
                    childCountTv.text = (childCountTv.text.toString().toInt()+1).toString()
                }
            }
            downBtn.setOnClickListener {
                if (childCountTv.text.toString().toInt()>0) {
                    childCountTv.text = "${childCountTv.text.toString().toInt() - 1}"
                }
            }
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tasdiqlash"){ a, b->
                findNavController().navigate(
                    R.id.action_nav_home_to_detailFragment,
                    bundleOf(Pair(Constants.CHILD_COUNT_KEY, childCountTv.text.toString().toInt()))
                )
            }
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Ortga"){ a, b->
                dialog.dismiss()
            }
        }

        dialog.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}