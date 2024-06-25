package com.example.imran_mamirov_hw_5_2

import com.google.gson.annotations.SerializedName

data class LoveResult(
    @SerializedName("fname")
    val fname: String,
    @SerializedName("sname")
    val sname: String,
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("result")
    val result: String,
)