package com.example.ooktestapp.presentation.ui.compose.screens.main

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import org.koin.androidx.compose.koinViewModel

/**
 * @author Knurenko Bogdan 13.02.2024
 */

@Composable
fun MainScreenController() {
    val viewModel: MainScreenViewModel = koinViewModel()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.errors.collect { errorMessage ->
            errorMessage?.let {
                Toast.makeText(context, "Oups! there is an error! $it", Toast.LENGTH_SHORT).show()
            }
        }
    }

    MainScreenView(
        isLoading = viewModel.isLoading,
        itemsToShow = viewModel.pictures,
        onLoadNewPage = { viewModel.fetchImages() }
    )
}