package com.projectpro.foodorder.data.remote

import android.os.Handler
import android.os.Looper
import com.projectpro.foodorder.data.remote.model.HealthCheck
import com.projectpro.foodorder.network.RetrofitConfig
import com.projectpro.foodorder.utils.Constants.Companion.SERVICE_LATENCY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class RemoteRepo {

    private val apiEndpoint = RetrofitConfig.getClient()


    fun getHealthCheck(getHealthCheck: GetHealthCheck) {
        val responseHandler = Handler(Looper.getMainLooper())
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

    interface GetHealthCheck {
        fun onResponse(dbCheck: HealthCheck)
        fun onResponseError()
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