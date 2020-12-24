package com.example.modularnavigation

import android.app.Application
import com.example.modularnavigation.di.GlobalDI

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalDI.initWithContext(this)
    }
}