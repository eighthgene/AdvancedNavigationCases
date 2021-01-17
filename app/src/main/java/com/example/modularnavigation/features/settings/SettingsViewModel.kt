package com.example.modularnavigation.features.settings

import androidx.lifecycle.ViewModel
import com.example.modularnavigation.di.GlobalDI

class SettingsViewModel: ViewModel() {
    private val authRepository = GlobalDI.getAuthRepository()

    fun logout(){
        authRepository.putHasAuthData(false)
    }
}