package com.example.modularnavigation.features.auth

import androidx.lifecycle.ViewModel
import com.example.modularnavigation.di.GlobalDI

class FinishViewModel : ViewModel() {

    private val authRepository = GlobalDI.getAuthRepository()


    fun setFinishAuthFlag() {
        authRepository.putHasAuthData(true)
    }
}