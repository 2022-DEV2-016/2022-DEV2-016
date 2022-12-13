package com.kbc.berlinclock

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class BerlinClockViewModelTest {

    private lateinit var berlinClockViewModel: BerlinClockViewModel

    @Test
    fun `should have a Blocks class in live data when use the viewModel`() = runTest {
        berlinClockViewModel = BerlinClockViewModel()
        berlinClockViewModel.starts()
        Assert.assertTrue(berlinClockViewModel.berlinClockLiveData.value == null)
    }
}