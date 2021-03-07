package com.projectpro.foodorder.network

import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.data.remote.model.MenuCategories
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("health")
    fun checkHealth () : Call<HealthCheck>

    @GET("menu-categories")
    fun getMenus() : Call<MenuCategories>
}