package com.zavaitar.hybrid.jsonresume.ui.resume.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.adapters.ResumeAdapter
import com.zavaitar.hybrid.jsonresume.ui.base.BasePresentationFragment
import com.zavaitar.hybrid.jsonresume.ui.profile.ProfileFragment
import com.zavaitar.hybrid.jsonresume.ui.resume.mvp.ResumeItemClickListener
import com.zavaitar.hybrid.jsonresume.ui.resume.mvp.ResumePresenter
import com.zavaitar.hybrid.jsonresume.ui.resume.mvp.ResumeView
import kotlinx.android.synthetic.main.fragment_resume.*

class ResumeFragment: BasePresentationFragment<ResumeView, ResumePresenter>(), ResumeView, ResumeItemClickListener {

    companion object {
        fun instance(): ResumeFragment {
            return ResumeFragment()
        }
    }

    override var list: List<Resume>
        get() = resumeAdapter.resumeList
        set(value) {
            resumeAdapter.resumeList = value
        }

    private lateinit var linerLayoutManager: LinearLayoutManager
    private val resumeAdapter: ResumeAdapter = ResumeAdapter()

    init {
        resumeAdapter.resumeItemClickListener = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionComponent.inject(this)
    }

    override fun showLoading() {
        // Implementation needed
    }

    override fun hideLoading() {
//        // Implementation needed
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_resume, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getToolbar().title = "Resume Selector"
        getToolbar().setDisplayHomeAsUpEnabled(false)

        linerLayoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
        resumeRecycleView.layoutManager = linerLayoutManager
        resumeRecycleView.itemAnimator = DefaultItemAnimator()
        resumeRecycleView.adapter = resumeAdapter
    }

    override fun onResumeItemClickListener(resume: Resume) {
        fragmentManager!!.beginTransaction()
                .replace(R.id.homeViewContainer, ProfileFragment.instance(resume))
                .addToBackStack("ResumeFragment")
                .commit()
    }
}
