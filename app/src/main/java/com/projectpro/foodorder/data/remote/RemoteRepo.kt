package com.projectpro.foodorder.data.remote

import android.os.Handler
import android.os.Looper
import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.data.remote.model.Menus
import com.projectpro.foodorder.data.remote.model.MenusItem
import com.projectpro.foodorder.network.RetrofitConfig
import com.projectpro.foodorder.utils.Constants.Companion.SERVICE_LATENCY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class RemoteRepo {

    private val apiEndpoint = RetrofitConfig.getClient()
    private val responseHandler = Handler(Looper.getMainLooper())


    fun getHealthCheck(getHealthCheck: GetHealthCheck) {
        responseHandler.postDelayed({
            apiEndpoint.checkHealth().enqueue(object : Callback<HealthCheck> {
                override fun onResponse(call: Call<HealthCheck>, response: Response<HealthCheck>) {
                    if (response.code() == 200) {
                        response.body()?.let { getHealthCheck.onResponse(it) }
                    } else {
                        print("error connection")
                    }
                }

                override fun onFailure(call: Call<HealthCheck>, t: Throwable) {
                    getHealthCheck.onResponseError()
                    print("onFailure ${t.message}")
                }

            })
        }, SERVICE_LATENCY)
    }

    fun getMenusItem(getMenus: GetMenus) {
        responseHandler.postDelayed({
            apiEndpoint.getMenus().enqueue(object : Callback<Menus> {
                override fun onResponse(call: Call<Menus>, response: Response<Menus>) {
                    if (response.code() == 200) {
                        response.body()?.let { getMenus.onResponse(it) }
                    }
                }

                override fun onFailure(call: Call<Menus>, t: Throwable) {
                    getMenus.onResponseError(t.message.toString())
                    print("onFailure ${t.message}")
                }

            })
        }, SERVICE_LATENCY)
    }

    interface GetHealthCheck {
        fun onResponse(dbCheck: HealthCheck)
        fun onResponseError()
    }

    interface GetMenus {
        fun onResponse(menuItem: List<MenusItem>)
        fun onResponseError(message: String)
    }

    companion object {
        private var INSTANCE: RemoteRepo? = null

        fun getInstance(): RemoteRepo {
            if (INSTANCE == null) {
                INSTANCE = RemoteRepo()
            }
            return INSTANCE!!
        }
    }
}