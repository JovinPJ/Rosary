package com.mary.rosary.ui.screen

import androidx.lifecycle.ViewModel
import com.mary.rosary.data.Prayer
import com.mary.rosary.domain.RosaryStateUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RosaryViewModal(private val rosaryStateUseCase: RosaryStateUseCase = RosaryStateUseCase()) :
    ViewModel() {

    private val _uiState = MutableStateFlow(rosaryStateUseCase.start())
    val uiState: StateFlow<Prayer> = _uiState.asStateFlow()

    fun resetRosary() {
        _uiState.value = rosaryStateUseCase.start()
    }

    fun getNextPrayer() {
        _uiState.value = rosaryStateUseCase.next()
    }

}