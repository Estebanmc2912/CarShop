package com.example.carshop.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carshop.R
import com.example.carshop.model.Car_Model
import com.example.carshop.utils.Category_utils
import com.example.carshop.view.PublicationActivity
import kotlinx.android.synthetic.main.list_element.view.*
import java.io.Serializable

class MainAdapter (private val context:Context, private val bundle: Bundle?): RecyclerView.Adapter<MainAdapter.MainViewHolder>() , Serializable{

    private var dataList = mutableListOf<Car_Model>()

    fun setListData (data:MutableList<Car_Model>){
        dataList = data;
    }

    /// inner class to guide life-ciclying's MainAdapter
    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) , Serializable{

        fun bindView(publication: Car_Model){
            Glide.with(context).load(publication.image).into(itemView.civ_card)
            itemView.tv_card_marca.text = publication.mark
            itemView.tv_card_model.text = context.getString(R.string.model) + " "+ publication._model
            itemView.tv_card_type.text  = context.getString(R.string.type) + " " + Category_utils.getCategory_type(publication.category)
            if (publication.used){ itemView.tv_card_use.text = "USADO"} else {itemView.tv_card_use.text="NUEVO"}

            ///when the item view is selected
            itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, PublicationActivity::class.java)
                //val obj = bundle!!.getSerializable("Car_Model") as Car_Model
                //intent.putExtra("Car_Model", publication)
                context.startActivity(intent)
            })


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(dataList.size>0){dataList.size}else{0}
    }

    /// data reciver
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val publication: Car_Model = dataList[position];
        holder.bindView(publication)
    }


}