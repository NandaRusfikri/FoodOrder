package com.projectpro.foodorder.data.remote.model

import java.io.Serializable

class Menus : ArrayList<MenusItem>()

data class MenusItem(
    val category_name: String?,
    val created_at: String?,
    val description: String?,
    val eligible_additional_menu: List<EligibleAdditionalMenu?>,
    val id: Int?,
    val name: String?,
    val price: Int?,
    val updated_at: String?
) : Serializable
