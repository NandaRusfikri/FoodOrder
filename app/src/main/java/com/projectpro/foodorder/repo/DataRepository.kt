package com.projectpro.foodorder.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.projectpro.foodorder.data.remote.RemoteRepo
import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.data.remote.model.Menus
import com.projectpro.foodorder.data.remote.model.MenusItem

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

    override fun getMenus(): LiveData<List<MenusItem>> {
        val menuMutable = MutableLiveData<List<MenusItem>>()
        remoteRepo.getMenusItem(object : RemoteRepo.GetMenus {
            override fun onResponse(menuItem: List<MenusItem>) {
                menuMutable.postValue(menuItem)
            }


            override fun onResponseError(message: String) {
                print("error get menus")
            }

        })
        return menuMutable
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