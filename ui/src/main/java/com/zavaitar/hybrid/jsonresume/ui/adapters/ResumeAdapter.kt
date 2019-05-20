package com.zavaitar.hybrid.jsonresume.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.ListPopupWindow.MATCH_PARENT
import androidx.constraintlayout.widget.ConstraintSet.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.ui.R
import com.zavaitar.hybrid.jsonresume.ui.extensions.click
import com.zavaitar.hybrid.jsonresume.ui.resume.mvp.ResumeItemClickListener
import kotlinx.android.synthetic.main.item_resume.view.*

class ResumeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var resumeItemClickListener: ResumeItemClickListener

    var resumeList: List<Resume> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return resumeList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeViewHolder {
        return ResumeViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_resume, parent, false).apply {
                    layoutParams = RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
                })
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val resume = resumeList[position]
        (holder as? ResumeViewHolder)?.bind(resume)
    }

    inner class ResumeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var candidateNameTextView: TextView = itemView.candidateName
        private var candidateDescriptionTextView: TextView = itemView.candidateDescription
        private var candidateEmailTextView: TextView = itemView.candidateEmail
        private var candidateAvatar: ImageView = itemView.candidateAvatar

        fun bind(resume: Resume) {
            candidateNameTextView.text = resume.basics.name
            candidateDescriptionTextView.text = resume.basics.label
            candidateEmailTextView.text = resume.basics.email
            click { _, _ ->
                resumeItemClickListener.onResumeItemClickListener(resume)
            }

            Glide.with(candidateAvatar)
                    .load(resume.basics.picture)
                    .into(candidateAvatar)
        }
    }
}
