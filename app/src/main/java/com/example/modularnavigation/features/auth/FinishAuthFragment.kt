package com.example.modularnavigation.features.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.modularnavigation.R
import kotlinx.android.synthetic.main.fragment_auth_finish.*

class FinishAuthFragment : Fragment(R.layout.fragment_auth_finish) {

    private val finishAuthViewModel: FinishViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_finish_auth_button.setOnClickListener {
            // Save hasAuthData flag in prefs
            finishAuthViewModel.setFinishAuthFlag()

            val result = findNavController().popBackStack(R.id.auth_nav, true)

            // Navigate back from auth flow
            if (result.not()) {
                // we can't open new destination with this action
                // --> we opened Auth flow from splash
                // --> need to open main graph
                findNavController().navigate(R.id.mainFragment)
            }
        }
    }

}