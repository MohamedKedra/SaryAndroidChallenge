package com.example.saryandroidchallenge.remote.models

data class BannerResponse(
    val result: List<Result>?,
    val status: Boolean?
)

data class Metadata(
    val consumable_display: Any?,
    val sub_title: Any?,
    val title: String?
)

data class Result(
    val branches: List<Any>?,
    val button_text: String?,
    val cities: List<Int>?,
    val created_at: String?,
    val description: String?,
    val expiry_date: String?,
    val expiry_status: Boolean?,
    val id: Int?,
    val image: String?,
    val is_available: Boolean?,
    val level: String?,
    val link: String?,
    val metadata: Metadata?,
    val photo: String?,
    val priority: Int?,
    val promo_code: String?,
    val start_date: String?,
    val title: String?
)