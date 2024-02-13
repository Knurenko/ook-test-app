package com.example.ooktestapp.data.entity

import com.google.gson.annotations.SerializedName


/**
 * @author Knurenko Bogdan 13.02.2024
 */
data class FetchPostCardsResponse(
    @SerializedName("data")
    val data: PostCardsResponse
)

data class PostCardsResponse(
    @SerializedName("postcards")
    val list: List<PostCardResponse>
)