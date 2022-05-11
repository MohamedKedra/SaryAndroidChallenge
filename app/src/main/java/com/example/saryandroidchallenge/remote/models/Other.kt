package com.example.saryandroidchallenge.remote.models

data class Other(
    val business_status: BusinessStatus?,
    val show_special_order_view: Boolean?,
    val uncompleted_profile_settings: UncompletedProfileSettings?
)

data class UncompletedProfileSettings(
    val image: String?,
    val is_completed_profile: Boolean?,
    val message: String?,
    val show_tag: Boolean?
)