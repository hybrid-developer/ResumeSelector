package com.zavaitar.hybrid.jsonresume.ui.main

import android.os.Bundle
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.base.BaseActivity
import com.zavaitar.hybrid.jsonresume.ui.resume.fragment.ResumeFragment

class HomeActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getActivityComponent().inject(this)
        showUserFragment()
    }

    private fun showUserFragment() {
        supportFragmentManager.beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.homeViewContainer, ResumeFragment.instance())
                .commit()
    }
}