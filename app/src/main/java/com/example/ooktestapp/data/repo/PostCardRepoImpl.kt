package com.example.ooktestapp.data.repo

import com.example.ooktestapp.data.mappers.PostCardResponseToModelMapper
import com.example.ooktestapp.data.network.service.PostCardService
import com.example.ooktestapp.domain.entity.PostCardModel
import com.example.ooktestapp.domain.repo.PostCardRepository

/**
 * @author Knurenko Bogdan 13.02.2024
 */
class PostCardRepoImpl(
    private val service: PostCardService,
    private val mapper: PostCardResponseToModelMapper
) : PostCardRepository {

    override suspend fun fetchPostCards(page: Int): List<PostCardModel> {
        val response = service.fetchPostCards(page)
        val pics = response.data.list
        return pics.map { mapper.map(it) }
    }
}