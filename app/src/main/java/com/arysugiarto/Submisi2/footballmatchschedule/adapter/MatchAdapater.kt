package com.arysugiarto.Submisi2.footballmatchschedule.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arysugiarto.Submisi2.footballmatchschedule.R
import com.arysugiarto.Submisi2.footballmatchschedule.entity.List
import com.arysugiarto.Submisi2.footballmatchschedule.ui.detail.DetailMatchActivity
import kotlinx.android.synthetic.main.item_last.view.*
import org.jetbrains.anko.startActivity

class MatchAdapater (val listItem: kotlin.collections.List<List<Any?>>, val context: Context?):
    RecyclerView.Adapter<MatchAdapater.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_last, parent, false))
    }

    override fun getItemCount(): Int = listItem.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: List<Any?>){
            itemView.date.text = event.dateEvent
            itemView.tvNameHome.text = event.strHomeTeam
            itemView.tvHomeScore.text = event.intHomeScore
            itemView.tvNameAway.text = event.strAwayTeam
            itemView.tvAwayScore.text = event.intAwayScore

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailMatchActivity>("match" to event)
            }
        }
    }

}