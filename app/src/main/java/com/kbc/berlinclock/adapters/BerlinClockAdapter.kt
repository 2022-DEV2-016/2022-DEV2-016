package com.kbc.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.kbc.berlinclock.databinding.ItemDetaultBinding
import com.kbc.berlinclock.interfaces.IDelegateAdapter
import com.kbc.berlinclock.interfaces.ViewType

class BerlinClockAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items = mutableListOf<ViewType>()
    private val delegateAdapters = SparseArrayCompat<IDelegateAdapter>()

    fun addDelegateAdapter(viewType: Int, delegateAdapter: IDelegateAdapter) {
        delegateAdapters.put(viewType, delegateAdapter)
    }

    fun getDelegateAdapter(viewType: Int): IDelegateAdapter? = delegateAdapters.get(viewType)

    fun addItems(elements: List<ViewType>) {
        val startIndex = items.size
        val endIndex = elements.size
        items.addAll(elements = elements)
        notifyItemRangeInserted(startIndex, endIndex)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].getViewType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters[viewType]?.let { it.onCreateViewHolder(parent = parent, viewType = viewType) }
            ?: DefaultViewHolder(view = ItemDetaultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters[getItemViewType(position)]?.let { it.onBindViewHolder(holder = holder, position = position, viewType = items[position]) }
    }

    class DefaultViewHolder(val view: ItemDetaultBinding): RecyclerView.ViewHolder(view.root)
}