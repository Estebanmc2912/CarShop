package com.example.carshop.utils

import java.util.*

object Category_utils {

    var category_types = Arrays.asList("DEFAULT","Electric", "Truck", "Commercial")

    fun getCategory_type(number: Long): String {
        val num =  number.toString()
        val num2 = num.toInt()
        return category_types[num2]
    }

    fun addCategory_type(type: String) {
        category_types.add(type)
    }
}