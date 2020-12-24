package com.example.modularnavigation.features.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.modularnavigation.R
import com.example.modularnavigation.features.auth.FinishAuthFragment
import com.example.modularnavigation.features.auth.StartAuthFragmentArgs


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val authResult = findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.remove<Boolean>(FinishAuthFragment.AUTH_FLOW_RESULT_KEY) == true

        if (authResult) {
            navigateToMainScreen()
            return
        }

        splashViewModel.splashNavCommand.observe(viewLifecycleOwner, Observer {
            when(it){
                SplashNavCommand.NAVIGATE_TO_MAIN -> navigateToMainScreen()
                SplashNavCommand.NAVIGATE_TO_AUTH -> navigateToAuthFlow()
                null -> {
                    // nothing
                }
            }
        })
    }

    private fun navigateToAuthFlow() {
        findNavController().navigate(R.id.action_splashFragment_to_auth_flow, StartAuthFragmentArgs(isFromSplashScreen = true).toBundle())
    }

    private fun navigateToMainScreen() {
        findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
    }
}