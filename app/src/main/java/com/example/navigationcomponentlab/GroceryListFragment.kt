package com.example.navigationcomponentlab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.navigationcomponentlab.databinding.FragmentChooseItemBinding
import com.example.navigationcomponentlab.databinding.FragmentGroceryListBinding
import com.example.navigationcomponentlab.databinding.FragmentHomeBinding

class GroceryListFragment : Fragment() {
    private var _binding : FragmentGroceryListBinding? = null
    private val binding get() = _binding!!
    var index = 0
    var itemList = mutableListOf<String>()
    lateinit var textViewList: MutableList<TextView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGroceryListBinding.inflate(inflater,container,false)
        val rootView = binding.root
val args = GroceryListFragmentArgs.fromBundle(requireArguments())
        textViewList = mutableListOf<TextView>(binding.item1, binding.item2, binding.item3, binding.item4, binding.item5)
        binding.welcomeName.text = "Welcome ${args.nameArg}"
        setFragmentResultListener("requestKey"){
                requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            if (index < 5) {
                itemList.add(result!!)
                index++
            }
            updateItemViews()
        }


        binding.addButton.setOnClickListener {
            val action = GroceryListFragmentDirections.actionGroceryListFragmentToChooseItemFragment()
            rootView.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return rootView
    }

    fun updateItemViews(){
for ((i, item) in itemList.withIndex()){
    textViewList.get(i).text = item
}
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}