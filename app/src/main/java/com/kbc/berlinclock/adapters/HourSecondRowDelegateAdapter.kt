package com.kbc.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kbc.berlinclock.*
import com.kbc.berlinclock.databinding.ItemBlocksBinding
import com.kbc.berlinclock.interfaces.IDelegateAdapter
import com.kbc.berlinclock.interfaces.ViewType

class HourSecondRowDelegateAdapter: IDelegateAdapter {
    private val berlinClockAdapter = BerlinClockAdapter()

    fun resetState() {
        if (berlinClockAdapter.itemCount > 0) {
            for (i in berlinClockAdapter.items.indices) {
                when (val item = berlinClockAdapter.items[i]) {
                    is LeftRoundedBorders -> item.colorId = R.color.white
                    is Rectangle -> item.colorId = R.color.white
                    is RightRoundedBorders -> item.colorId = R.color.white
                }
                berlinClockAdapter.notifyItemChanged(i)
            }
        }
    }

    fun updateItem(number: Int) {
        if (berlinClockAdapter.itemCount > 0) {
            for (i in 0..number.minus(other = 1)) {
                when (val item = berlinClockAdapter.items[i]) {
                    is LeftRoundedBorders -> item.colorId = R.color.berlin_clock_red
                    is Rectangle -> item.colorId = R.color.berlin_clock_red
                    is RightRoundedBorders -> item.colorId = R.color.berlin_clock_red
                }
                berlinClockAdapter.notifyItemChanged(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemBlocksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HourSecondRowViewHolder(view = binding, delegateAdapter = this)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        viewType: ViewType
    ) {
        holder as HourSecondRowViewHolder
        viewType as HourSecondRow
        holder.bind(viewType = viewType)
    }

    class HourSecondRowViewHolder(private val view: ItemBlocksBinding,
                                 private val delegateAdapter: HourSecondRowDelegateAdapter): RecyclerView.ViewHolder(view.root) {
        fun bind(viewType: HourSecondRow) {
            with(view.itemBlocksRecyclerView) {
                layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false) //GridLayoutManager(this.context, 4)
                adapter = delegateAdapter.berlinClockAdapter
                delegateAdapter.berlinClockAdapter.addDelegateAdapter(viewType = BlockType.RIGHT_BORDERS.ordinal, RightRoundedBordersDelegateAdapter())
                delegateAdapter.berlinClockAdapter.addDelegateAdapter(viewType = BlockType.LEFT_BORDERS.ordinal, LeftRoundedBordersDelegateAdapter())
                delegateAdapter.berlinClockAdapter.addDelegateAdapter(viewType = BlockType.RECTANGLE.ordinal, RectangleDelegateAdapter())
                delegateAdapter.berlinClockAdapter.addItems(elements = viewType.forms)
            }
        }
    }
}