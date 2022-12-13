package com.kbc.berlinclock.adapters

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kbc.berlinclock.R
import com.kbc.berlinclock.Rectangle
import com.kbc.berlinclock.databinding.ItemBlockBinding
import com.kbc.berlinclock.interfaces.IDelegateAdapter
import com.kbc.berlinclock.interfaces.ViewType

class RectangleDelegateAdapter: IDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(view = ItemBlockBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, viewType: ViewType) {
        holder as ItemViewHolder
        viewType as Rectangle
        holder.bind(viewType = viewType)
    }

    private class ItemViewHolder(private val view: ItemBlockBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(viewType: Rectangle) {
            view.root.setBackgroundResource(viewType.resourceId)
            view.root.setBackgroundResource(viewType.resourceId)
            view.root.layoutParams?.let { lp ->
                lp.width = viewType.width
                lp.height = viewType.height
            }
            view.root.background?.let { drawable ->
                //stroke color
                val drawable = drawable as GradientDrawable
                drawable.mutate() // only change this instance of the xml, not all components using this xml
                drawable.setStroke(5, ContextCompat.getColor(view.root.context, R.color.berlin_clock_gray)) // set stroke width and stroke color
                //solid color
                drawable.setColor(ContextCompat.getColor(view.root.context, viewType.colorId)) // set solid color
            }
        }
    }
}