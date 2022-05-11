package com.example.saryandroidchallenge.remote.models

data class CategoryResponse(
    val message: String?,
    val other: Other?,
    val result: List<Category>?,
    val status: Boolean?
)

data class BusinessStatus(
    val id: Int?,
    val title: String?
)

data class Category(
    val `data`: List<Data>?,
    val data_type: String?,
    val id: Int?,
    val row_count: Int?,
    val show_title: Boolean?,
    val title: String?,
    val ui_type: String?
)

data class Data(
    val deep_link: String?,
    val empty_content_image: String?,
    val empty_content_message: String?,
    val filters: List<Filter>?,
    val group_id: Int?,
    val has_data: Boolean?,
    val image: String?,
    val name: String?,
    val show_in_brochure_link: Boolean?,
    val show_unavailable_items: Boolean?
)

data class Filter(
    val filter_id: Int?,
    val name: String?
)