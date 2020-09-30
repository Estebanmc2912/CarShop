package com.example.carshop.domain.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.carshop.model.Car_Model
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable

class Repo : Serializable{
    /*fun getCar_ModelData():LiveData<MutableList<Car_Model>>{
        val mutableData = MutableLiveData<MutableList<Car_Model>>()
    }*/

    fun getCar_ModelData():LiveData<MutableList<Car_Model>>{
        val mutableData = MutableLiveData<MutableList<Car_Model>>()

        FirebaseFirestore.getInstance().collection("publicaciones").get().addOnSuccessListener {
            val listData = mutableListOf<Car_Model>()
            for (document in it){
                val image = document.getString("image")
                val mark = document.getString("mark")
                val _model = document.getString("_model")
                val category = document.getLong("category")
                val used = document.getBoolean ("used")
                val time_years = document.getLong("time_years")
                val description = document.getString("description")
                val location = document.getGeoPoint("location")
                val add = document.getString("add")
                val publicacion = Car_Model(image!!,mark!!,_model!!,category!!,used!!,time_years!!,description!!,location!!,add!!)
                listData.add(publicacion)
            }

            mutableData.value = listData
        }

        return mutableData
    }
}