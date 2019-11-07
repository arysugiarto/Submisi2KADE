package com.arysugiarto.Submisi2.footballmatchschedule.entity

import com.google.gson.annotations.SerializedName
import com.arysugiarto.Submisi2.footballmatchschedule.entity.List

data class SearchedMatches (
    @SerializedName("event") var events: kotlin.collections.List<List<Any?>>
    )