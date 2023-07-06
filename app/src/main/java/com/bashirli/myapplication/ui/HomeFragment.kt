package com.bashirli.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.bashirli.myapplication.R
import com.bashirli.myapplication.base.BaseFragment
import com.bashirli.myapplication.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    //private lateinit var viewModel :HomeMVVM

    //private val viewModel:HomeMVVM by viewModels()

     private val viewModel by viewModels<HomeMVVM>()

        private var number=0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // viewModel=ViewModelProvider(requireActivity())[HomeMVVM::class.java]
        setup()
        observeData()
    }

    private fun setup(){
        binding.apply {
            buttonIncrease.setOnClickListener {
                viewModel.increaseNumber(number)
            }
            buttonDecrease.setOnClickListener {
                viewModel.decreaseNumber(number)
            }
        }
    }

    private fun observeData(){

        viewModel.counter.observe(viewLifecycleOwner){
                counterNumber->
            number=counterNumber
            binding.textView.text=counterNumber.toString()
        }
    }

  
}