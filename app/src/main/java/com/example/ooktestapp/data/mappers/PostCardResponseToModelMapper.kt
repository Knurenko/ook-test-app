package com.example.ooktestapp.data.mappers

import com.example.ooktestapp.data.entity.PostCardResponse
import com.example.ooktestapp.domain.entity.PostCardModel

/**
 * @author Knurenko Bogdan 13.02.2024
 */
class PostCardResponseToModelMapper {
    // I'm not sure it should be there, but anyway
    private companion object {
        const val IMAGE_PATH_PREFIX = "https://cdn.otkritkiok.ru/posts/thumbs/"
    }

    fun map(response: PostCardResponse): PostCardModel = PostCardModel(
        imagePath = IMAGE_PATH_PREFIX + response.image.replace(oldValue = ".gif", newValue = ".jpg", ignoreCase = true)
    )
}