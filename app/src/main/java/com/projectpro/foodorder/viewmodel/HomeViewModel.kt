package com.projectpro.foodorder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.data.remote.model.Menus
import com.projectpro.foodorder.data.remote.model.MenusItem
import com.projectpro.foodorder.repo.DataRepository

class HomeViewModel(
    dataRepository: DataRepository
) : ViewModel() {

    val checkHealthCheck : LiveData<HealthCheck> = dataRepository.healthCheck()

    val menusList: LiveData<List<MenusItem>> = dataRepository.getMenus()
}