package com.zavaitar.hybrid.jsonresume.ui.inject.module

import android.app.Application
import com.zavaitar.hybrid.jsonresume.business.injection.AppScope
import com.zavaitar.hybrid.jsonresume.ui.BaseApp
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @AppScope
    fun providesApplication(): Application {
        return baseApp
    }
}