package com.example.saryandroidchallenge.utils

class Constants {

    object API {
        const val baseURL = "https://staging.sary.to/api/"
        private const val BasketKey = "/baskets/325514/"
        private const val version = "v2.5.1"
        const val bannerURL = version.plus(BasketKey.plus("banners"))
    }

    object Header {
        const val appVersion = "5.5.0.0.0"
        const val deviceType = "android"
        const val platform = "FLAGSHIP"
        const val language = "en"
        const val token =
            "token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjgxNTEyLCJ1c2VyX3Bob25lIjoiOTY2NTkxMTIyMzM0In0.phRQP0e5yQrCVfZiN4YlkI8NhXRyqa1fGRx5rvrEv0o"
    }
}