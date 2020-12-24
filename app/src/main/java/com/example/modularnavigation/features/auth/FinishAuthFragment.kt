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

    companion object {
        const val AUTH_FLOW_RESULT_KEY = "auth_flow_result"
    }

    private var callback: OnBackPressedCallback? = null

    private val finishAuthViewModel: FinishViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_finish_auth_button.setOnClickListener {
            finishAuthViewModel.setFinishAuthFlag()

            // Navigate back from auth flow
            Navigation.findNavController(
                requireActivity(),
                R.id.activity_root_fragment_nav_host
            ).popBackStack(R.id.auth_nav, true)

            findNavController().currentBackStackEntry?.savedStateHandle?.set(AUTH_FLOW_RESULT_KEY, true)
        }

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(
                    requireActivity(),
                    R.id.activity_root_fragment_nav_host
                ).popBackStack()
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