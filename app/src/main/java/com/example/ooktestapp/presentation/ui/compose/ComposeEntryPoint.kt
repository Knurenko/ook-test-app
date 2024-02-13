package com.example.ooktestapp.presentation.ui.compose

import androidx.compose.runtime.Composable
import com.example.ooktestapp.presentation.ui.compose.screens.main.MainScreenController
import com.example.ooktestapp.presentation.ui.theme.AppTheme

/**
 * @author Knurenko Bogdan 13.02.2024
 */

@Composable
fun ComposeEntryPoint() = AppTheme {
    MainScreenController()
}