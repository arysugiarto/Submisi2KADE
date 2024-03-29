package com.arysugiarto.Submisi2.footballmatchschedule.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class List<T>(
    val intHomeShots: String?,
    val strSport: String?,
    val strHomeLineupDefense: String?,
    val strAwayLineupSubstitutes: String?,
    val idLeague: String?,
    val idSoccerXML: String?,
    val strHomeLineupForward: String?,
    val strTVStation: String?,
    val strHomeGoalDetails: String?,
    val strAwayLineupGoalkeeper: String?,
    val strAwayLineupMidfield: String?,
    val idEvent: String?,
    val intRound: String?,
    val strHomeYellowCards: String?,
    val idHomeTeam: String?,
    val intHomeScore: String?,
    val dateEvent: String?,
    val strCountry: String?,
    val strAwayTeam: String?,
    val strHomeLineupMidfield: String?,
    val strDate: String?,
    val strHomeFormation: String?,
    val strMap: String?,
    val idAwayTeam: String?,
    val strAwayRedCards: String?,
    val strBanner: String?,
    val strFanart: String?,
    val strDescriptionEN: String?,
    val strResult: String?,
    val strCircuit: String?,
    val intAwayShots: String?,
    val strFilename: String?,
    val strTime: String?,
    val strAwayGoalDetails: String?,
    val strAwayLineupForward: String?,
    val strLocked: String?,
    val strSeason: String?,
    val intSpectators: String?,
    val strHomeRedCards: String?,
    val strHomeLineupGoalkeeper: String?,
    val strHomeLineupSubstitutes: String?,
    val strAwayFormation: String?,
    val strEvent: String?,
    val strAwayYellowCards: String?,
    val strAwayLineupDefense: String?,
    val strHomeTeam: String?,
    val strThumb: String?,
    val strLeague: String?,
    val intAwayScore: String?,
    val strCity: String?,
    val strPoster: String?
) : Parcelable
