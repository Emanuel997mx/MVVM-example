package com.emanuel.mvvmexample.data.network

import com.emanuel.mvvmexample.data.model.CharacterListModel
import com.emanuel.mvvmexample.data.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/api/character/")
    suspend fun getAllCharacters(): Response<CharacterListModel>
}