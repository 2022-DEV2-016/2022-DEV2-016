package com.kbc.berlinclock

import org.junit.Assert
import org.junit.Test

class BerlinClockTest {

    @Test
    fun `should returns true when parameter is an odd number`() {
        Assert.assertTrue(BerlinClock.isOdd())
    }
}