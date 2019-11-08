package com.arysugiarto.Submisi2.footballmatchschedule

import com.arysugiarto.Submisi2.footballmatchschedule.entity.List


interface MatchView {
    interface View{
        fun hideLoading()
        fun showLoading()
        fun showDataMatch(matchList: kotlin.collections.List<List<Any?>>)
    }
    interface Presenter{
        fun getDataMatch()

    }
}