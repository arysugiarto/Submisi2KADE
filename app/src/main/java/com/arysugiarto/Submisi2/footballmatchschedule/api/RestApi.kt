package com.arysugiarto.Submisi2.footballmatchschedule.api

import com.arysugiarto.Submisi2.footballmatchschedule.entity.Match
import com.arysugiarto.Submisi2.footballmatchschedule.entity.SearchedMatches
import com.arysugiarto.Submisi2.footballmatchschedule.entity.TeamResponseDetail
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<Match>

    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id") id:String) : Flowable<Match>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<TeamResponseDetail>

    @GET("searchevents.php")
    fun searchMatches(@Query("e") query: String?) : Flowable<SearchedMatches>
}