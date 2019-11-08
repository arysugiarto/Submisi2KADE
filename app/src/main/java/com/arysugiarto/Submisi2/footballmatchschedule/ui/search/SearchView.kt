package com.arysugiarto.Submisi2.footballmatchschedule.ui.search

import com.arysugiarto.Submisi2.footballmatchschedule.entity.List

interface SearchView {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun displayMatch(matchList: kotlin.collections.List<List<Any?>>)
    }
    interface Presenter{
        fun searchMatch(query: String?)
        fun onDestroy()
    }

}