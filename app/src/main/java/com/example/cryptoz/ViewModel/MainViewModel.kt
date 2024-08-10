package com.example.cryptoz.ViewModel

import androidx.lifecycle.ViewModel
import com.example.cryptoz.Repository.MainRepository

class MainViewModel
    (val repository:MainRepository): ViewModel(){
        constructor():this(MainRepository())

    fun loadData() = repository.items

    }
