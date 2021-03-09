package com.projectpro.foodorder.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.projectpro.foodorder.repo.DataRepository
import com.projectpro.foodorder.di.InjectionApp
import com.projectpro.foodorder.viewmodel.HomeViewModel

class ViewModelFactory(
    private val dataRepository: DataRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(dataRepository) as T
            }
            else -> throw Throwable("Unknow viewModel class" + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory? {
            if (instance == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (instance == null) {
                        instance = InjectionApp.appInject()?.let { ViewModelFactory(it) }
                    }
                }
            }
            return instance
        }
    }
}