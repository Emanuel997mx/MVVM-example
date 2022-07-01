package com.emanuel.mvvmexample.data.network

import android.util.Log
import com.emanuel.mvvmexample.data.model.CharacterListModel
import com.emanuel.mvvmexample.data.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService {
    private val retrofit = RetrofitBuilder.getRetrofit()

    suspend fun getCharacters(): CharacterListModel{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).getAllCharacters()
            Log.d("Retro",response.toString())
            response.body()?: CharacterListModel()
        }
    }
}