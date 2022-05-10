package com.example.saryandroidchallenge.remote

import com.example.saryandroidchallenge.remote.models.BannerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface SaryService {

    @Headers(
        "Device-Type: android" +
                "App-Version: 5.5.0.0.0" +
                "Accept-Language: ar" +
                "Platform: FLAGSHIP" +
                "Authorization: token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjgxNTEyLCJ1c2VyX3Bob25lIjoiOTY2NTkxMTIyMzM0In0.phRQP0e5yQrCVfZiN4YlkI8NhXRyqa1fGRx5rvrEv0o"
    )
    @GET("v2.5.1//baskets/325514/banners")
    fun getBanners(): Single<BannerResponse>

}