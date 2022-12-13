package com.kbc.berlinclock

import com.kbc.berlinclock.interfaces.ViewType

data class Rectangle(val resourceId: Int, val colorId: Int, val width: Int, val height: Int):
    ViewType {
    override fun getViewType(): Int = BlockType.RECTANGLE.ordinal
}
