package com.projectpro.foodorder.repo

import androidx.lifecycle.LiveData
import com.projectpro.foodorder.data.remote.model.HealthCheck

interface DataSource {

    fun healthCheck(): LiveData<HealthCheck>
}