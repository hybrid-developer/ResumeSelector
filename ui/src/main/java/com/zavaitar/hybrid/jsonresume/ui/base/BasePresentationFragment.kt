package com.zavaitar.hybrid.jsonresume.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zavaitar.hybrid.jsonresume.business.core.registerPresenterForLifecycle
import com.zavaitar.hybrid.jsonresume.ui.BaseApp
import com.zavaitar.hybrid.jsonresume.ui.inject.component.SessionComponent
import javax.inject.Inject

abstract class BasePresentationFragment<V : BaseRequestPresenter.ViewInterface, P : BasePresenter<V>>
    : Fragment(), BaseRequestPresenter.ViewInterface {

    @Inject
    protected lateinit var presenter: P
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this as V)
        registerPresenterForLifecycle(presenter)
    }

    protected fun getToolbar() = (activity as AppCompatActivity).supportActionBar!!

    override fun onDestroyView() {
        presenter.onDetach(this as V)
        super.onDestroyView()
    }

    val sessionComponent: SessionComponent
        get() = (requireActivity().applicationContext as BaseApp).sessionComponent


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity!!.onBackPressed()
                true
            }
            else -> false
        }
    }

    override fun showLoading() {
       // No Implementation needed
    }

    override fun hideLoading() {
        // No Implementation needed
    }
}