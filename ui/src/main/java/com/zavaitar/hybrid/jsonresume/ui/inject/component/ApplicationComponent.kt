package com.zavaitar.hybrid.jsonresume.ui.inject.component

import com.zavaitar.hybrid.jsonresume.business.injection.AppScope
import com.zavaitar.hybrid.jsonresume.ui.inject.module.ApplicationModule
import com.zavaitar.hybrid.jsonresume.ui.inject.module.SessionModule
import dagger.Component

@AppScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun sessionComponent(module: SessionModule): SessionComponent
}