package com.emanuel.mvvmexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emanuel.mvvmexample.data.model.CharacterModel
import com.emanuel.mvvmexample.data.model.CharacterProvider
import com.emanuel.mvvmexample.domain.GetCharactersUseCase
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {

    val characterModel = MutableLiveData< CharacterModel>()
    val getCharactersUseCase = GetCharactersUseCase()

    fun onCreate(){
        viewModelScope.launch{
            val result = getCharactersUseCase()
            if(!result.isNullOrEmpty()){
                characterModel.postValue(result[0])
            }
        }
    }

    fun anyCharacter(){
        val character = CharacterProvider.characters.random()
        characterModel.postValue(character)
    }
}