package com.arysugiarto.Submisi2.footballmatchschedule.ui.detail

import com.arysugiarto.Submisi2.footballmatchschedule.entity.Team


interface DetailContract {

    interface View{
        fun logoTeamHome(team: Team)
        fun logoTeamAway(team: Team)
    }

    interface Presenter{
        fun getTeamAway(id:String)
        fun getTeamHome(id:String)
    }
}