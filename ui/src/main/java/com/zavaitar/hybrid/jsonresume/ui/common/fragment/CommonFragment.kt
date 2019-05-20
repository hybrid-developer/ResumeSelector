package com.zavaitar.hybrid.jsonresume.ui.common.fragment

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.adapters.CommonAdapter
import com.zavaitar.hybrid.jsonresume.ui.base.BasePresentationFragment
import com.zavaitar.hybrid.jsonresume.ui.common.mvp.CommonPresenter
import com.zavaitar.hybrid.jsonresume.ui.common.mvp.CommonView
import com.zavaitar.hybrid.jsonresume.ui.main.ResumeSection
import kotlinx.android.synthetic.main.fragement_common.*

class CommonFragment : BasePresentationFragment<CommonView, CommonPresenter>(), CommonView {

    companion object {
        private const val KEY_SELECTED_LIST = "KEY_SELECTED_LIST"
        private const val KEY_SELECTED_SECTION = "KEY_SELECTED_SECTION"
        private const val KEY_SELECTED_SECTION_TITLE = "KEY_SELECTED_SECTION_TITLE"
        fun instance(list: ArrayList<out Parcelable>,
                     section: ResumeSection,
                     title: String): CommonFragment {
            val bundle = Bundle()
            bundle.putParcelableArrayList(KEY_SELECTED_LIST, list)
            bundle.putSerializable(KEY_SELECTED_SECTION, section)
            bundle.putString(KEY_SELECTED_SECTION_TITLE, title)
            val commonFragment = CommonFragment()
            commonFragment.arguments = bundle
            return commonFragment
        }
    }

    private lateinit var linerLayoutManager: LinearLayoutManager
    private lateinit var adapter: CommonAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragement_common, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.list = arguments?.getParcelableArrayList(KEY_SELECTED_LIST)!!
        presenter.section = arguments?.getSerializable(KEY_SELECTED_SECTION) as ResumeSection
        val title = arguments?.getString(KEY_SELECTED_SECTION_TITLE)

        getToolbar().setDisplayHomeAsUpEnabled(true)
        getToolbar().title = title

        linerLayoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
        adapter = CommonAdapter(presenter.section)
        adapter.dataList = presenter.list
        commonRecycleView.layoutManager = linerLayoutManager
        commonRecycleView.itemAnimator = DefaultItemAnimator()
        commonRecycleView.adapter = adapter
    }
}