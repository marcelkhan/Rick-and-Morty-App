package com.marcelkhan.rickandmortyapp.network


import retrofit2.http.GET
import com.marcelkhan.rickandmortyapp.model.characters.Character

interface ApiService {
    @GET(Constants.CHARACTER_ENDPOINT)
    suspend fun getCharacters(): Character
}