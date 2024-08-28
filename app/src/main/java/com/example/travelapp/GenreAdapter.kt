package com.example.travelapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenreAdapter(var genres:List<GenreData>) : RecyclerView.Adapter<GenreAdapter.cardHolder>(){

    inner class cardHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardHolder {
        val view= LayoutInflater.from(parent.context).inflate(
            R.layout.travel_genre,
            parent,
            false
        )
        return cardHolder(view)
    }

    override fun onBindViewHolder(holder: cardHolder, position: Int) {
        holder.itemView.apply {
            var genreImage=findViewById<ImageView>(R.id.genreImage)
            var genreText=findViewById<TextView>(R.id.genreText)
            genreImage.setImageResource(genres[position].image)
            genreText.text= genres[position].genre
        }
    }

    override fun getItemCount(): Int {
        return genres.size
    }
}