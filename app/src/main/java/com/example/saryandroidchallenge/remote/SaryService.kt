package com.example.saryandroidchallenge.remote

import com.example.saryandroidchallenge.remote.models.BannerResponse
import com.example.saryandroidchallenge.remote.models.CategoryResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface SaryService {

    @GET("v2.5.1/baskets/325514/banners")
    fun getBanners(
        @Header("Device-Type") deviceType: String,
        @Header("App-Version") appVersion: String,
        @Header("Accept-Language") language: String,
        @Header("Platform") platform: String,
        @Header("Authorization") token: String,
    ): Single<BannerResponse>

    @GET("baskets/325514/catalog")
    fun getCategories(
        @Header("Device-Type") deviceType: String,
        @Header("App-Version") appVersion: String,
        @Header("Accept-Language") language: String,
        @Header("Platform") platform: String,
        @Header("Authorization") token: String,
    ): Single<CategoryResponse>
}