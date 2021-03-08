package com.projectpro.foodorder.data.remote.model

data class EligibleAdditionalMenu(
    val additional_name: String,
    val additional_price: Int,
    val created_at: String,
    val id: Int,
    val menu_id: Int,
    val updated_at: String
)