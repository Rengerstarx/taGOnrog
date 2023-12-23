package com.example.taganroggo

data class User(val login: String,
                val name: String,
                val photo: MutableList<String>,
                val tags: MutableList<String>,
                val time: String,
                val visitors: MutableList<String>,
                val latitude: Double,
                val longitude: Double)
