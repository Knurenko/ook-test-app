package com.example.ooktestapp.data.network.di

import com.example.ooktestapp.data.network.service.PostCardService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Knurenko Bogdan 13.02.2024
 */
class RetrofitFactory {
    private val instance by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.otkritkiok.ru/v0/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createService(): PostCardService = instance.create(PostCardService::class.java)
}