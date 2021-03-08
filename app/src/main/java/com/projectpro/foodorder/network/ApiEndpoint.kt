package com.projectpro.foodorder.network

import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.data.remote.model.MenuCategories
import com.projectpro.foodorder.data.remote.model.Menus
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("health")
    fun checkHealth () : Call<HealthCheck>

    @GET("menu-categories")
    fun getMenusCategories() : Call<MenuCategories>

    @GET("menus")
    fun getMenus() : Call<Menus>
}