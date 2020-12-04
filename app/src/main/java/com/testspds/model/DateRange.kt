package com.testspds.model


import com.google.gson.annotations.SerializedName

data class DateRange(
    @SerializedName("newest")
    var newest: String,
    @SerializedName("oldest")
    var oldest: String
)