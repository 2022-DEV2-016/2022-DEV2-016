package com.kbc.berlinclock

import com.kbc.berlinclock.entity.Blocks

private const val MODULO_VALUE = 2
private const val BLOCKS_VALUE = 5
const val tickIntervalMs: Long = 1000
const val HEIGHT = 60

fun isOdd(number: Int): Boolean = number.mod(other = MODULO_VALUE) != 0

fun giveMeBlocksForHour(hour: Int, minute: Int, second: Int): Blocks =
    Blocks(
        hourFirstRow = hour.div(other = BLOCKS_VALUE),
        hourSecondRow = hour.mod(other = BLOCKS_VALUE),
        minuteFirstRow = minute.div(other = BLOCKS_VALUE),
        minuteSecondRow = minute.mod(other = BLOCKS_VALUE),
        isOdd = isOdd(number = second),
        text = "$hour:$minute"
    )