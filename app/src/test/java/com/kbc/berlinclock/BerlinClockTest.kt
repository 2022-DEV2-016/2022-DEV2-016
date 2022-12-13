package com.kbc.berlinclock

import org.junit.Assert
import org.junit.Test

class BerlinClockTest {

    @Test
    fun `should returns true when parameter is an odd number`() {
        Assert.assertTrue(isOdd(1))
        Assert.assertTrue(isOdd(3))
        Assert.assertTrue(isOdd(5))
        Assert.assertTrue(isOdd(7))
        Assert.assertTrue(isOdd(21))
        Assert.assertTrue(isOdd(23))
        Assert.assertTrue(isOdd(59))
    }

    @Test
    fun `should returns false when parameter is not an odd number`() {
        Assert.assertFalse(isOdd(0))
        Assert.assertFalse(isOdd(2))
        Assert.assertFalse(isOdd(4))
        Assert.assertFalse(isOdd(6))
        Assert.assertFalse(isOdd(12))
        Assert.assertFalse(isOdd(20))
        Assert.assertFalse(isOdd(58))
    }

    @Test
    fun `should returns the class Blocks when gives the hour 18`() {
        val blocks = giveMeBlocksForHour(hour = 18, minute = 0)
        Assert.assertEquals(3, blocks.hourFirstRow)
        Assert.assertEquals(3, blocks.hourSecondRow)
    }

    @Test
    fun `should returns the class Blocks when gives the hour 18 and minutes 35`() {
        val blocks = giveMeBlocksForHour(hour = 18, minute = 35)
        Assert.assertEquals(7, blocks.minuteFirstRow)
        Assert.assertEquals(0, blocks.minuteSecondRow)
    }

    @Test
    fun `should returns the class Blocks when gives the hour 18 and minutes 37`() {
        val blocks = giveMeBlocksForHour(hour = 18, minute = 37)
        Assert.assertEquals(3, blocks.hourFirstRow)
        Assert.assertEquals(3, blocks.hourSecondRow)
        Assert.assertEquals(7, blocks.minuteFirstRow)
        Assert.assertEquals(2, blocks.minuteSecondRow)
    }
}