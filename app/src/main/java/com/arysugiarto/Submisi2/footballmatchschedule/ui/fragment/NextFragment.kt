package com.arysugiarto.Submisi2.footballmatchschedule.ui.fragment

import NextPresenter
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
import kotlinx.android.synthetic.main.fragment_next.*


class NextFragment : Fragment(), MatchContract.View {

    lateinit var presenter: NextPresenter
    private var ListMatch : MutableList<List<Any?>> = mutableListOf()

    override fun hideLoading() {
        mainProgressBar.hide()
        rvNext.visibility = View.VISIBLE
    }
    override fun showLoading() {
        mainProgressBar.show()
        rvNext.visibility = View.INVISIBLE
    }
    override fun showDataMatch(listmatch: kotlin.collections.List<List<Any?>>) {
        ListMatch.clear()
        ListMatch.addAll(listmatch)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvNext.layoutManager = layoutManager
        rvNext.adapter = MatchAdapater(listmatch, context)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = ApiService.getClient().create(RestApi::class.java)
        val request = Repository(service)
        presenter = NextPresenter(this, request)
        presenter.getDataMatch()
    }
}
