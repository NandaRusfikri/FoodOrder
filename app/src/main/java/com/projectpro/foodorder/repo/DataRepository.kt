package com.projectpro.foodorder.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectpro.foodorder.data.remote.RemoteRepo
import com.projectpro.foodorder.data.remote.model.HealthCheck

open class DataRepository(private val remoteRepo: RemoteRepo) : DataSource {

    override fun healthCheck(): LiveData<HealthCheck> {
        val checkMutable = MutableLiveData<HealthCheck>()
        remoteRepo.getHealthCheck(object : RemoteRepo.GetHealthCheck {
            override fun onResponse(dbCheck: HealthCheck) {
                checkMutable.postValue(dbCheck)
            }

            override fun onResponseError() {
                print("error to check connection db")
            }

        })
        return checkMutable
    }

    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(remoteRepo: RemoteRepo) : DataRepository? {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = DataRepository(remoteRepo)
                    }
                }
            }
            return instance
        }
    }
}