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

    @Test
    fun `should returns the class Blocks and isOdd when gives the hour 23 and minutes 59`() {
        val blocks = giveMeBlocksForHour(hour = 23, minute = 59)
        val isOdd = isOdd(number = 59)
        Assert.assertTrue(isOdd)
        Assert.assertEquals(4, blocks.hourFirstRow)
        Assert.assertEquals(3, blocks.hourSecondRow)
        Assert.assertEquals(11, blocks.minuteFirstRow)
        Assert.assertEquals(4, blocks.minuteSecondRow)
    }

    @Test
    fun `should returns the class Blocks and isOdd when gives the hour 0 and minutes 0`() {
        val blocks = giveMeBlocksForHour(hour = 0, minute = 0)
        val isOdd = isOdd(number = 0)
        Assert.assertFalse(isOdd)
        Assert.assertEquals(0, blocks.hourFirstRow)
        Assert.assertEquals(0, blocks.hourSecondRow)
        Assert.assertEquals(0, blocks.minuteFirstRow)
        Assert.assertEquals(0, blocks.minuteSecondRow)
    }

    @Test
    fun `should returns the class Blocks and isOdd when gives the hour 3 and minutes 9`() {
        val blocks = giveMeBlocksForHour(hour = 3, minute = 9)
        val isOdd = isOdd(number = 51)
        Assert.assertTrue(isOdd)
        Assert.assertEquals(0, blocks.hourFirstRow)
        Assert.assertEquals(3, blocks.hourSecondRow)
        Assert.assertEquals(1, blocks.minuteFirstRow)
        Assert.assertEquals(4, blocks.minuteSecondRow)
    }


    @Test
    fun `should returns the class Blocks and isOdd when gives the hour 12 and minutes 2`() {
        val blocks = giveMeBlocksForHour(hour = 12, minute = 2)
        val isOdd = isOdd(number = 47)
        Assert.assertTrue(isOdd)
        Assert.assertEquals(2, blocks.hourFirstRow)
        Assert.assertEquals(2, blocks.hourSecondRow)
        Assert.assertEquals(0, blocks.minuteFirstRow)
        Assert.assertEquals(2, blocks.minuteSecondRow)
    }

    @Test
    fun `should returns the class Blocks and isOdd when gives the hour 22 and minutes 55`() {
        val blocks = giveMeBlocksForHour(hour = 22, minute = 55)
        val isOdd = isOdd(number = 50)
        Assert.assertFalse(isOdd)
        Assert.assertEquals(4, blocks.hourFirstRow)
        Assert.assertEquals(2, blocks.hourSecondRow)
        Assert.assertEquals(11, blocks.minuteFirstRow)
        Assert.assertEquals(0, blocks.minuteSecondRow)
    }

    @Test
    fun `should returns the class Blocks and isOdd when gives the hour 15 and minutes 55`() {
        val blocks = giveMeBlocksForHour(hour = 15, minute = 0)
        val isOdd = isOdd(number = 0)
        Assert.assertFalse(isOdd)
        Assert.assertEquals(3, blocks.hourFirstRow)
        Assert.assertEquals(0, blocks.hourSecondRow)
        Assert.assertEquals(0, blocks.minuteFirstRow)
        Assert.assertEquals(0, blocks.minuteSecondRow)
    }
}