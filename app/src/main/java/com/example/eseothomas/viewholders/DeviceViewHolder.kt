package com.example.eseothomas.viewholders

import android.view.View
import android.widget.TextView
import com.afollestad.recyclical.ViewHolder
import com.example.eseothomas.R


class DeviceViewHolder(itemView: View) : ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.title)
}
