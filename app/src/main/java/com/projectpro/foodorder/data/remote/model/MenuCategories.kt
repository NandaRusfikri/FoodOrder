package com.projectpro.foodorder.data.remote.model

class MenuCategories : ArrayList<MenuCategoriesItem>()

data class MenuCategoriesItem(
    val created_at: String,
    val id: Int,
    val name: String,
    val updated_at: String
)