package com.example.carshop.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.carshop.R
import com.example.carshop.model.Car_Model
import java.io.Serializable

public class PublicationActivity : AppCompatActivity() , Serializable{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publication)

        //  var people = intent.getSerializableExtra("Car_Model") as Car_Model

        /*Glide.with(this).load(people.i1).into(media_image1)
        t1.text = people.t1
        t2.text = people.t*/2

    }


}