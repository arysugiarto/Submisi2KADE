package com.arysugiarto.Submisi2.footballmatchschedule.ui.main


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arysugiarto.Submisi2.footballmatchschedule.R
import com.arysugiarto.Submisi2.footballmatchschedule.ui.fragment.LastFragment
import com.arysugiarto.Submisi2.footballmatchschedule.ui.fragment.NextFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_nav_view.*


class MainActivity : AppCompatActivity(), MainContract.View{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.lastMatch -> {
                    loadLastMatch(savedInstanceState)
                }
                R.id.nextMatch -> {
                    loadUpcomingMatch(savedInstanceState)
                }
            }
            true
        }

        bottom_navigation.selectedItemId = R.id.lastMatch
    }

    private fun loadLastMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, LastFragment(), LastFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadUpcomingMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NextFragment(), NextFragment::class.java.simpleName)
                .commit()
        }


        fun hideLoading() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun showLoading() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}

