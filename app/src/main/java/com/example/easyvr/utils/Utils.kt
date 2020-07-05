package com.example.easyvr.utils

import com.example.easyvr.R
import com.example.easyvr.model.Filter

fun getFilterList(): ArrayList<Filter>{
    return arrayListOf(Filter("Normal", R.drawable.image1),
        Filter("Sunshine", R.drawable.image2),
        Filter("Daylight", R.drawable.image3),
        Filter("Color", R.drawable.image2),
        Filter("Brief", R.drawable.image3),
        Filter("Dayform", R.drawable.image1),
        Filter("Nigeria", R.drawable.image2))
}