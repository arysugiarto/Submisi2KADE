package com.arysugiarto.Submisi2.footballmatchschedule.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arysugiarto.Submisi2.footballmatchschedule.MatchContract

import com.arysugiarto.Submisi2.footballmatchschedule.R
import com.arysugiarto.Submisi2.footballmatchschedule.adapter.MatchAdapater
import com.arysugiarto.Submisi2.footballmatchschedule.api.ApiService
import com.arysugiarto.Submisi2.footballmatchschedule.api.RestApi
import com.arysugiarto.Submisi2.footballmatchschedule.entity.List
import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import com.arysugiarto.Submisi2.footballmatchschedule.extensions.hide
import com.arysugiarto.Submisi2.footballmatchschedule.extensions.show
import kotlinx.android.synthetic.main.fragment_last.*
import kotlinx.android.synthetic.main.fragment_next.mainProgressBar

class LastFragment : Fragment(), MatchContract.View {

    lateinit var presenter : LastPresenter

    private var ListMatch : MutableList<List<Any?>> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = ApiService.getClient().create(RestApi::class.java)
        val request = Repository(service)
        presenter = LastPresenter(this, request)
        presenter.getDataMatch()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_last, container, false)
    }

    override fun hideLoading() {
        mainProgressBar.hide()
        rvLast.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBar.show()
        rvLast.visibility = View.INVISIBLE
    }

    override fun showDataMatch(listMatch: kotlin.collections.List<List<Any?>>) {
        ListMatch.clear()
        ListMatch.addAll(listMatch)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvLast.layoutManager = layoutManager
        rvLast.adapter = MatchAdapater(listMatch, context)
    }

}
