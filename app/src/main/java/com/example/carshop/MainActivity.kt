package com.example.carshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carshop.model.Car_Model
import com.example.carshop.utils.Category_utils
import com.example.carshop.viewmodel.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this)

        rv_menu.layoutManager = LinearLayoutManager(this)
        rv_menu.adapter= adapter

        val dummyList:MutableList<Car_Model> = mutableListOf<Car_Model>()

        dummyList.add(Car_Model("https://i.blogs.es/e34a9e/lamborghini-huracan-evo-rwd-2020-010/840_560.jpg",
            "Lamborghini","Huracán 2021", Category_utils.getCategory_type(2),true,2,
            "Carrito ahí humildemente", "funcionalidad"))

        dummyList.add(Car_Model("https://cnet4.cbsistatic.com/img/UJ3mxFRgZCL_5PyM5iJSM-p0WWc=/2019/07/17/e6640571-f94c-47d6-b026-a69dec844b29/toyota-corolla-2020.jpg",
            "Lamborghini","2021", Category_utils.getCategory_type(3),true,2,
            "Carrito ahí humildemente", "funcionalidad"))

        dummyList.add(Car_Model("https://is1-ssl.mzstatic.com/image/thumb/Purple117/v4/07/f5/9a/07f59a05-4206-9244-2554-c63a0bc8dfac/source/256x256bb.jpg",
            "Lamborghini","2021", Category_utils.getCategory_type(2),true,2,
            "Carrito ahí humildemente", "funcionalidad"))

        dummyList.add(Car_Model("https://sites.google.com/site/ventadeautosjaponeses2020/_/rsrc/1542060317754/home/original_img4f956d4d3143a.jpg",
            "Lamborghini","2021", Category_utils.getCategory_type(1),true,2,
            "Carrito ahí humildemente", "funcionalidad"))

        dummyList.add(Car_Model("https://static.iris.net.co/soho/upload/images/2020/2/10/61074_1.jpg",
            "Lamborghini","2021", Category_utils.getCategory_type(3),true,2,
            "Carrito ahí humildemente", "funcionalidad"))

        dummyList.add(Car_Model("https://static.iris.net.co/soho/upload/images/2020/2/10/61074_1.jpg",
            "Lamborghini","2021", Category_utils.getCategory_type(3),true,2,
            "Carrito ahí humildemente", "funcionalidad"))

        dummyList.add(Car_Model("https://static.iris.net.co/soho/upload/images/2020/2/10/61074_1.jpg",
            "Lamborghini","2021", Category_utils.getCategory_type(2),true,2,
            "Carrito ahí humildemente", "funcionalidad"))


        adapter.setListData(dummyList)
        adapter.notifyDataSetChanged()

    }
}