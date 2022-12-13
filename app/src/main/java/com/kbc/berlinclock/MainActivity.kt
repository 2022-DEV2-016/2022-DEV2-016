package com.kbc.berlinclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kbc.berlinclock.adapters.*
import com.kbc.berlinclock.databinding.ActivityMainBinding
import com.kbc.berlinclock.interfaces.ViewType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var berlinClockAdapter: BerlinClockAdapter
    private val berlinClockViewModel: BerlinClockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeRecyclerView()
        with(berlinClockViewModel) {
            starts()
            berlinClockLiveData.observe(this@MainActivity, this@MainActivity::manageBlocks)
        }
    }

    private fun isAdapterInitialized(): Boolean = this::berlinClockAdapter.isInitialized

    private fun manageBlocks(blocks: Blocks) {
        if (isAdapterInitialized()) {
            //seconds:
            berlinClockAdapter.getDelegateAdapter(viewType = BlockType.LAMP.ordinal)?.let { iDelegateAdapter ->
                if (iDelegateAdapter is LampDelegateAdapter && berlinClockAdapter.itemCount > 0) {
                    iDelegateAdapter.update(isOdd = blocks.isOdd)
                }
            }
            //hours first row
            berlinClockAdapter.getDelegateAdapter(viewType = BlockType.HOURS_FIRST_ROW.ordinal)?.let { iDelegateAdapter ->
                if (iDelegateAdapter is HourFirstRowDelegateAdapter && blocks.hourFirstRow > 0 && berlinClockAdapter.itemCount > 0) {
                    iDelegateAdapter.resetState()
                    iDelegateAdapter.updateItem(number = blocks.hourFirstRow)
                }
            }
            //hour second row
            berlinClockAdapter.getDelegateAdapter(viewType = BlockType.HOURS_SECOND_ROW.ordinal)?.let { iDelegateAdapter ->
                if (iDelegateAdapter is HourSecondRowDelegateAdapter && blocks.hourSecondRow > 0 && berlinClockAdapter.itemCount > 0) {
                    iDelegateAdapter.resetState()
                    iDelegateAdapter.updateItem(number = blocks.hourSecondRow)
                }
            }
            //minutes first row
            berlinClockAdapter.getDelegateAdapter(viewType = BlockType.MINUTES_FIRST_ROW.ordinal)?.let { iDelegateAdapter ->
                if (iDelegateAdapter is MinuteFirstRowDelegateAdapter && blocks.minuteFirstRow > 0 && berlinClockAdapter.itemCount > 0) {
                    iDelegateAdapter.resetState()
                    iDelegateAdapter.updateItem(number = blocks.minuteFirstRow )
                }
            }
            // minutes second row
            berlinClockAdapter.getDelegateAdapter(viewType = BlockType.MINUTES_SECOND_ROW.ordinal)?.let { iDelegateAdapter ->
                if (iDelegateAdapter is MinuteSecondRowDelegateAdapter && blocks.minuteSecondRow > 0 && berlinClockAdapter.itemCount > 0) {
                    iDelegateAdapter.resetState()
                    iDelegateAdapter.updateItem(number = blocks.minuteSecondRow)
                }
            }
            //text
            //binding.result.text = result.text
        }
    }

    private fun initializeRecyclerView() {
        with(binding.activityMainRecyclerView) {
            berlinClockAdapter = BerlinClockAdapter()
            layoutManager = LinearLayoutManager(this.context)
            adapter = berlinClockAdapter
            berlinClockAdapter.addDelegateAdapter(viewType = BlockType.LAMP.ordinal, LampDelegateAdapter())
            berlinClockAdapter.addDelegateAdapter(viewType = BlockType.HOURS_FIRST_ROW.ordinal, HourFirstRowDelegateAdapter())
            berlinClockAdapter.addDelegateAdapter(viewType = BlockType.HOURS_SECOND_ROW.ordinal, HourSecondRowDelegateAdapter())
            berlinClockAdapter.addDelegateAdapter(viewType = BlockType.MINUTES_FIRST_ROW.ordinal, MinuteFirstRowDelegateAdapter())
            berlinClockAdapter.addDelegateAdapter(viewType = BlockType.MINUTES_SECOND_ROW.ordinal, MinuteSecondRowDelegateAdapter())
            berlinClockAdapter.addItems(elements = getItems())
            visibility = View.VISIBLE
        }
    }

    private fun getItems(): List<ViewType> {
        val list = mutableListOf<ViewType>()
        list.add(element = Lamp(colorId = R.color.white, resourceId = R.drawable.ic_lamp, width = 100, height = 100))
        //HOURS
        list.add(element = HourFirstRow(forms = getRows(end = 3, width = 100)))
        list.add(element = HourSecondRow(forms = getRows(end = 3, width = 100)))
        //MINUTES
        list.add(element = MinuteFirstRow(forms = getRows(end = 10, width = 36)))
        list.add(element = MinuteSecondRow(forms = getRows(end = 3, width = 100)))
        return list
    }

    private fun getRows(end: Int, width: Int): List<ViewType> {
        val list = mutableListOf<ViewType>()
        for (i in 0..end) {
            when {
                i == 0 -> {
                    list.add(element = LeftRoundedBorders(colorId = R.color.white, resourceId = R.drawable.ic_left_rounded_borders, width = width, height = HEIGHT))
                }
                i < end -> list.add(element = Rectangle(colorId = R.color.white, resourceId = R.drawable.ic_rectangle, width = width, height =HEIGHT))
                i == end -> {
                    list.add(element = Rectangle(colorId = R.color.white, resourceId = R.drawable.ic_right_rounded_borders, width = width, height = HEIGHT))
                }
                else -> {
                    list.add(element = RightRoundedBorders(colorId = R.color.white, resourceId = R.drawable.ic_rectangle, width = width, height = HEIGHT))
                }
            }
        }
        return list
    }
}