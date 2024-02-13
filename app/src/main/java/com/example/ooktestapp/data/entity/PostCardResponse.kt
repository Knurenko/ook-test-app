package com.example.ooktestapp.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Knurenko Bogdan 13.02.2024
 */
data class PostCardResponse(
    @SerializedName("image")
    val image: String
)