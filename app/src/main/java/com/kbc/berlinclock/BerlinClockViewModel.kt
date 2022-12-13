package com.kbc.berlinclock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.*

class BerlinClockViewModel: ViewModel() {
    private val _berlinClockLiveData = MutableLiveData<Blocks>()
    val berlinClockLiveData: LiveData<Blocks> = _berlinClockLiveData

    private fun everySeconds(): Flow<Unit> = flow {
        while (true) {
            emit(Unit)
            delay(tickIntervalMs)
        }
    }

    fun starts() {
        viewModelScope.launch(Dispatchers.IO) {

            everySeconds()
                .collect {
                    with(Calendar.getInstance()) {
                        val h = this[Calendar.HOUR_OF_DAY]
                        val m = this[Calendar.MINUTE]
                        val s = this[Calendar.SECOND]
                        _berlinClockLiveData.postValue(giveMeBlocksForHour(hour = h, minute = m, second = s))
                    }
                }
        }
    }

}