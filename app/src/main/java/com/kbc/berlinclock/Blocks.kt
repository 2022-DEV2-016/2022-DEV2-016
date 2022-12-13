package com.kbc.berlinclock

data class Blocks(
    val hourFirstRow: Int,
    val hourSecondRow: Int,
    val minuteFirstRow: Int,
    val minuteSecondRow: Int,
    val isOdd: Boolean,
    val text: String)
