package com.horizon.powerup.ui.main

import androidx.lifecycle.*

class MainViewModel : ViewModel() {

}

class MainViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }
}