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

    private val args: StartAuthFragmentArgs by navArgs()

    private var callback: OnBackPressedCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth_start_button.setOnClickListener {
            findNavController().navigate(R.id.action_startAuthFragment_to_finishAuthFragment)
        }

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (args.isFromSplashScreen) {
                    // Hack for proper navigation from the first screen. Because we don't want to return to Splash screen.
                    requireActivity().finish()
                } else {
                    Navigation.findNavController(
                        requireActivity(),
                        R.id.activity_root_fragment_nav_host
                    ).popBackStack()
                }
            }
        }.also {
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, it)
        }
    }

    override fun onDestroyView() {
        callback?.remove()
        super.onDestroyView()
    }
}