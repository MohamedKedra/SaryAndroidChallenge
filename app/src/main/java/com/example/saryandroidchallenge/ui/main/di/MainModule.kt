package com.example.saryandroidchallenge.ui.main.di

import com.example.saryandroidchallenge.ui.main.repository.MainRepository
import com.example.saryandroidchallenge.ui.main.view_model.MainViewModel
import org.koin.dsl.module

val mainModule = module {

    single {
        MainRepository(get())
    }

    single {
        MainViewModel(get(), get())
    }
}