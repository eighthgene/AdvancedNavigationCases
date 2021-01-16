package com.example.modularnavigation.features.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.modularnavigation.R
import com.example.modularnavigation.features.auth.FinishAuthFragment
import com.example.modularnavigation.features.auth.StartAuthFragmentArgs


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate with SingleLiveEvent from Splash screen
        splashViewModel.splashNavCommand.observe(viewLifecycleOwner, Observer { splashNavCommand ->

            val navController = Navigation.findNavController(requireActivity(), R.id.activity_root_fragment_nav_host)
            val mainGraph = navController.navInflater.inflate(R.navigation.main_nav)

            // Way to change first screen at runtime.
            mainGraph.startDestination = when(splashNavCommand){
                SplashNavCommand.NAVIGATE_TO_MAIN -> R.id.mainFragment
                SplashNavCommand.NAVIGATE_TO_AUTH -> R.id.auth_nav
                null -> throw IllegalArgumentException("Illegal splash navigation command")
            }
            navController.graph = mainGraph
        })
    }

}