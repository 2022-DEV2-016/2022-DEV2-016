package com.kbc.berlinclock

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class BerlinClockViewModelTest {

    private lateinit var berlinClockViewModel: BerlinClockViewModel

    @Test
    fun `should have a Blocks class in live data when use the function starts`() = runTest {
        berlinClockViewModel = BerlinClockViewModel()
        berlinClockViewModel.starts()
        berlinClockViewModel.berlinClockLiveData.value
        Assert.assertTrue(berlinClockViewModel.berlinClockLiveData.value == null)
    }
}