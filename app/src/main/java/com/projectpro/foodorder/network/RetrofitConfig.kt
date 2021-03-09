package com.projectpro.foodorder.network

import com.projectpro.foodorder.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    fun getClient() : ApiEndpoint {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
//            .addNetworkInterceptor { chain ->
//                val auth = ACCESS_TOKEN
//                val request = chain.request()
//                    .newBuilder()
//                    .addHeader("Authorization", auth)
//                    .build()
//                chain.proceed(request)
//            }
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        return retrofit.create(ApiEndpoint::class.java)
    }

    /*
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        }
        val hitApi: ApiEndpoint by lazy {
            retrofit.create(ApiEndpoint::class.java)
        }

    }
     */
}