package com.example.marsrealestate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.marsrealestate.R
import com.example.marsrealestate.databinding.FragmentDetailBinding
import com.example.marsrealestate.network.MarsProperty

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var viewModelFactory: DetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        val application = requireNotNull(activity).application

        binding.lifecycleOwner = this

        val marsProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        viewModelFactory = DetailViewModelFactory(marsProperty, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        binding.detailViewModel = viewModel


        (activity as AppCompatActivity).supportActionBar?.title = "Detail"
        return binding.root
    }

}
