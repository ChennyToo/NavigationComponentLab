package com.example.navigationcomponentlab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.example.navigationcomponentlab.databinding.FragmentChooseItemBinding
import com.example.navigationcomponentlab.databinding.FragmentHomeBinding


class ChooseItemFragment : Fragment() {

    private var _binding : FragmentChooseItemBinding? = null
    private val binding get() = _binding!!
    lateinit var rootView : ConstraintLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseItemBinding.inflate(inflater,container,false)
        rootView = binding.root

        val groceryClickListener: View.OnClickListener =
            View.OnClickListener { view ->
                when (view.id) {
                    R.id.itemButton1 -> logItem(1)
                    R.id.itemButton2 -> logItem(2)
                    R.id.itemButton3 -> logItem(3)
                    R.id.itemButton4 -> logItem(4)
                    R.id.itemButton5 -> logItem(5)
                    R.id.itemButton6 -> logItem(6)
                    R.id.itemButton7 -> logItem(7)
                    R.id.itemButton8 -> logItem(8)


                }
            }

        binding.itemButton1.setOnClickListener(groceryClickListener)
        binding.itemButton2.setOnClickListener(groceryClickListener)
        binding.itemButton3.setOnClickListener(groceryClickListener)
        binding.itemButton4.setOnClickListener(groceryClickListener)
        binding.itemButton5.setOnClickListener(groceryClickListener)
        binding.itemButton6.setOnClickListener(groceryClickListener)
        binding.itemButton7.setOnClickListener(groceryClickListener)
        binding.itemButton8.setOnClickListener(groceryClickListener)

        // Inflate the layout for this fragment
        return rootView
    }

    fun logItem(buttonInt : Int){
        val itemList: Array<String> = resources.getStringArray(R.array.item_array)
        val item = itemList.get(buttonInt - 1)
        setFragmentResult("requestKey", bundleOf("bundleKey" to item))
        rootView.findNavController().navigateUp()
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}