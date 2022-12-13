package com.kbc.berlinclock.entity

data class Blocks(
    val hourFirstRow: Int,
    val hourSecondRow: Int,
    val minuteFirstRow: Int,
    val minuteSecondRow: Int,
    val isOdd: Boolean,
    val text: String)
