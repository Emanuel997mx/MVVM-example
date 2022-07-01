package com.emanuel.mvvmexample.domain

import com.emanuel.mvvmexample.data.model.CharacterModel
import com.emanuel.mvvmexample.data.model.CharacterRepository

class GetCharactersUseCase {
    private val repository = CharacterRepository()

    suspend operator fun invoke(): List<CharacterModel>? = repository.getAllCharacters()
}