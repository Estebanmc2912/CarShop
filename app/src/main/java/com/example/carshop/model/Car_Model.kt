package com.example.carshop.model

import android.os.Parcelable
import com.example.carshop.utils.Category_utils
import com.google.firebase.firestore.GeoPoint
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable


data class Car_Model (
    val image: String ="DEFAULT URL",
    val mark: String ="DEFAULT MARK",
    val _model: String = "DEFAULT MODEL",
    //val category: Integer = Category_utils.getCategory_type(1),
    val category: Long = 0,
    val used: Boolean = false,
    val time_years: Long = 0,
    val description: String ="DEFAULT DESCRIPTION",
    val location:  GeoPoint = GeoPoint(4.60971, -74.08175),
    val add: String ="") : Serializable

