package com.example.saryandroidchallenge.utils

class Constants {

    object API {
        const val baseURL = "https://staging.sary.to/api/"
        private const val BasketKey = "/baskets/325514/"
        private const val version = "v2.5.1"
        const val bannerURL = version.plus(BasketKey.plus("banners"))
    }
}