package com.kbc.berlinclock

import com.kbc.berlinclock.interfaces.ViewType

data class HourFirstRow(val forms: List<ViewType>): ViewType {
    override fun getViewType(): Int = BlockType.HOURS_FIRST_ROW.ordinal
}
