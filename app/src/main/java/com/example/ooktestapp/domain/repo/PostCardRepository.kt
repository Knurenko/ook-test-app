package com.example.ooktestapp.domain.repo

import com.example.ooktestapp.domain.entity.PostCardModel

/**
 * @author Knurenko Bogdan 13.02.2024
 */
interface PostCardRepository {
    suspend fun fetchPostCards(page: Int): List<PostCardModel>
}