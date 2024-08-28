package com.example.travelapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NearbyPlaceAdapter(var nearbyPlaces:List<NearbyCityData>) :RecyclerView.Adapter<NearbyPlaceAdapter.nearbyPlaceHolder>(){

    inner class nearbyPlaceHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): nearbyPlaceHolder {
        val view= LayoutInflater.from(parent.context).inflate(
            R.layout.nearby_places,
            parent,
            false
        )
        return nearbyPlaceHolder(view)
    }

    override fun getItemCount(): Int {
        return nearbyPlaces.size
    }

    override fun onBindViewHolder(holder: nearbyPlaceHolder, position: Int) {
        holder.itemView.apply {
            var ivNearbyCityImage=findViewById<ImageView>(R.id.ivNearbyCityImage)
            var tvNearbyCityName=findViewById<TextView>(R.id.tvNearbyCityName)
            var tvTemp=findViewById<TextView>(R.id.tvTemp)
            var tvRating=findViewById<TextView>(R.id.tvRating)
            var tvWalk=findViewById<TextView>(R.id.tvWalk)

            ivNearbyCityImage.setImageResource(nearbyPlaces[position].image)
            tvNearbyCityName.text=nearbyPlaces[position].name
            tvTemp.text=nearbyPlaces[position].temp
            tvRating.text=nearbyPlaces[position].rating
            tvWalk.text=nearbyPlaces[position].walk
        }
    }
}