package com.kbc.berlinclock.entity

import com.kbc.berlinclock.interfaces.ViewType

data class HourSecondRow(val forms: List<ViewType>): ViewType {
    override fun getViewType(): Int = BlockType.HOURS_SECOND_ROW.ordinal
}
