package com.kbc.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kbc.berlinclock.BlockType
import com.kbc.berlinclock.HourFirstRow
import com.kbc.berlinclock.databinding.ItemBlocksBinding
import com.kbc.berlinclock.interfaces.IDelegateAdapter
import com.kbc.berlinclock.interfaces.ViewType

class MinuteSecondRowDelegateAdapter: IDelegateAdapter {
    private lateinit var berlinClockAdapter: BerlinClockAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemBlocksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MinuteSecondViewHolder(view = binding, delegateAdapter = this)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        viewType: ViewType) {
        holder as MinuteSecondViewHolder
        viewType as HourFirstRow
        holder.bind(viewType = viewType)
    }

    class MinuteSecondViewHolder(private val view: ItemBlocksBinding,
                                 private val delegateAdapter: MinuteSecondRowDelegateAdapter): RecyclerView.ViewHolder(view.root) {
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