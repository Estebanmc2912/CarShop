package com.example.carshop.model

import com.example.carshop.utils.Category_utils

data class Car_Model(
    val image: String ="DEFAULT URL",
    val mark: String ="DEFAULT MARK",
    val _model: String = "DEFAULT MODEL",
    val category: String = Category_utils.getCategory_type(1),
    val used: Boolean = false,
    val time_years: Int = 0,
    val description: String ="DEFAULT DESCRIPTION",
    val location: String ="DEFAULT LOCATION",
    val add: String =""){

}





/*var category_utils: Category_utils



/// variable's getters & setters
var mark // car's mark
    : String
var model // number or name's  model
    : String
var category // kind of vehicle
    : String
private set
var isUsed // boolean variable to know if is used
    : Boolean
var time_years // if is used, then we need time of has been used
    : Int
var description // optional car's description
    : String
var location // optional car's location
    : String
var add // from vehicle category, the variable going to save some characteristics
    : String

fun setCategory(category: Int) {
this.category = category_utils.getCategory_type(category)
}

init {
category_utils = Category_utils()
this.mark = mark
model = _model
this.category = category_utils.getCategory_type(category)
isUsed = used
this.time_years = time_years
this.description = description
this.location = location
this.add = add
}
}*/