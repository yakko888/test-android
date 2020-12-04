package com.testspds.model


import com.google.gson.annotations.SerializedName

data class TestData(
    @SerializedName("date_range")
    var dateRange: DateRange,
    @SerializedName("number")
    var number: Int,
    @SerializedName("posts")
    var posts: List<Post>
)