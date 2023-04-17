package com.example.navigationcomponentlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigationcomponentlab.databinding.FragmentGroceryListBinding
import com.example.navigationcomponentlab.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val rootView = binding.root
        binding.startButton.setOnClickListener {
            val name = binding.nameField.getText().toString()
            val action = HomeFragmentDirections.actionHomeFragmentToGroceryListFragment(name)
            rootView.findNavController().navigate(action)

        }


        // Inflate the layout for this fragment


        return rootView
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}