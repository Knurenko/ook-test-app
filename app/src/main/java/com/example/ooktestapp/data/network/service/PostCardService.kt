package com.example.ooktestapp.data.network.service

import com.example.ooktestapp.data.entity.FetchPostCardsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * @author Knurenko Bogdan 13.02.2024
 */

interface PostCardService {
    @Headers("Token: ookgroup")
    @GET("postcards/page/home")
    suspend fun fetchPostCards(
        @Query("page") page: Int,
        @Query("limit") maxItemsPerPage: Int = 30
    ): FetchPostCardsResponse
}