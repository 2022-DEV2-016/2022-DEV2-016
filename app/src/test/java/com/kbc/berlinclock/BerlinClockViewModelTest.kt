package com.kbc.berlinclock

import org.junit.Test

class BerlinClockViewModelTest {

    private lateinit var berlinClockViewModel: BerlinClockViewModel

    @Test
    fun `should have a Blocks class in live data when use the function starts`() {
        berlinClockViewModel = BerlinClockViewModel()
        berlinClockViewModel.blocksLiveData()

    }
}