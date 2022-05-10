package com.example.saryandroidchallenge.ui.main.repository

import com.example.saryandroidchallenge.remote.SaryService
import com.example.saryandroidchallenge.utils.Constants

class MainRepository(private val saryService: SaryService) {

    fun getBanners() =
        saryService.getBanners(
            Constants.Header.deviceType,
            Constants.Header.appVersion,
            Constants.Header.language,
            Constants.Header.platform,
            Constants.Header.token
        )
}