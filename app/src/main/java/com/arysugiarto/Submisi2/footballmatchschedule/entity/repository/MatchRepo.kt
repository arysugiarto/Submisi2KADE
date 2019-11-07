package com.arysugiarto.Submisi2.footballmatchschedule.entity.repository

import com.arysugiarto.Submisi2.footballmatchschedule.entity.Match
import com.arysugiarto.Submisi2.footballmatchschedule.entity.SearchedMatches
import com.arysugiarto.Submisi2.footballmatchschedule.entity.TeamResponseDetail
import io.reactivex.Flowable

interface MatchRepo {
    fun getLastMatch(id : String) : Flowable<Match>

    fun getTeams(id : String = "0") : Flowable<TeamResponseDetail>

    fun getNextMatch(id : String) : Flowable<Match>

    fun searchMatches(query: String?) : Flowable<SearchedMatches>
}