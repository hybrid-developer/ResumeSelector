package com.zavaitar.hybrid.jsonresume.ui.splash.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.zavaitar.hybrid.jsonresume.business.core.registerPresenterForLifecycle
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.base.BasePresentationFragment
import com.zavaitar.hybrid.jsonresume.ui.main.HomeActivity
import com.zavaitar.hybrid.jsonresume.ui.splash.mvp.SplashPresenter
import com.zavaitar.hybrid.jsonresume.ui.splash.mvp.SplashView

class SplashFragment : BasePresentationFragment<SplashView, SplashPresenter>(), SplashView {

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun displayErrorMessage(e: Throwable) {
        Snackbar.make(view!!, "Error Occoured while loading data", Snackbar.LENGTH_SHORT).show()
    }

    override fun goToHome() {
        startActivity(Intent(context, HomeActivity::class.java))
        activity?.finishAffinity()
    }
}