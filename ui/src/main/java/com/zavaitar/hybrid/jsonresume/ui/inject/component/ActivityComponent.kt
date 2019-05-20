package com.zavaitar.hybrid.jsonresume.ui.inject.component

import com.zavaitar.hybrid.jsonresume.ui.inject.module.ActivityModule
import com.zavaitar.hybrid.jsonresume.ui.main.HomeActivity
import com.zavaitar.hybrid.jsonresume.ui.splash.activity.SplashActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)

    fun inject(homeActivity: HomeActivity)
}