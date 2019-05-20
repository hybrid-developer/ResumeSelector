package com.zavaitar.hybrid.jsonresume.ui.adapters

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import com.zavaitar.hybrid.jsonresume.business.data.*
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.extensions.inflate
import com.zavaitar.hybrid.jsonresume.ui.main.ResumeSection
import kotlinx.android.synthetic.main.item_education.view.*
import kotlinx.android.synthetic.main.item_publications.view.*
import kotlinx.android.synthetic.main.item_reference.view.*
import kotlinx.android.synthetic.main.item_skill.view.*
import kotlinx.android.synthetic.main.item_work.view.*

class CommonAdapter(private var selectedSection: ResumeSection) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var dataList: List<Any> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return buildViewHolderAccordingToSection(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CommonViewHolder)?.bind(position)
    }

    private fun buildViewHolderAccordingToSection(parent: ViewGroup): CommonViewHolder {

        val layoutResource = when (selectedSection) {
            ResumeSection.REFERENCE -> R.layout.item_reference
            ResumeSection.WORK -> R.layout.item_work
            ResumeSection.EDUCATION -> R.layout.item_education
            ResumeSection.SKILLS -> R.layout.item_skill
            ResumeSection.PUBLICATIONS -> R.layout.item_publications
        }

        val layoutInflater = parent.inflate(layoutResource)
        layoutInflater.layoutParams = RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        return CommonViewHolder(layoutInflater)
    }

    inner class CommonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {

            when (selectedSection) {
                ResumeSection.REFERENCE -> {
                    val reference = (dataList as List<References>)[position]
                    itemView.referenceName.text = reference.name
                    itemView.referenceDescription.text = reference.reference
                }
                ResumeSection.WORK -> {
                    val work = (dataList as List<Work>)[position]
                    itemView.workCompanyName.text = work.company
                    itemView.workPosition.text = work.position
                    itemView.workWebsite.text = work.website
                    itemView.workStartDate.text = work.startDate
                    itemView.workEndDate.text = work.endDate
                    itemView.workSummary.text = work.summary
                    itemView.workHighlights.text = work.highlights.joinToString()
                }
                ResumeSection.EDUCATION -> {
                    val education = (dataList as List<Education>)[position]
                    itemView.educationInstitution.text = education.institution
                    itemView.educationArea.text = education.area
                    itemView.educationStudyType.text = education.studyType
                    itemView.educationStartDate.text = education.startDate
                    itemView.educationEndDate.text = education.endDate
                    itemView.educationGpa.text = education.gpa
                    itemView.educationCources.text = education.courses.joinToString { "\n" }
                }
                ResumeSection.SKILLS -> {
                    val skill = (dataList as List<Skills>)[position]
                    itemView.skilleName.text = skill.name
                    itemView.skillLevel.text = skill.level
                    itemView.skillKeywords.text = skill.keywords.joinToString()
                }
                ResumeSection.PUBLICATIONS -> {
                    val publications = (dataList as List<Publications>)[position]
                    itemView.publicationName.text = publications.name
                    itemView.publicationPublisher.text = publications.publisher
                    itemView.publicationReleaseDate.text = publications.releaseDate
                    itemView.publicationWebsite.text = publications.website
                    itemView.publicationSummary.text = publications.summary
                }
            }
        }
    }
}