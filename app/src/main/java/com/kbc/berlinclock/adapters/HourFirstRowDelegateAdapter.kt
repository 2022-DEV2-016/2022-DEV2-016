package com.kbc.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kbc.berlinclock.*
import com.kbc.berlinclock.databinding.ItemBlocksBinding
import com.kbc.berlinclock.entity.*
import com.kbc.berlinclock.interfaces.IDelegateAdapter
import com.kbc.berlinclock.interfaces.ViewType

class HourFirstRowDelegateAdapter: IDelegateAdapter {
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
        return HourFirstRowViewHolder(view = binding, delegateAdapter = this)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        viewType: ViewType) {
        holder as HourFirstRowViewHolder
        viewType as HourFirstRow
        holder.bind(viewType = viewType)
    }

    class HourFirstRowViewHolder(private val view: ItemBlocksBinding,
                                 private val delegateAdapter: HourFirstRowDelegateAdapter): RecyclerView.ViewHolder(view.root) {
        fun bind(viewType: HourFirstRow) {
            with(view.itemBlocksRecyclerView) {
                layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false) //GridLayoutManager(this.context, 4)
                adapter = delegateAdapter.berlinClockAdapter
                with(delegateAdapter.berlinClockAdapter) {
                    addDelegateAdapter(viewType = BlockType.RIGHT_BORDERS.ordinal, RightRoundedBordersDelegateAdapter())
                    addDelegateAdapter(viewType = BlockType.LEFT_BORDERS.ordinal, LeftRoundedBordersDelegateAdapter())
                    addDelegateAdapter(viewType = BlockType.RECTANGLE.ordinal, RectangleDelegateAdapter())
                    addItems(elements = viewType.forms)
                }
            }
        }
    }
}