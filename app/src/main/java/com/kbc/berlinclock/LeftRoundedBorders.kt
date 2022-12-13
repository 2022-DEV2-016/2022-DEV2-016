package com.kbc.berlinclock

import com.kbc.berlinclock.interfaces.ViewType

data class LeftRoundedBorders(val resourceId: Int, var colorId: Int, val width: Int, val height: Int): ViewType {
    override fun getViewType(): Int = BlockType.LEFT_BORDERS.ordinal
}
