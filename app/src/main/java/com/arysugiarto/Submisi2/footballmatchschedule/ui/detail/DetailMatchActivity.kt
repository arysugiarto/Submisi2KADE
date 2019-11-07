package com.arysugiarto.Submisi2.footballmatchschedule.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arysugiarto.Submisi2.footballmatchschedule.R
import com.arysugiarto.Submisi2.footballmatchschedule.api.ApiService
import com.arysugiarto.Submisi2.footballmatchschedule.api.RestApi
import com.arysugiarto.Submisi2.footballmatchschedule.entity.Team
import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import com.bumptech.glide.Glide
import com.arysugiarto.Submisi2.footballmatchschedule.entity.List
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailMatchActivity : AppCompatActivity(), DetailContract.View {

    override fun logoTeamAway(team: Team) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .apply(RequestOptions().placeholder(R.drawable.ic_ball))
            .into(awayImg)
    }

    override fun logoTeamHome(team: Team) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .apply(RequestOptions().placeholder(R.drawable.ic_ball))
            .into(homeImg)
    }

    lateinit var mPresenter : DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val service = ApiService.getClient().create(RestApi::class.java)
        val request = Repository(service)
        mPresenter = DetailPresenter(this, request)

        val event = intent.getParcelableExtra<List<Any?>>("match")
        event.idAwayTeam?.let { mPresenter.getTeamAway(it) }
        event.idHomeTeam?.let { mPresenter.getTeamHome(it) }
        initData(event)
        supportActionBar?.title = event.strEvent
    }

    fun initData(event:List<Any?>){
        dateScheduleTv.text = event.dateEvent
        homeNameTv.text = event.strHomeTeam
        homeScoreTv.text = event.intHomeScore
        awayNameTv.text = event.strAwayTeam
        awayScoreTv.text = event.intAwayScore

        homeScorerTv.text = event.strHomeGoalDetails
        awayScorerTv.text= event.strAwayGoalDetails

        gkHomeTv.text = event.strHomeLineupGoalkeeper
        gkAwayTv.text = event.strAwayLineupGoalkeeper

        defHomeTv.text = event.strHomeLineupDefense
        defAwayTv.text = event.strAwayLineupDefense

        midHomeTv.text = event.strHomeLineupMidfield
        midAwayTv.text = event.strAwayLineupMidfield

        forHomeTv.text = event.strHomeLineupForward
        forAwayTv.text = event.strAwayLineupForward

        subHomeTv.text = event.strHomeLineupSubstitutes
        subAwayTv.text = event.strAwayLineupSubstitutes

    }
}
