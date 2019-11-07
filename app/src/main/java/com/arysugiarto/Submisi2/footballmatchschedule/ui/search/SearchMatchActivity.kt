package com.rahmat.app.footballclub.feature.searchmatches

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import com.arysugiarto.Submisi2.footballmatchschedule.R
import com.arysugiarto.Submisi2.footballmatchschedule.adapter.MatchAdapater
import com.arysugiarto.Submisi2.footballmatchschedule.api.ApiService
import com.arysugiarto.Submisi2.footballmatchschedule.api.RestApi
import com.arysugiarto.Submisi2.footballmatchschedule.entity.repository.Repository
import com.arysugiarto.Submisi2.footballmatchschedule.extensions.hide
import com.arysugiarto.Submisi2.footballmatchschedule.extensions.show
import com.arysugiarto.Submisi2.footballmatchschedule.ui.search.SearchMatchContract
import kotlinx.android.synthetic.main.activity_search_match.*


class SearchMatchActivity : AppCompatActivity(), SearchMatchContract.View {


    private var matchLists : MutableList<com.arysugiarto.Submisi2.footballmatchschedule.entity.List<Any?>> = mutableListOf()
    lateinit var mPresenter: SearchMatchContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_match)

        val query = intent.getStringExtra("query")
        Log.v("test", query)
        val service = ApiService.getClient().create(RestApi::class.java)
        val request = Repository(service)
        mPresenter = SearchMatchPresenter(this, request)
        mPresenter.searchMatch(query)

    }

    override fun showLoading() {
        mainProgressBar.show()
        rvFootball.hide()
    }

    override fun hideLoading() {
        mainProgressBar.hide()
        rvFootball.show()
    }

    override fun displayMatch(matchList: List<com.arysugiarto.Submisi2.footballmatchschedule.entity.List<Any?>>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = MatchAdapater(matchList, applicationContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchView = menu?.findItem(R.id.actionSearch)?.actionView as SearchView?
        searchView?.queryHint = "Search Matches"

        searchView?.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mPresenter.searchMatch(newText)
                return false
            }
        })

        return true
    }



}
