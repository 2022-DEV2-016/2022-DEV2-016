package com.kbc.berlinclock

private const val MODULO_VALUE = 2
private const val BLOCKS_VALUE = 5

fun isOdd(number: Int): Boolean = number.mod(other = MODULO_VALUE) != 0

fun giveMeBlocksForHour(hour: Int, minute: Int): Blocks =
    Blocks(
        hourFirstRow = hour.div(other = BLOCKS_VALUE),
        hourSecondRow = hour.mod(other = BLOCKS_VALUE),
        minuteFirstRow = minute.div(other = BLOCKS_VALUE),
        minuteSecondRow = minute.mod(other = BLOCKS_VALUE)
    )