package com.zavaitar.hybrid.jsonresume.ui

import android.app.Application
import com.zavaitar.hybrid.jsonresume.ui.inject.component.ApplicationComponent
import com.zavaitar.hybrid.jsonresume.ui.inject.component.DaggerApplicationComponent
import com.zavaitar.hybrid.jsonresume.ui.inject.component.SessionComponent
import com.zavaitar.hybrid.jsonresume.ui.inject.module.ApplicationModule
import com.zavaitar.hybrid.jsonresume.ui.inject.module.SessionModule

class BaseApp : Application() {

    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
    }

    val sessionComponent: SessionComponent by lazy {
        appComponent.sessionComponent(SessionModule())
    }
}