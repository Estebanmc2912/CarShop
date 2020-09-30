package com.example.carshop.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.carshop.R
import com.example.carshop.utils.Add_Utils
import com.example.carshop.utils.Category_utils
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_publication.*
import kotlinx.android.synthetic.main.activity_publication.iv_pub_image
import kotlinx.android.synthetic.main.activity_publication.mv_location
import kotlinx.android.synthetic.main.activity_publication.tv_pub_add
import kotlinx.android.synthetic.main.activity_publication_edit.*
import java.io.Serializable


public class PublicationActivity : AppCompatActivity() , Serializable, OnMapReadyCallback{
    private var people = ArrayList<String>()
    private var fabDecition : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publication)
         people = intent.getStringArrayListExtra("publication")
        initDesign(people,applicationContext)
        mv_location.onCreate(savedInstanceState)
        mv_location.getMapAsync(this)


        if (fabDecition){
            val fab = findViewById<FloatingActionButton>(R.id.fab)
            fab.setOnClickListener {
                onClickFabEdit(it)
            }
        }else {
            val fab2 = findViewById<FloatingActionButton>(R.id.fab_save)
            fab2.setOnClickListener {
                onClickFabSave(it)
            }
        }

    }


    fun onClickFabSave(view: View){
        val et_mark : String = et_pub_mark.text.toString()
        val et_model : String  = et_pub_model.text.toString()
        val et_type : String  = et_pub_type.text.toString()
        val et_time : String  = et_pub_time.text.toString()
        val et_description : String  = et_pub_description.text.toString()

        onBackPressed()
    }

    fun onClickFabEdit(view: View){

        setContentView(R.layout.activity_publication_edit)
        fabDecition= false;
    }

    fun initDesign(list : ArrayList<String>,context : Context){

        Glide.with(context).load(list[0]).into(iv_pub_image)
        tv_pub_mark.text  = list[1]
        tv_pub_model.text = list[2]
        tv_pub_type.text = Category_utils.getCategory_type(list[3].toLong())

        if(list[3].toInt() == 1){
            fab.visibility = View.GONE
        }

        tv_pub_time.text = list[5] + "Años"
        if (list[4].equals("false")){
            tv_pub_time.visibility=View.GONE
            tv_pub_use.text = "NUEVO"}else{
            tv_pub_use.text = "USADO"
        }
        tv_pub_description.text = list[6]

        when (list[3].toInt()) {
            1 -> tv_pub_add.text = Add_Utils.electronicCar(intent, context)
            2 -> tv_pub_add.text = Add_Utils.truckCar()
            3 -> tv_pub_add.text = Add_Utils.commercialCar()
            else -> { // Note the block
            }
        }

        }

    override fun onMapReady(mMap: GoogleMap) {

        mMap.setOnMapClickListener { // Animating to the touched position
            mMap.animateCamera(CameraUpdateFactory.newLatLng(com.google.android.gms.maps.model.LatLng(4.60971,-74.08175)));

            mMap.addMarker(
                MarkerOptions().position(com.google.android.gms.maps.model.LatLng(4.60971,-74.08175))
                    .title("Bogotá D.C."))

            val latling = com.google.android.gms.maps.model.LatLng(4.60971,-74.08175)
            mMap.addMarker(MarkerOptions().position(latling)).title = "Bogotá D.C."
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latling, 15F))
        }
    }

}