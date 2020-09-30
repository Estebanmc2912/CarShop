package com.example.carshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carshop.domain.network.Repo
import com.example.carshop.model.Car_Model
import java.io.Serializable


class MainViewModel : ViewModel(), Serializable {

    private val repo = Repo()
    fun fetchUserData():LiveData<MutableList<Car_Model>>{
        val mutableData = MutableLiveData<MutableList<Car_Model>>()
        repo.getCar_ModelData().observeForever{
            mutableData.value = it
        }
        return mutableData
    }
}