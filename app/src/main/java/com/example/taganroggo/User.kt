package com.example.taganroggo

data class User(val mail: String,
                val name: String,
                val surname: String,
                val score: Int,
                val ava: String,
                val fon: String,
                val visits: MutableList<PlaceData>)
