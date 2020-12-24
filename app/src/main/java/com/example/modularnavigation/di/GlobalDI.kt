package com.example.modularnavigation.di

import android.content.Context
import com.example.modularnavigation.domain.AuthRepository


/**
 * Singleton for "DI" in our example app
 */
object GlobalDI {

    private lateinit var applicationContext: Context


    fun initWithContext(applicationContext: Context) {
        GlobalDI.applicationContext = applicationContext
    }

    fun getAuthRepository(): AuthRepository {
        return AuthRepository(applicationContext)
    }



}