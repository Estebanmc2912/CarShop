package com.example.carshop.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carshop.R
import com.example.carshop.viewmodel.MainAdapter
import com.example.carshop.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() , Serializable{

    private lateinit var adapter: MainAdapter
    private val viewModel by lazy{ ViewModelProviders.of(this).get(MainViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this, savedInstanceState)
        rv_menu.layoutManager = LinearLayoutManager(this)
        rv_menu.adapter= adapter
        observeData()

        /// Data to try the application without a databse

        /*val dummyList:MutableList<Car_Model> = mutableListOf<Car_Model>()


        dummyList.add(Car_Model("https://i.blogs.es/e34a9e/lamborghini-huracan-evo-rwd-2020-010/840_560.jpg",
            "Lamborghini","Hurac 2021", 2,false,2,
            "Carrito ahí humildemente", "funcionalidad"))

        dummyList.add(Car_Model("https://cnet4.cbsistatic.com/img/UJ3mxFRgZCL_5PyM5iJSM-p0WWc=/2019/07/17/e6640571-f94c-47d6-b026-a69dec844b29/toyota-corolla-2020.jpg",
            "Toyota","Silver 2019", 3,true,1,
            "Carrito ahí humildemente", "funcionalidad"))


        dummyList.add(Car_Model("https://f1a9164f-a-62cb3a1a-s-sites.googlegroups.com/site/ventadeautosjaponeses2020/home/venta-de-camiones/VA_ba5eacef6cc84c5296dd0bb3de2ea1f9.jpg?attachauth=ANoY7cqsHcLrKGQ20Fk2Y7gSWPjGrn7c-11pfAhK82J_isAN-MiSsx3eJz-Fbm7k868LEBoKopyAJhDxZaLD_VAzh6WPgwQyLrzU22L_Tw1mz0I4xn2sKPHNRWAWZ6b0Ro4UFuQqXxXYzhB2FcpBRYNU2QO1ye7SYYuP_ico4afXgMxOuYq1yADL5g5uAHI_Shfq3Mb5tgEfvXXBPNJESDJ26Doztu7FXnrCSWL7dE8KNotQgfcrI-IRw0-uWKF-L7i3ep_Bsc84p7lA12nqMChvhsjgSTBkucqlZ0TXMO1obPWJBc8gHnA%3D&attredirects=1",
            "Toyota","Snake 2021", 2,false,2,
            "Carrito ahí humildemente", "funcionalidad"))


        dummyList.add(Car_Model("https://http2.mlstatic.com/D_NQ_NP_830733-MCO43270818796_082020-W.jpg",
            "Renault","KWID 2018", 3,true,2,
            "Carrito ahí humildemente", "funcionalidad"))


        dummyList.add(Car_Model("https://sites.google.com/site/ventadeautosjaponeses2020/_/rsrc/1542060317754/home/original_img4f956d4d3143a.jpg",
            "Toyota","Prado 2011", 1,true,8,
            "Carrito ahí humildemente", "funcionalidad"))


        dummyList.add(Car_Model("https://static.iris.net.co/soho/upload/images/2020/2/10/61074_1.jpg",
            "Lamborghini","Fire 2021", 3,false,2,
            "Carrito ahí humildemente", "funcionalidad"))

        adapter.setListData(dummyList)
        adapter.notifyDataSetChanged()
        */
    }

    fun observeData(){
        sv_container.showShimmer(true)
        sv_container.startShimmer()
        viewModel.fetchUserData().observe(this, Observer {
            sv_container.stopShimmer()
            sv_container.visibility = View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

}