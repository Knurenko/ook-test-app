package com.example.ooktestapp.presentation.ui.compose.screens.main

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ooktestapp.domain.entity.PostCardModel
import com.example.ooktestapp.presentation.ui.compose.elements.AppBar
import com.example.ooktestapp.presentation.ui.compose.elements.PostCard
import com.example.ooktestapp.presentation.ui.theme.AppTheme

/**
 * @author Knurenko Bogdan 13.02.2024
 */

@Composable
fun MainScreenView(
    isLoading: Boolean,
    itemsToShow: List<PostCardModel>,
    onLoadNewPage: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AppBar() },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(color = AppTheme.colors.background),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                    items(itemsToShow) {postCard ->
                        PostCard(
                            modifier = Modifier.padding(2.dp),
                            itemToShow = postCard
                        )
                    }

                    item {
                        SideEffect { onLoadNewPage() }
                    }
                })
                if (isLoading) {
                    LoadingIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        }
    )
}

@Composable
private fun LoadingIndicator(modifier: Modifier) =
    CircularProgressIndicator(
        modifier = modifier.size(32.dp),
        color = AppTheme.colors.accent,
        trackColor = AppTheme.colors.background,
        strokeWidth = 4.dp
    )

@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    MainScreenView(
        isLoading = true,
        itemsToShow = emptyList(),
        onLoadNewPage = {}
    )
}