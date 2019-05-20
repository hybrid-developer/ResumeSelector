package com.zavaitar.hybrid.jsonresume.ui.profile

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import com.bumptech.glide.Glide
import com.zavaitar.hybrid.jsonresume.business.data.Basics
import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.adapters.ProfileCategoryAdapter
import com.zavaitar.hybrid.jsonresume.ui.base.BasePresentationFragment
import com.zavaitar.hybrid.jsonresume.ui.common.fragment.CommonFragment
import com.zavaitar.hybrid.jsonresume.ui.main.ResumeSection
import com.zavaitar.hybrid.jsonresume.ui.profile.mvp.ProfilePresenter
import com.zavaitar.hybrid.jsonresume.ui.profile.mvp.ProfileView
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BasePresentationFragment<ProfileView, ProfilePresenter>(),
        ProfileView, ExpandableListView.OnChildClickListener {

    companion object {
        private const val KEY_SELECTED_RESUME = "KEY_SELECTED_RESUME"
        fun instance(resume: Resume): ProfileFragment {
            val bundle = Bundle()
            bundle.putParcelable(KEY_SELECTED_RESUME, resume)
            val profileFragment = ProfileFragment()
            profileFragment.arguments = bundle
            return profileFragment
        }
    }

    private lateinit var profileCategoryAdapter: ProfileCategoryAdapter

    override fun displayProfileData(basics: Basics) {
        Glide.with(profileCandidateAvatar)
                .load(basics.picture)
                .into(profileCandidateAvatar)

        profileCandidateName.text = basics.name
        profileCandidateEmail.text = basics.email
        profileCandidatePhone.text = basics.phone
        profileCandidateWeb.text = basics.website
        profileCandidateSummary.text = basics.summary
    }

    override fun displayResumeCategories() {
        profileCategoryAdapter.categoryList =
                resources.getStringArray(R.array.resumeCategoriesArray).asList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.resume = arguments?.getParcelable(KEY_SELECTED_RESUME) as Resume
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getToolbar().setDisplayHomeAsUpEnabled(true)
        getToolbar().title = presenter.resume.basics.name
        profileCategoryAdapter =  ProfileCategoryAdapter(presenter.resume)
        resumeCategoryRecycleView.setAdapter(profileCategoryAdapter)
        resumeCategoryRecycleView.setOnChildClickListener(this)
    }

    override fun onChildClick(parent: ExpandableListView?, v: View?, groupPosition: Int, childPosition: Int, id: Long): Boolean {
        presenter.displaySelectedCategoryPage(groupPosition)
        return false
    }

    override fun displayCategory(list: List<out Parcelable>, resumeSection: ResumeSection) {
        executeFragmentNavigation(getArrayList(list), resumeSection, resumeSection.name)
    }
}

private fun ProfileFragment.executeFragmentNavigation(list: ArrayList<out Parcelable>,
                                                      section: ResumeSection,
                                                      sectionTitle: String) {
    fragmentManager!!.beginTransaction()
            .replace(R.id.homeViewContainer, CommonFragment.instance(list, section, sectionTitle))
            .addToBackStack("CommonFragment")
            .commit()
}

private fun <T> getArrayList(list: List<T>): ArrayList<T> {
    val arrayList = arrayListOf<T>()
    arrayList.addAll(list)
    return arrayList
}
