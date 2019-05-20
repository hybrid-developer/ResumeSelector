package com.zavaitar.hybrid.jsonresume.ui.inject.component

import com.zavaitar.hybrid.jsonresume.business.injection.SessionScope
import com.zavaitar.hybrid.jsonresume.ui.BaseApp
import com.zavaitar.hybrid.jsonresume.ui.common.fragment.CommonFragment
import com.zavaitar.hybrid.jsonresume.ui.inject.module.SessionModule
import com.zavaitar.hybrid.jsonresume.ui.profile.ProfileFragment
import com.zavaitar.hybrid.jsonresume.ui.resume.fragment.ResumeFragment
import com.zavaitar.hybrid.jsonresume.ui.splash.fragment.SplashFragment
import dagger.Subcomponent
import okhttp3.OkHttpClient

@SessionScope
@Subcomponent(modules = [SessionModule::class])
interface SessionComponent {

    fun okHttpClient(): OkHttpClient

    fun inject(splashFragment: SplashFragment)

    fun inject(resumeFragment: ResumeFragment)

    fun inject(profileFragment: ProfileFragment)

    fun inject(commonFragment: CommonFragment)

    fun inject(baseApp: BaseApp)
}