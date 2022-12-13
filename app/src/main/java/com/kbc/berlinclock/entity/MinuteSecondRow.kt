package com.kbc.berlinclock.entity

import com.kbc.berlinclock.interfaces.ViewType

data class MinuteSecondRow (val forms: List<ViewType>): ViewType {
    override fun getViewType(): Int = BlockType.MINUTES_SECOND_ROW.ordinal
}