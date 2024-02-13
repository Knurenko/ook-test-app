package com.example.ooktestapp.di

import com.example.ooktestapp.data.mappers.PostCardResponseToModelMapper
import com.example.ooktestapp.data.network.di.RetrofitFactory
import com.example.ooktestapp.data.network.service.PostCardService
import com.example.ooktestapp.data.repo.PostCardRepoImpl
import com.example.ooktestapp.domain.repo.PostCardRepository
import com.example.ooktestapp.presentation.ui.compose.screens.main.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Knurenko Bogdan 13.02.2024
 */

val appModule = module {
    // service
    single<PostCardService> {
        RetrofitFactory().createService()
    }

    // mapper
    single { PostCardResponseToModelMapper() }

    // repo
    single<PostCardRepository> {
        PostCardRepoImpl(
            service = get(),
            mapper = get()
        )
    }

    // view model
    viewModel { MainScreenViewModel(repository = get()) }
}