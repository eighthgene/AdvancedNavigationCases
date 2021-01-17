package com.example.modularnavigation.features.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.modularnavigation.R
import com.example.modularnavigation.features.splash.SplashNavCommand
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settings_logout.setOnClickListener {
            settingsViewModel.logout()

            val navController = Navigation.findNavController(requireActivity(), R.id.activity_root_fragment_nav_host)
            val mainGraph = navController.navInflater.inflate(R.navigation.main_nav)
            // Way to change first screen at runtime.
            mainGraph.startDestination = R.id.auth_nav
            navController.graph = mainGraph

            findNavController().popBackStack()
        }

        setting_auth_flow.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_auth_flow)
        }

    }
}