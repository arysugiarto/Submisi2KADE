package com.arysugiarto.Submisi2.footballmatchschedule.entity.repository

import com.arysugiarto.Submisi2.footballmatchschedule.api.RestApi
import com.arysugiarto.Submisi2.footballmatchschedule.entity.Match
import com.arysugiarto.Submisi2.footballmatchschedule.entity.TeamResponseDetail
import io.reactivex.Flowable

class Repository (private val restApi: RestApi) : MatchRepo {
    override fun searchMatches(query: String?) = restApi.searchMatches(query)

    override fun getNextMatch(id: String): Flowable<Match> = restApi.getNextMatch(id)

    override fun getLastMatch(id: String): Flowable<Match> = restApi.getLastmatch(id)

    override fun getTeams(id: String): Flowable<TeamResponseDetail> = restApi.getTeam(id)
}