package com.kbc.berlinclock.interfaces

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface IDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, viewType: IViewType)
}