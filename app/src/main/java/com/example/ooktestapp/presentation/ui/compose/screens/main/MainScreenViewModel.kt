package com.example.ooktestapp.presentation.ui.compose.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ooktestapp.domain.entity.PostCardModel
import com.example.ooktestapp.domain.repo.PostCardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @author Knurenko Bogdan 13.02.2024
 */
class MainScreenViewModel(
    private val repository: PostCardRepository
) : ViewModel() {

    // to catch errors
    private val _errorsFlow: MutableStateFlow<String?> = MutableStateFlow(null)
    val errors: StateFlow<String?> = _errorsFlow.asStateFlow()

    // to store already loaded images
    var pictures = mutableStateListOf<PostCardModel>()
        private set

    // to show loading indicator
    var isLoading: Boolean by mutableStateOf(false)
        private set

    private var page = 1

    fun fetchImages() {
        if (!isLoading) viewModelScope.launch {
            isLoading = true
            try {
                pictures += repository.fetchPostCards(page)
                page++
            } catch (e: Exception) {
                _errorsFlow.emit(e.localizedMessage)
            } finally {
                isLoading = false
            }
        }
    }
}