package com.kbc.berlinclock.entity

import com.kbc.berlinclock.interfaces.ViewType

data class Lamp(val resourceId: Int, val colorId: Int, val width: Int, val height: Int): ViewType {
    override fun getViewType(): Int = BlockType.LAMP.ordinal
}
