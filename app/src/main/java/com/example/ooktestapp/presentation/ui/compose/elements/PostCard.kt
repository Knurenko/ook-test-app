package com.example.ooktestapp.presentation.ui.compose.elements

import android.content.res.Configuration
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.ooktestapp.domain.entity.PostCardModel
import com.example.ooktestapp.presentation.ui.theme.AppTheme

/**
 * @author Knurenko Bogdan 13.02.2024
 */

@Composable
fun PostCard(modifier: Modifier = Modifier, itemToShow: PostCardModel) {
    SubcomposeAsyncImage(
        modifier = modifier.aspectRatio(1f),
        model = itemToShow.imagePath,
        loading = {
            LoadingIndicator(modifier = Modifier
                .align(Alignment.Center)
                .padding(64.dp))
        },
        contentDescription = "Post card image"
    )
}

@Composable
private fun LoadingIndicator(modifier: Modifier) = CircularProgressIndicator(
    modifier = modifier.size(24.dp),
    color = AppTheme.colors.accent,
    trackColor = AppTheme.colors.background,
    strokeWidth = 8.dp
)

@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    PostCard(
        itemToShow = PostCardModel(
            imagePath = "https://cdn.otkritkiok.ru/posts/thumbs/koroleve-a-znachit-tebe-moya-podruga-51760-5900418.jpg"
        )
    )
}