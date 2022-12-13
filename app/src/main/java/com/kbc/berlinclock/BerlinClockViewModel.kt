package com.kbc.berlinclock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BerlinClockViewModel: ViewModel() {
    private val _berlinClockLiveData = MutableLiveData<Blocks>()
    val berlinClockLiveData: LiveData<Blocks> = _berlinClockLiveData

    fun starts() {}
}