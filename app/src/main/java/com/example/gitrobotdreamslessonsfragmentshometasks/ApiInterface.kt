package com.example.gitrobotdreamslessonsfragmentshometasks

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("/superhero-api/api/all.json")
    suspend fun getSuperHeroesByCR():SuperHeroDataResponse
}