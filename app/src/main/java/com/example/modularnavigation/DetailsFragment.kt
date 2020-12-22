package com.example.modularnavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.counter.observe(
            viewLifecycleOwner,
            Observer<Int> { value: Int -> counter.text = value.toString() })

        details_inc_btn.setOnClickListener {
            viewModel.increment()
        }

        details_dec_btn.setOnClickListener {
            viewModel.decrement()
        }

        navigate_to_details_btn.setOnClickListener {
            findNavController(view).navigate(R.id.increnentDatailsFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}