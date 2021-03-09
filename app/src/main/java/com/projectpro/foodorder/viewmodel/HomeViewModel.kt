package com.projectpro.foodorder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.repo.DataRepository

class HomeViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    val checkHealthCheck : LiveData<HealthCheck> = dataRepository.healthCheck()
}