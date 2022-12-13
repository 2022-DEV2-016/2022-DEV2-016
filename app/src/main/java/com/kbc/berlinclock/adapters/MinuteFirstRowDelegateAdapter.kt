package com.kbc.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kbc.berlinclock.BlockType
import com.kbc.berlinclock.HourFirstRow
import com.kbc.berlinclock.MinuteFirstRow
import com.kbc.berlinclock.databinding.ItemBlocksBinding
import com.kbc.berlinclock.interfaces.IDelegateAdapter
import com.kbc.berlinclock.interfaces.ViewType

class MinuteFirstRowDelegateAdapter: IDelegateAdapter {
    private lateinit var berlinClockAdapter: BerlinClockAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemBlocksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MinuteFirstRowViewHolder(view = binding, delegateAdapter = this)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        viewType: ViewType
    ) {
        holder as MinuteFirstRowViewHolder
        viewType as HourFirstRow
        viewType as MinuteFirstRow
        holder.bind(viewType = viewType)
    }

    class MinuteFirstRowViewHolder(private val view: ItemBlocksBinding,
                                 private val delegateAdapter: MinuteFirstRowDelegateAdapter): RecyclerView.ViewHolder(view.root) {
        fun bind(viewType: MinuteFirstRow) {
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