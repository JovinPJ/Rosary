package com.mary.rosary.data

data class Rosary(
    val crossSignLong: Prayer = Prayers.crossSignLong,
    val apostlesCreed: Prayer = Prayers.apostlesCreed,
    val beforeMystery: Mystery = Mystery(hailMary = List(3) { Prayers.hailMary }, ohMyJesus = null),
    val mysteries: List<Mystery> = List(size = 5) { Mystery() },
    val crossSignLongEnd: Prayer = Prayers.crossSignLong,
) {
    fun getPrayers(): List<Prayer> {
        val prayers = mutableListOf<Prayer>()
        prayers.add(crossSignLong)
        prayers.add(apostlesCreed)
        prayers.addAll(beforeMystery.getPrayers())
        for (mystery in mysteries) {
            prayers.addAll(mystery.getPrayers())
        }
        prayers.add(crossSignLongEnd)
        return prayers
    }
}

data class Mystery(
    val ourFather: Prayer = Prayers.ourFather,
    val hailMary: List<Prayer> = List(size = 10) { Prayers.hailMary },
    val crossSign: Prayer = Prayers.crossSignSmall,
    val ohMyJesus: Prayer? = Prayers.ohMyJesus
) {
    fun getPrayers(): List<Prayer> {
        val prayers = mutableListOf<Prayer>()
        prayers.add(ourFather)
        prayers.addAll(hailMary)
        prayers.add(crossSign)
        ohMyJesus?.let {
            prayers.add(it)
        }

        return prayers
    }
}

data class Prayer(
    val title: Int,
    val content: Int
)
