package com.example.travelapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreFragment: Fragment() {

    lateinit var rvGenre: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_explore,container,false)
        val context: Context =requireContext()

        //Genre selection recycler
        var genreList= listOf(
            GenreData(R.drawable.circleimage,"All"),
            GenreData(R.drawable.circleimage,"Spiritual"),
            GenreData(R.drawable.circleimage,"Beach"),
            GenreData(R.drawable.circleimage,"Hiking"),
            GenreData(R.drawable.circleimage,"Party"),
            GenreData(R.drawable.circleimage,"Mountains")
        )
        rvGenre=view.findViewById(R.id.rvGenre)
        val genreAdapter=GenreAdapter(genreList)
        rvGenre.adapter=genreAdapter
        rvGenre.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        //Spinner
        val spinner:Spinner=view.findViewById(R.id.spinner)
        val adapterspinner=ArrayAdapter.createFromResource(
            context,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapterspinner

        //Nearby cities recycler
        var nearbyPlacesList=listOf(
            NearbyCityData(R.drawable.mumbai,"City of Mumbai","32","4.5","60"),
            NearbyCityData(R.drawable.nagpur,"City of Nagpur","37","4.2","80"),
            NearbyCityData(R.drawable.nashiik,"City of Nashik","35","4.3","50"),
            NearbyCityData(R.drawable.pune,"City of Pune","21","4.7","90")
        )
        var rvNearbyPlaces=view.findViewById<RecyclerView>(R.id.rvNearbyPlaces)
        val nearbyPlaceAdapter=NearbyPlaceAdapter(nearbyPlacesList)
        rvNearbyPlaces.adapter=nearbyPlaceAdapter
        rvNearbyPlaces.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        return view
    }

}