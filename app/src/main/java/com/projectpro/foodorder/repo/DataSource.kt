package com.projectpro.foodorder.repo

import androidx.lifecycle.LiveData
import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.data.remote.model.MenusItem

interface DataSource {

    fun healthCheck(): LiveData<HealthCheck>

    fun getMenus(): LiveData<List<MenusItem>>
}