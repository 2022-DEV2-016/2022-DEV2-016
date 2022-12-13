package com.kbc.berlinclock

import org.junit.Assert
import org.junit.Test

class BlockTest {

    private val block = Blocks(hourFirstRow = 3, hourSecondRow = 1, minuteFirstRow = 6, minuteSecondRow = 0)

    @Test
    fun `should have the property hourFirstRow when use the class Block`() {
        Assert.assertEquals(3, block.hourFirstRow)
    }

    @Test
    fun `should have the property hourSecondRow when use the class Block`() {
        Assert.assertEquals(1, block.hourSecondRow)
    }

    @Test
    fun `should have the property minuteFirstRow when use the class Block`() {
        Assert.assertEquals(6, block.minuteFirstRow)
    }

    @Test
    fun `should have the property minuteSecondRow when use the class Block`() {
        Assert.assertEquals(0, block.minuteSecondRow)
    }
}