package com.example.modularnavigation.features.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.modularnavigation.R
import kotlinx.android.synthetic.main.fragment_auth_start.*

class StartAuthFragment : Fragment(R.layout.fragment_auth_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth_start_button.setOnClickListener {
            findNavController().navigate(R.id.action_startAuthFragment_to_finishAuthFragment)
        }
    }

}