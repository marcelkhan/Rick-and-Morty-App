package com.marcelkhan.rickandmortyapp.repository

import com.marcelkhan.rickandmortyapp.network.ApiService
import com.marcelkhan.rickandmortyapp.model.characters.Character
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCharacters(): Character {
        return apiService.getCharacters()
    }
}