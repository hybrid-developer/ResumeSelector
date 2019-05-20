package com.zavaitar.hybrid.jsonresume.ui.adapters

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.zavaitar.hybrid.jsonresume.business.data.*
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.extensions.inflate
import kotlinx.android.synthetic.main.item_categories.view.*
import kotlinx.android.synthetic.main.item_education.view.*
import kotlinx.android.synthetic.main.item_publications.view.*
import kotlinx.android.synthetic.main.item_reference.view.*
import kotlinx.android.synthetic.main.item_skill.view.*
import kotlinx.android.synthetic.main.item_work.view.*

class ProfileCategoryAdapter internal constructor(private val resume: Resume)
    : BaseExpandableListAdapter() {

    var categoryList: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return when (listPosition) {
            0 -> resume.work[expandedListPosition]
            1 -> resume.education[expandedListPosition]
            2 -> resume.skills[expandedListPosition]
            3 -> resume.publications[expandedListPosition]
            4 -> resume.references[expandedListPosition]
            else -> Throwable("Error in fetching child")
        }
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View? {

        val child = getChild(groupPosition, childPosition)
        return when (groupPosition) {
            0 -> {
                val work = child as Work
                val view = parent.inflate(R.layout.item_work)
                view.workCompanyName.text = work.company
                view.workPosition.text = work.position
                view.workWebsite.text = work.website
                view.workStartDate.text = work.startDate
                view.workEndDate.text = work.endDate
                view.workSummary.text = work.summary
                view.workHighlights.text = work.highlights.joinToString("\n")
                return view
            }
            1 -> {
                val education = child as Education
                val view = parent.inflate(R.layout.item_education)
                view.educationInstitution.text = education.institution
                view.educationArea.text = education.area
                view.educationStudyType.text = education.studyType
                view.educationStartDate.text = education.startDate
                view.educationEndDate.text = education.endDate
                view.educationGpa.text = education.gpa
                view.educationCources.text = education.courses.joinToString { "\n" }

                return view
            }
            2 -> {
                val skill = child as Skills
                val view = parent.inflate(R.layout.item_skill)
                view.skilleName.text = skill.name
                view.skillLevel.text = skill.level
                view.skillKeywords.text = skill.keywords.joinToString("\n")
                return view
            }
            3 -> {
                val publications = child as Publications
                val view = parent.inflate(R.layout.item_publications)
                view.publicationName.text = publications.name
                view.publicationPublisher.text = publications.publisher
                view.publicationReleaseDate.text = publications.releaseDate
                view.publicationWebsite.text = publications.website
                view.publicationSummary.text = publications.summary
                return view

            }
            4 -> {
                val reference = child as References
                val view = parent.inflate(R.layout.item_reference)
                view.referenceName.text = reference.name
                view.referenceDescription.text = reference.reference
                return view
            }

            else -> convertView
        }
    }

    override fun getGroupView(listPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View? {
        var parentView = convertView
        val categoryName = getGroup(listPosition) as String
        if (parentView == null) {
            parentView = parent.inflate(R.layout.item_categories)
        }

        parentView.categoryName.setTypeface(null, Typeface.BOLD)
        parentView.categoryName.text = categoryName

        val categoryIconArray = parentView.context.resources.obtainTypedArray(R.array.categoryIcons)
        val categoryIcon = categoryIconArray.getResourceId(listPosition, -1)
        parentView.categoryIcon.setImageResource(categoryIcon)
        categoryIconArray.recycle()

        return parentView
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return when (listPosition) {
            0 -> resume.work.size
            1 -> resume.education.size
            2 -> resume.skills.size
            3 -> resume.publications.size
            4 -> resume.references.size
            else -> 0
        }
    }

    override fun getGroup(listPosition: Int): Any {
        return this.categoryList[listPosition]
    }

    override fun getGroupCount(): Int {
        return this.categoryList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}


