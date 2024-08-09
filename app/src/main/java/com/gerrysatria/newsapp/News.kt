package com.gerrysatria.newsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class News(
    val title : String,
    val publishDate : String,
    val description : String,
    val image : Int,
    val source : String
) : Parcelable
