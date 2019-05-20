package com.zavaitar.hybrid.jsonresume.ui.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

fun <T : RecyclerView.ViewHolder> T.click(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event(adapterPosition, itemViewType)
    }

    return this
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
