package com.mary.rosary.domain

import com.mary.rosary.data.Prayer
import com.mary.rosary.data.Rosary

class RosaryStateUseCase(val rosary: Rosary = Rosary()) {

    private var progress = 0

    private val rosaryPrayer = rosary.getPrayers()

    fun start(): Prayer {
        progress = 0
        return rosaryPrayer[progress]
    }

    fun next(): Prayer {
        progress++
        if (progress == rosaryPrayer.size)
            progress = 0

        return rosaryPrayer[progress]
    }

}