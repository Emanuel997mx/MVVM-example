package com.emanuel.mvvmexample.data.model

import com.emanuel.mvvmexample.data.network.CharacterService

class CharacterRepository {
    private val api = CharacterService()

    suspend fun getAllCharacters(): List<CharacterModel>{
        val response = api.getCharacters()
        CharacterProvider.characters = response.results
        return response.results
    }
}