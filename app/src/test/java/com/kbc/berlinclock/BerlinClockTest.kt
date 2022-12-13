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
}