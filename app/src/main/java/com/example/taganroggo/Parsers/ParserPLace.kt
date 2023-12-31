package com.example.taganroggo.Parsers

import com.example.taganroggo.Data.Place
import com.google.firebase.database.DataSnapshot


class ParserPLace {

    fun parsPalce(dataSnapshot: DataSnapshot): Place {
        val photos = mutableListOf<String>()
        val tags = mutableListOf<String>()
        val visitors = mutableListOf<String>()
        for (partnerSnapshot in dataSnapshot.child("Photo").children) {
            photos.add(partnerSnapshot.value.toString())
        }
        for (partnerSnapshot in dataSnapshot.child("Tags").children) {
            tags.add(partnerSnapshot.value.toString())
        }
        for (partnerSnapshot in dataSnapshot.child("Visitors").children) {
            visitors.add(partnerSnapshot.value.toString())
        }
        val place = Place(
            adress = dataSnapshot.child("Addres").value.toString(),
            name = dataSnapshot.child("Name").value.toString(),
            photo = photos,
            tags = tags,
            time = dataSnapshot.child("Time").value.toString(),
            visitors = visitors,
            latitude = dataSnapshot.child("Latitude").value.toString().toDouble(),
            longitude = dataSnapshot.child("Longitude").value.toString().toDouble(),
            info = dataSnapshot.child("Info").value.toString(),
            id = dataSnapshot.key.toString().toInt()
        )
        return place
    }

    fun parsPalces(dataSnapshot: MutableList<DataSnapshot>): MutableList<Place> {
        val places = mutableListOf<Place>()
        dataSnapshot.forEach { it ->
            val photos = mutableListOf<String>()
            val tags = mutableListOf<String>()
            val visitors = mutableListOf<String>()
            for (partnerSnapshot in it.child("Photo").children) {
                photos.add(partnerSnapshot.value.toString())
            }
            for (partnerSnapshot in it.child("Tags").children) {
                tags.add(partnerSnapshot.value.toString())
            }
            for (partnerSnapshot in it.child("Visitors").children) {
                visitors.add(partnerSnapshot.value.toString())
            }
            val place = Place(
                adress = it.child("Addres").value.toString(),
                name = it.child("Name").value.toString(),
                photo = photos,
                tags = tags,
                time = it.child("Time").value.toString(),
                visitors = visitors,
                latitude = it.child("Latitude").value.toString().toDouble(),
                longitude = it.child("Longitude").value.toString().toDouble(),
                info = it.child("Info").value.toString(),
                id = it.key.toString().toInt()
            )
            places.add(place)
        }
        return places
    }
}