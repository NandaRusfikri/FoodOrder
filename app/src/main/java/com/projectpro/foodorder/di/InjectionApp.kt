package com.projectpro.foodorder.di

import com.projectpro.foodorder.repo.DataRepository
import com.projectpro.foodorder.data.remote.RemoteRepo

object InjectionApp {
    fun appInject() : DataRepository? {
        val remoteRepo = RemoteRepo.getInstance()
        return DataRepository.getInstance(remoteRepo)
    }
}