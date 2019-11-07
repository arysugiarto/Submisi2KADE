package com.arysugiarto.Submisi2.footballmatchschedule.entity

import com.google.gson.annotations.SerializedName

data class Match ( @SerializedName("events") var events: kotlin.collections.List<List<Any?>>)
