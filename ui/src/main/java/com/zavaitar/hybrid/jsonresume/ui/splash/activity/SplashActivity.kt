package com.zavaitar.hybrid.jsonresume.ui.splash.activity

import android.os.Bundle
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.base.BaseActivity
import com.zavaitar.hybrid.jsonresume.ui.splash.fragment.SplashFragment

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent().inject(this)
        showSplashFragment()
    }

    private fun showSplashFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.splashViewContainer, SplashFragment.newInstance())
                .commit()
    }
}