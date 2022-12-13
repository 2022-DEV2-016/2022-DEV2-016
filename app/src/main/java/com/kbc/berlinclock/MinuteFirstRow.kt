package com.kbc.berlinclock

import com.kbc.berlinclock.interfaces.ViewType

data class MinuteFirstRow(val forms: List<ViewType>): ViewType {
    override fun getViewType(): Int = BlockType.MINUTES_FIRST_ROW.ordinal
}
