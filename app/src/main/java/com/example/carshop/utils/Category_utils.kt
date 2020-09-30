package com.example.carshop.utils

import java.util.*

object Category_utils {
    var category_types = Arrays.asList("DEFAULT","Electric", "Truck", "Commercial")

    fun getCategory_type(number: Int): String {
        return category_types[number]
    }

    fun addCategory_type(type: String) {
        category_types.add(type)
    }
}